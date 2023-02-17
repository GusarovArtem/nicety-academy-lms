package academy

import academy.utils.Collections


class AcademyMessagesTagLib implements AcademyTagLibTrait  {

    static namespace = "academyMessages"

    def showFlash = { attrs, body ->
        def flash = attrs.flash

        def beanErrors = false
        if (attrs.bean) {
            if (Collections.isCollectionOrArray(attrs.bean)) {
                attrs.bean.each {
                    if (it.hasErrors()) {
                        beanErrors = true
                    }
                }
            } else {
                beanErrors = attrs.bean.hasErrors()
            }
        }

        def areThereAnyMessages = false;
        if (flash.messages || flash.message || flash.error_messages || beanErrors) {
            areThereAnyMessages = true;
        }
        out << "<div id='server_messages'>"

        if (flash.messages || flash.message) {
            out << "<ul class='message'>"

            if (flash.messages) {
                out << flash.messages.each {
                    "<li>${it}</li>"
                }
            }

            if (flash.message) {
                out << "<li>${flash.message}</li>"
            }
            out << "</ul>"
        }

        if (flash.error_messages || beanErrors) {

            out << "<ul class='errors'>"

            if (flash.error_messages) {
                out << flash.error_messages.each {
                    "<li>${it}</li>"
                }
            }

            if (beanErrors) {
                if (Collections.isCollectionOrArray(attrs.bean)) {
                    attrs.bean.each {
                        out << g.eachError(bean: it) {
                            "<li>${g.message(error: it)}</li>"
                        }
                    }
                } else {
                    out << g.eachError(bean: attrs.bean) {
                        "<li>${g.message(error: it)}</li>"
                    }
                }
            }
            out << "</ul>"
        }
        out << "</div>"
        out << "<ul id='client_messages' class='errors' style='display: none;'></ul>"

    }


}
