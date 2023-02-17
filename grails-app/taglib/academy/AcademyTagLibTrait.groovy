package academy

import groovy.xml.MarkupBuilder

import static org.apache.commons.lang3.StringUtils.isNotBlank

trait AcademyTagLibTrait {

    String randomId() {
        def uuid = UUID.randomUUID()
                .toString()
                .replace("-", "")
        "academyId_$uuid"
    }

    MarkupBuilder getMarkup() {
        internalMarkup(out)
    }

    def markup(@DelegatesTo(MarkupBuilder) Closure cls) {
        cls.delegate = internalMarkup(out)
        cls()
    }

    MarkupBuilder internalMarkup(output) {
        def builder = new MarkupBuilder(output)
        builder.omitNullAttributes = true
        builder.omitEmptyAttributes = true
        builder
    }

    def spacedValues(List<String> classes) {
        classes.findAll { isNotBlank(it) }.join(" ")
    }

    def require(attrs, String attr) {
        if (!attrs.containsKey(attr)) throw new IllegalArgumentException("no '$attr' attr")
    }

}