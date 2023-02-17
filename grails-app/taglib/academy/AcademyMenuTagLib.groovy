package academy

import grails.plugin.springsecurity.SpringSecurityUtils

class AcademyMenuTagLib implements AcademyTagLibTrait {

    static namespace = "academyMenu"

    def leaf = { attrs, body ->
        if (!attrs.access || SpringSecurityUtils.ifAnyGranted(attrs.access)) {
            def lnk = g.createLink(controller: attrs.controller)
            def cls = request.forwardURI == lnk ? "class='active'" : ""
            out << """
                <li $cls><a href="${lnk}">${attrs.title}</a></li>
            """
        }
    }

    def branch = { attrs, body ->
        if (!attrs.access || SpringSecurityUtils.ifAnyGranted(attrs.access)) {
            out << """
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false">${attrs.title}<span class="caret"></span></a>
                <ul class="dropdown-menu">
                     ${body.call()}   
                </ul>
            </li>
            """
        }
    }


}
