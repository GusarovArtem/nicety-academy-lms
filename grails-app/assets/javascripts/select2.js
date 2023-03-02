function createSelect(element, options) {
    if (options.url == null) throw "no url";
    if (options.placeholder == null) throw "no placeholder";

    var opts = _.defaults({}, options, {
        multiple: false,
        urlParams: {},
        allowClear: false,
        disabled: false,
        mapTermAsHeadOption: function (term) {
        },
        onChange: function () {
        },
        mapResult: function (r) {
            return {
                id: r.id,
                text: r.name
            }
        }
    });
    
    $(element).select2(
        {
            nextSearchTerm: function(selectedObject, currentSearchTerm) {
                return currentSearchTerm;
            },
            multiple: opts.multiple,
            closeOnSelect: !opts.multiple,
            placeholder: opts.placeholder,
            initSelection: function (element, callback) {
                callback({id: element.value, text: opts.initText});
            },
            createSearchChoice: opts.mapTermAsHeadOption,
            allowClear: opts.allowClear,
            dropdownAutoWidth: true,
            separator: '&&&',
            dropdownCss: {
                'max-width': '700px'
            },
            ajax: {
                url: opts.url,
                dataType: 'json',
                data: function (term, page) {
                    return _.extend({}, opts.urlParams, {
                        term: term,
                        page: page
                    });
                },
                results: function (data, page, query) {
                    return {
                        results: _.map(data.results, function (it) {
                            return _.extend(opts.mapResult(it), {data: it});
                        }),
                        more: data.total > 20 * page
                    };
                }
            }
        }).on("change", function () {
        if (opts.onChange == null) {
            return
        }
        opts.onChange($(this).select2('data'));
    });
    
    if (opts.disabled) {
        $(element).select2('readonly', true);
    }
}
