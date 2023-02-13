<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name='layout' content='main'/>
    <title><g:message code="springSecurity.login.title"/></title>
    <asset:stylesheet src="academy-login.css"/>
</head>

<body>

<div class="login-box"
     style="display: flex;justify-content: center;text-align: center;margin-top:50px;margin-bottom: 50px">
    <div class="panel panel-info">
        <div class="panel-heading">
            <div class="panel-title"><g:message code="springSecurity.login.header"/></div>
        </div>

        <div style="padding-top:30px" class="panel-body">

            <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>

            <form id="loginform" action='${postUrl}' method='POST' class="form-horizontal" role="form">

                <div style="margin-bottom: 25px" class="input-group">
                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                    <input id="login-username" type="text" class="form-control" name="username" value=""
                           placeholder="<g:message code="springSecurity.login.email.label"/>">
                </div>

                <div style="margin-bottom: 25px" class="input-group">
                    <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                    <input id="login-password" type="password" class="form-control" name="password"
                           placeholder="<g:message code="springSecurity.login.password.label"/>">
                </div>


                <g:if test='${flash.message}'>
                    <div style="color:red">${flash.message}</div>
                </g:if>
                <div style="display: flex; justify-content: space-between; align-items: center">

                    <div style="display: flex; align-items: center">
                        <academyComponents:checkbox name="${rememberMeParameter}"
                                                    value="${hasCookie}"
                                                    label="${g.message(code: 'springSecurity.login.remember.me.label')}"/>
                    </div>

                    <input class="btn btn-success" type="submit" name="commit"
                           value="${message(code: "springSecurity.login.button")}">

                </div>

            </form>

        </div>
    </div>

</div>

<script type='text/javascript'>
    <!--
    (function () {
        document.forms['loginForm'].elements['email'].focus();
    })();
    // -->
</script>
</body>
</html>
