<%@ page import="grails.util.GrailsNameUtils;" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityMessageBase" value="${GrailsNameUtils.getPropertyNameConvention(groupInstance)}"/>
    <g:set var="entityName" value="${message(code: "${entityMessageBase}.label", default: 'Course')}"/>
    <title><g:message code="default.edit.label" args="[message(code: entityMessageBase + '.label')]"/></title>
</head>

<body>

<academyButtons:buttonToolbar style="margin: 0 0 10px 10px">
    <academyButtons:buttonGroup>
        <academyButtons:index/>
        <academyButtons:create/>
        <academyButtons:show id="${groupInstance.id}"/>
    </academyButtons:buttonGroup>
</academyButtons:buttonToolbar>

<div id="edit-group" class="content scaffold-edit" role="main">
    <h1><g:message code="default.edit.label" args="[message(code: entityMessageBase + '.label')]"/></h1>

    <academyMessages:showFlash flash="${flash}" bean="${groupInstance}"/>

    <g:form url="[resource: groupInstance, action: 'update']" method="PUT">
        <fieldset class="form">
            <g:render template="/course/group/form"/>

            <div class='fieldcontain'>
                <label></label>
                <academyButtons:submitSave/>
            </div>

        </fieldset>
    </g:form>
</div>
</body>
</html>
