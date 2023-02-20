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

<academyButtons:buttonToolbar style="margin: 0 0 10px 10px">

    <academyButtons:buttonGroup>
        <academyButtons:index/>
        <academyButtons:create/>
        <academyButtons:edit id="${groupInstance.id}"/>
    </academyButtons:buttonGroup>

</academyButtons:buttonToolbar>

<div>
    <academyMessages:showFlash flash="${flash}" bean="${[groupInstance]}"/>

    <div style="display: flex; padding: 10px 0 10px 0;">

        <div id="show-group" class="content scaffold-show" role="main">
            <h1>${entityName}: ${groupInstance.name}</h1>

            <academyMessages:showFlash flash="${flash}" bean="${groupInstance}"/>

            <ol class="property-list course">
                <academyComponents:valOrAbsentWithLabel messageLabel="academyGroup.name.label"
                                                        value="${groupInstance.name}"/>

                <academyComponents:valOrAbsentWithLabel messageLabel="academyGroup.createdOn.label"
                                                        value="${groupInstance.createdOn}"/>

                <academyComponents:valOrAbsentWithLabel messageLabel="academyGroup.type.label"
                                                        value="${message(code:  groupInstance.groupType)}"/>

                <academyComponents:valOrAbsentWithLabel messageLabel="academyGroup.maxStudentAmount.label"
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
