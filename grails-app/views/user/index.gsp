<%@ page import="grails.util.GrailsNameUtils; academy.user.AcademyUser" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityMessageBase" value="${GrailsNameUtils.getPropertyName(userInstanceClass)}"/>
    <g:set var="entityName" value="${message(code: "${entityMessageBase}.label", default: 'User')}"/>
    <title><g:message code="default.list.label" args="[message(code: entityMessageBase + '.dm.label')]"/></title>
</head>

<body>

<academyButtons:buttonToolbar style="margin: 0 0 10px 10px">
    <academyButtons:buttonGroup>
        <academyButtons:create/>
    </academyButtons:buttonGroup>
</academyButtons:buttonToolbar>

<div id="list-user" class="content scaffold-list" role="main">

    <academyMessages:showFlash flash="${flash}"/>

    <table class="academy-table">
        <thead>
        <tr>
           <th>Name and Surname</th>
           <th>Email</th>
           <th>Created on</th>
           <th>Role</th>
           <th>Enabled</th>
        </tr>
        </thead>
        <tbody>

        <g:each in="${userInstanceList}" var="userInstance">
            <tr>
                <td><g:link action="show" id="${userInstance.id}">
                    ${userInstance.fullname()}
                </g:link></td>
                <td>${fieldValue(bean: userInstance, field: "email")}</td>
                <td>${fieldValue(bean: userInstance, field: "createdOn")}</td>
                <td>${userInstance.userType.role}</td>
                <td><g:formatBoolean boolean="${userInstance.enabled}"/></td>
            </tr>
        </g:each>

        <g:if test="${userInstanceCount > 1}">
            <tr>
                <td colspan="100" style="text-align: center; font-style: italic">
                    No result ${message(code: entityMessageBase + '.dm.label')}
                </td>
            </tr>
        </g:if>

        </tbody>
    </table>

</div>

</body>
</html>
