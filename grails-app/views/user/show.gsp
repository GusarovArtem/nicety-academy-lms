<%@ page import="grails.util.GrailsNameUtils" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityMessageBase" value="${GrailsNameUtils.getPropertyNameConvention(userInstance)}"/>
    <g:set var="entityName" value="${message(code: "${entityMessageBase}.label", default: 'AcademyUser')}"/>
    <title>${entityName}: ${userInstance.fullname()}</title>
</head>

<body>

<academyButtons:buttonToolbar style="margin: 0 0 10px 10px">

    <academyButtons:buttonGroup>
        <academyButtons:index/>
        <academyButtons:create/>
        <academyButtons:edit id="${userInstance.id}"/>
    </academyButtons:buttonGroup>

</academyButtons:buttonToolbar>

<div>
    <academyMessages:showFlash flash="${flash}" bean="${[userInstance]}"/>

    <div style="display: flex; padding: 10px 0 10px 0;">

        <div id="show-user" class="content scaffold-show" role="main">
            <h1>${entityName}: ${userInstance.fullname()}</h1>

            <academyMessages:showFlash flash="${flash}" bean="${userInstance}"/>

            <ol class="property-list user">

                <academyComponents:valOrAbsentWithLabel messageLabel="academyUser.name.label"
                                                        value="${userInstance.name}"/>

                <academyComponents:valOrAbsentWithLabel messageLabel="academyUser.surname.label"
                                                        value="${userInstance.surname}"/>

                <academyComponents:valOrAbsentWithLabel messageLabel="academyUser.email.label"
                                                        value="${userInstance.email}"/>

                <academyComponents:valOrAbsentWithLabel messageLabel="academyUser.createdOn.label"
                                                        value="${userInstance.createdOn}"/>

                <academyComponents:valOrAbsentWithLabel messageLabel="academyUser.dateOfBirth.label"
                                                        value="${userInstance.dateOfBirth}"/>

                <academyComponents:valOrAbsentWithLabel messageLabel="academyUser.phoneNumber.label"
                                                        value="${userInstance.phoneNumber}"/>

                <academyComponents:valOrAbsentWithLabel messageLabel="academyUser.englishLevel.label"
                                                        value="${userInstance.englishLevel?.label}"/>

                <academyComponents:valOrAbsentWithLabel messageLabel="academyUser.location.label"
                                                        value="${userInstance.location}"/>

                <academyComponents:valOrAbsentWithLabel messageLabel="academyUser.enabled.label"
                                                        value="${userInstance.enabled}"/>

            </ol>

        </div>

        <div style="flex: 2 7 0;">
            %{-- TODO show courses in which active --}%
        </div>

    </div>

</div>
</body>
</html>
