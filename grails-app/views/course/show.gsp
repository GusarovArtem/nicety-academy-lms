<%@ page import="grails.util.GrailsNameUtils" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityMessageBase" value="${GrailsNameUtils.getPropertyNameConvention(courseInstance)}"/>
    <g:set var="entityName" value="${message(code: "${entityMessageBase}.label", default: 'Course')}"/>
    <title>${entityName}: ${courseInstance.tittle}</title>
</head>

<body>

<academyButtons:buttonToolbar style="margin: 0 0 10px 10px">

    <academyButtons:buttonGroup>
        <academyButtons:index/>
        <academyButtons:create/>
        <academyButtons:edit id="${courseInstance.id}"/>
    </academyButtons:buttonGroup>

</academyButtons:buttonToolbar>

<div>
    <academyMessages:showFlash flash="${flash}" bean="${[courseInstance]}"/>

    <div style="display: flex; padding: 10px 0 10px 0;">

        <div id="show-course" class="content scaffold-show" role="main">
            <h1>${entityName}: ${courseInstance.tittle}</h1>

            <academyMessages:showFlash flash="${flash}" bean="${courseInstance}"/>

            <ol class="property-list course">
                <academyComponents:valOrAbsentWithLabel messageLabel="academyCourse.tittle.label"
                                                        value="${courseInstance.tittle}"/>

                <academyComponents:valOrAbsentWithLabel messageLabel="academyCourse.description.label"
                                                        value="${courseInstance.description}"/>

                <academyComponents:valOrAbsentWithLabel messageLabel="academyCourse.createdOn.label"
                                                        value="${courseInstance.createdOn}"/>

                <academyComponents:valOrAbsentWithLabel messageLabel="academyCourse.courseType.label"
                                                        value="${message(code:  courseInstance.courseType.tittle)}"/>

                <academyComponents:valOrAbsentWithLabel messageLabel="academyCourse.active.label"
                                                        value="${courseInstance.active}"/>
            </ol>

        </div>

        <div style="flex: 2 7 0;">
            %{-- TODO show groups --}%
        </div>

    </div>

</div>
</body>
</html>
