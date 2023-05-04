<%@ page import="grails.util.GrailsNameUtils" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityMessageBase" value="${GrailsNameUtils.getPropertyNameConvention(courseTypeInstance)}"/>
    <g:set var="entityName" value="${message(code: "${entityMessageBase}.label", default: 'CourseType')}"/>
    <title><g:message code="default.create.label" args="[message(code: entityMessageBase + '.label')]"/></title>
</head>

<body>

<buttons:buttonToolbar style="margin: 0 0 10px 10px">
    <buttons:buttonGroup>
        <buttons:index/>
    </buttons:buttonGroup>
</buttons:buttonToolbar>

<div id="create-course" class="content scaffold-create" role="main">
    <h1><g:message code="default.create.label" args="[message(code: entityMessageBase + '.label')]"/></h1>

    <messages:showFlash flash="${flash}" bean="${courseTypeInstance}"/>

    <g:form url="[resource: courseTypeInstance, action: 'save']">
        <fieldset class="form">
            <g:render template="/course/type/form"/>

            <div class='fieldcontain'>
                <label></label>
                <buttons:submitCreate/>
            </div>
        </fieldset>
    </g:form>
</div>
</body>
</html>
