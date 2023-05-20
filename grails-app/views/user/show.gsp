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

<buttons:buttonToolbar style="margin: 0 0 10px 10px">

    <buttons:buttonGroup>
        <buttons:index/>
        <buttons:create/>
        <buttons:edit id="${userInstance.id}"/>
    </buttons:buttonGroup>

</buttons:buttonToolbar>

<div>
    <messages:showFlash flash="${flash}" bean="${[userInstance]}"/>

    <div style="display: flex; padding: 10px 0 10px 0;">

        <div id="show-user" class="content scaffold-show" role="main">
            <h1>${entityName}: ${userInstance.fullname()}</h1>
            <ol class="property-list user">

                <components:valOrAbsentWithLabel messageLabel="user.name.label"
                                                        value="${userInstance.name}"/>

                <components:valOrAbsentWithLabel messageLabel="user.surname.label"
                                                        value="${userInstance.surname}"/>

                <components:valOrAbsentWithLabel messageLabel="user.email.label"
                                                        value="${userInstance.email}"/>

                <components:valOrAbsentWithLabel messageLabel="user.createdOn.label"
                                                        value="${userInstance.createdOn}"/>

                <components:valOrAbsentWithLabel messageLabel="user.dateOfBirth.label"
                                                        value="${userInstance.dateOfBirth}"/>

                <components:valOrAbsentWithLabel messageLabel="user.phoneNumber.label"
                                                        value="${userInstance.phoneNumber}"/>

                <components:valOrAbsentWithLabel messageLabel="user.englishLevel.label"
                                                        value="${userInstance.englishLevel?.label}"/>

                <components:valOrAbsentWithLabel messageLabel="user.location.label"
                                                        value="${userInstance.location}"/>

                <components:valOrAbsentWithLabel messageLabel="user.enabled.label"
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
