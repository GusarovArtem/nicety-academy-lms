package academy.trait

import grails.util.GrailsNameUtils
import grails.web.api.WebAttributes

trait AcademyControllerTrait implements WebAttributes {

    def targetDomainClass() {}

    void showMessage(String target, String code, String defaultCode) {
        flash.message =
                message(code: code,
                        args: [ message(code: GrailsNameUtils.getPropertyName(targetDomainClass()) + '.dp.label',
                                default: defaultCode), target ]
                )
    }

    def notFound() {
        showMessage(params.id, "default.not.found.message")

        redirect action: "index", method: "GET"
    }

}