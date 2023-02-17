package academy

import grails.util.GrailsNameUtils

class AcademyFormTagLib implements AcademyTagLibTrait {

    static namespace = "academyForm"

    def field = { attrs, body ->
        if (attrs.removeIf) {
            return
        }

        def style = attrs.style ?: ''
        if (attrs.readonly) {
            style += " opacity: 0.6;"
        }
        def labelStyle = attrs.labelStyle ?: ''

        out << "<div id='${attrs.id ?: randomId()}' class='fieldcontain ${hasErrors(bean: attrs.bean, field: attrs.field, 'error')}' style='${style}'>"
        out << "<label for='${attrs.field}' style='$labelStyle'>"

        def entityClass = attrs.bean.class
        if (attrs.originalEntity != null) {
            entityClass = attrs.originalEntity
        }

        if (attrs.label == null && attrs.labelCode == null) {
            def isAssociation = entityClass.gormPersistentEntity.associations.find {
                it.associatedEntity.getDecapitalizedName() == attrs.field
            } != null

            def prefixLabelCode = isAssociation ? "" : "${GrailsNameUtils.getPropertyName(entityClass)}."

            out << g.message(code: "${prefixLabelCode}${attrs.field}.label")
        } else {
            if (attrs.label) {
                out << attrs.label
            } else {
                out << g.message(code: attrs.labelCode)
            }
        }

        if (attrs.required == "true") {
            out << "<span class='required-indicator'>*</span>"
        }

        out << "</label>"
        out << body.call()
        out << "</div>"
    }


}
