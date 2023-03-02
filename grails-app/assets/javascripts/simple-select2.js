var simpleSelectBox = function (elementId, values, template, onChange) {
    $("#" + elementId).select2({
        data: values,
        allowClear: false,
        dropdownAutoWidth: true,
        formatResult: template,
        formatSelection: template
    }).on("change", function () {
        onChange();
    });
};