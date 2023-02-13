package academy

class AcademyComponentsTagLib {

    static namespace = "academyComponents"

    def checkbox = { attrs, body ->
        def params = [
                name : attrs.name,
                id   : attrs.id ?: attrs.name,
                value: attrs.value
        ]
        if (attrs.disabled) {
            params << [disabled: 'disabled']
        }
        out << """
                <div class="pretty p-icon p-curve p-bigger">
                    ${g.checkBox(params)}
                    <div class="state p-primary">
                        <i class="icon fa fa-check"></i>                  
                        <label style='width: auto; ${attrs.style}'>
                            ${attrs.label ?: body.call()}
                        </label>
                    </div>
                </div>
        """
    }

}