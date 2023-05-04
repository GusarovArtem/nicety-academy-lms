<%@ page import="grails.util.GrailsNameUtils" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityMessageBase" value="${GrailsNameUtils.getPropertyNameConvention(groupInstance)}"/>
    <g:set var="entityName" value="${message(code: "${entityMessageBase}.label", default: 'Course')}"/>
    <title>${entityName}: ${groupInstance.name}</title>
</head>

<body>

<buttons:buttonToolbar style="margin: 0 0 10px 10px">

    <buttons:buttonGroup>
        <buttons:index/>
        <buttons:create/>
        <buttons:edit id="${groupInstance.id}"/>
    </buttons:buttonGroup>

</buttons:buttonToolbar>

<div>
    <messages:showFlash flash="${flash}" bean="${[groupInstance]}"/>

    <div style="display: flex; padding: 10px 0 10px 0;">

        <div id="show-group" class="content scaffold-show" role="main">
            <h1>${entityName}: ${groupInstance.name}</h1>

            <messages:showFlash flash="${flash}" bean="${groupInstance}"/>

            <ol class="property-list course">
                <components:valOrAbsentWithLabel messageLabel="academyGroup.name.label"
                                                        value="${groupInstance.name}"/>

                <components:valOrAbsentWithLabel messageLabel="academyGroup.createdOn.label"
                                                        value="${groupInstance.createdOn}"/>

                <components:valOrAbsentWithLabel messageLabel="academyGroup.type.label"
                                                        value="${message(code:  groupInstance.groupType)}"/>

                <components:valOrAbsentWithLabel messageLabel="academyGroup.maxStudentAmount.label"
                                                        value="${message(code:  groupInstance.maxStudentAmount)}"/>
        </ol>

        </div>

        <div style="flex: 2 7 0;">
            %{-- TODO show groups --}%
        </div>

    </div>

</div>
</body>
</html>
