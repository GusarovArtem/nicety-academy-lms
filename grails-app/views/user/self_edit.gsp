<%@ page import="grails.util.GrailsNameUtils;" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title>${message(code: "self_edit.label")}</title>
</head>

<body>

<div id="edit-user" class="content scaffold-edit" role="main">
    <h1>${message(code: "self_edit.label")}</h1>

    <academyMessages:showFlash flash="${flash}" bean="${userInstance}"/>

    <g:form url="[resource: userInstance, action: 'selfUpdate']" method="PUT">
        <fieldset class="form">
            <g:render template="/user/self_form"/>

            <div class='fieldcontain'>
                <label></label>
                <academyButtons:submitSave/>
            </div>
        </fieldset>
    </g:form>
</div>
</body>
</html>
