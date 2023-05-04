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

<buttons:buttonToolbar style="margin: 0 0 10px 10px">

    <buttons:buttonGroup>
        <buttons:index/>
        <buttons:create/>
        <buttons:edit id="${courseInstance.id}"/>
    </buttons:buttonGroup>

</buttons:buttonToolbar>

<div>
    <messages:showFlash flash="${flash}" bean="${[courseInstance]}"/>

    <div style="display: flex; padding: 10px 0 10px 0;">

        <div id="show-course" class="content scaffold-show" role="main">
            <h1>${entityName}: ${courseInstance.tittle}</h1>

            <ol class="property-list course">
                <components:valOrAbsentWithLabel messageLabel="academyCourse.tittle.label"
                                                        value="${courseInstance.tittle}"/>

                <components:valOrAbsentWithLabel messageLabel="academyCourse.description.label"
                                                        value="${courseInstance.description}"/>

                <components:valOrAbsentWithLabel messageLabel="academyCourse.createdOn.label"
                                                        value="${courseInstance.createdOn}"/>

                <components:valOrAbsentWithLabel messageLabel="academyCourse.courseType.label"
                                                        value="${message(code:  courseInstance.courseType.tittle)}"/>

                <components:valOrAbsentWithLabel messageLabel="academyCourse.active.label"
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
