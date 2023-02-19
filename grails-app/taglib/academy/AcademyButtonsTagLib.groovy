package academy

class AcademyButtonsTagLib implements AcademyTagLibTrait {

    static namespace = "academyButtons"

    def buttonToolbar = { attrs, body ->
        markup.div(class: "btn-toolbar", style: attrs.style) {
            mkp.yieldUnescaped body()
        }
    }

    def buttonGroup = { attrs, body ->
        markup.div(class: spacedValues(["btn-group", attrs.class]), style: attrs.style) {
            mkp.yieldUnescaped body()
        }
    }

    def index = { attrs, body ->

        def attrsMap = [
                action: "index",
                class : "btn btn-default",
                style : "color: black",
        ] + attrs

        out << g.link(attrsMap) {
            """<i class="fa fa-angle-double-left"></i> To List"""
        }
    }

    def create = { attrs, body ->
        out << g.link(controller: attrs.controller,
                action: "create", class: "btn", style: "color: black") {
            """<i class="fa fa-plus"></i> ${attrs.label ?: 'Create'}"""
        }
    }

    def edit = { attrs, body ->
        out << custom(attrs + [action: "edit", icon: "edit",
                               title: "Edit",
                               style: "color: black",
                               btnClass: "btn-primary ${attrs.btnClass ?: ''}"], body)
    }

    def show = { attrs, body ->
        out << g.link(controller: attrs.controller, action: "show", id: attrs.id, class: "btn btn-info", style: "color: white") {
            """<i class="fa fa-file-text-o"></i> Szczegóły"""
        }
    }

    def custom = { attrs, body ->
        def pars = [
                elementId : attrs.elementId,
                controller: attrs.controller,
                action    : attrs.action,
                onclick   : attrs.onclick,
                url       : attrs.url,
                id        : attrs.id,
                params    : attrs.params,
                'class'   : "btn ${attrs.btnClass ?: ''}",
                style     : "color: black; text-decoration: none; ${attrs.style ?: ''}"
        ]

        if (attrs.disabled) pars << [disabled: "${attrs.disabled}"]

        out << g.link(pars) {
            """<i class="fa fa-${attrs.icon}"></i> ${attrs.title}"""
        }
    }

    def submitCreate = { attrs, body ->
        out << submit(attrs + [title: "Utwórz", icon: "plus", class: spacedValues(["btn-success", attrs.class])])
    }

    def submitSave = { attrs, body ->
        out << submit(attrs + [title: "Zaktualizuj", icon: "save", class: attrs.class])
    }

    def submit = { attrs, body ->
        def elementId = randomId()

        markup.button(id: elementId,
                type: 'submit',
                disabled: attrs.disabled,
                class: spacedValues(['btn btn-primary', attrs.class]),
                style: attrs.style) {
            span(class: attrs.labelClass) {
                i(class: "fa fa-${attrs.icon}", '')
                mkp.yield " $attrs.title"
            }
            mkp.yieldUnescaped body()
        }

        //language=html
        if (attrs.confirmation) {
            out << """
                    <script>
                    academyQtipyElementWithConfirmation(
                        '#${elementId}', 
                        'javascript:\$("#${elementId}").closest("form").submit()', 
                        '${attrs.position ?: ''}', 
                        false, 
                        '');
                    </script>
            """
        }
    }

}
