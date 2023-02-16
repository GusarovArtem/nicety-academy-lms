<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="Grails"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <asset:link rel="shortcut icon" href="logo/company-shortcut-logo.png" type="image/x-icon"/>

    <asset:stylesheet src="tracker-application.css"/>

    <asset:javascript src="tracker-application.js"/>

    <g:layoutHead/>
</head>

<body style="display: flex; flex-direction:column; min-height: 100vh">


<div style="flex: 1;">

    <div style="display: flex; justify-content: space-between; background-color: ${grailsApplication.config.tracker.badge_color}">
        <div>
            <asset:image alt="" src="logo/company-main-logo.png" style="padding: 10px 20px 10px 100px;"/>
        </div>
    </div>

    <sec:ifLoggedIn>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <g:render template="/menu/main_menu"/>

                    <div style="display: flex; flex-direction: row-reverse; padding: 10px 0">

                        <g:set var="academySecurityService" bean="academySecurityService" />

                        <div>
                            Signed in as <i style="color: green; margin-right: 10px;">
                    ${academySecurityService.currentUser().fullname()}</i>

                            <g:link controller='logout' style="color: #ff0000; background: #ffffff" class="btn">
                                <i class="fa fa-sign-out"></i> Sign out
                            </g:link>
                        </div>

                    </div>
                </div>
            </div>
        </nav>
    </sec:ifLoggedIn>



    <g:layoutBody/>

</div>

<footer>
    Nicety Academy LMS, created by <a href="https://github.com/GusarovArtem">Gusarov Artem</a>
</footer>


<asset:deferredScripts/>

</body>
</html>
