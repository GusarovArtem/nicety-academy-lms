<%@ page import="grails.util.GrailsNameUtils" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityMessageBase" value="${GrailsNameUtils.getPropertyNameConvention(courseTypeInstance)}"/>
    <g:set var="entityName" value="${message(code: "${entityMessageBase}.label", default: 'CourseType')}"/>
    <title>${entityName}: ${courseTypeInstance.tittle}</title>
</head>

<body>

<buttons:buttonToolbar style="margin: 0 0 10px 10px">

    <buttons:buttonGroup>
        <buttons:index/>
        <buttons:create/>
        <buttons:edit id="${courseTypeInstance.id}"/>
    </buttons:buttonGroup>

</buttons:buttonToolbar>

<div>
    <messages:showFlash flash="${flash}" bean="${[courseTypeInstance]}"/>

    <div style="display: flex; padding: 10px 0 10px 0;">

        <div id="show-course" class="content scaffold-show" role="main">
            <h1>${entityName}: ${courseTypeInstance.tittle}</h1>

            <ol class="property-list course">
                <components:valOrAbsentWithLabel messageLabel="courseType.tittle.label"
                                                        value="${courseTypeInstance.tittle}"/>

                <components:valOrAbsentWithLabel messageLabel="courseType.code.label"
                                                        value="${courseTypeInstance.code}"/>
            </ol>

        </div>

        <div style="flex: 2 7 0;">
            %{-- TODO show groups --}%
        </div>

    </div>

</div>
</body>
</html>
