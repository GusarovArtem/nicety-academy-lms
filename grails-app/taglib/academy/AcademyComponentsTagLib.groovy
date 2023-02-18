package academy

class AcademyComponentsTagLib implements AcademyTagLibTrait  {

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

    def valOrAbsentWithLabel = { attrs, body ->
        def value = attrs.value
        if (value instanceof Boolean) {
            value = value ? "Yes" : "No"
        } else if (value instanceof Date) {
            value = value.format('dd-MM-yyyy HH:mm')
        }

        out << elementWithLabel(attrs) {
            valOrAbsent(value: value)
        }
    }

    def valOrAbsent = { attrs, body ->
        if (attrs.value) {
            markup.span(class: attrs.class, style: attrs.style) {
                mkp.yield attrs.value
            }
        } else {
            out << absent(attrs)
        }
    }

    def absent = { attrs, body ->
        markup.span(class: 'absent', style: attrs.style) {
            mkp.yield(attrs.label ?: 'None')
        }
    }

    def elementWithLabel = { attrs, body ->
        def label = ""
        if (attrs.label) {
            label = attrs.label
        } else if (attrs.messageLabel) {
            label = g.message(code: attrs.messageLabel)
        }
        out << """
            <div class="">
                <span class="">
                    $label
                </span> 
                <span class="">
                    ${body.call()}
                </span>       
            </div>
        """
    }


}