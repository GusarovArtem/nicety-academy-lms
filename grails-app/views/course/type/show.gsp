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

<academyButtons:buttonToolbar style="margin: 0 0 10px 10px">

    <academyButtons:buttonGroup>
        <academyButtons:index/>
        <academyButtons:create/>
        <academyButtons:edit id="${courseTypeInstance.id}"/>
    </academyButtons:buttonGroup>

</academyButtons:buttonToolbar>

<div>
    <academyMessages:showFlash flash="${flash}" bean="${[courseTypeInstance]}"/>

    <div style="display: flex; padding: 10px 0 10px 0;">

        <div id="show-course" class="content scaffold-show" role="main">
            <h1>${entityName}: ${courseTypeInstance.tittle}</h1>

            <academyMessages:showFlash flash="${flash}" bean="${courseTypeInstance}"/>

            <ol class="property-list course">
                <academyComponents:valOrAbsentWithLabel messageLabel="academyCourseType.tittle.label"
                                                        value="${courseTypeInstance.tittle}"/>

                <academyComponents:valOrAbsentWithLabel messageLabel="academyCourseType.code.label"
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
