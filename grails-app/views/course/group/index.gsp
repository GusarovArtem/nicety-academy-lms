<%@ page import="academy.user.student.AcademyStudent; academy.course.group.AcademyGroup; grails.util.GrailsNameUtils;" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityMessageBase" value="${GrailsNameUtils.getPropertyName(groupInstanceClass)}"/>
    <g:set var="entityName" value="${message(code: "${entityMessageBase}.label", default: 'Course')}"/>
    <title><g:message code="default.list.label" args="[message(code: entityMessageBase + '.dm.label')]"/></title>
</head>

<body>

<academyButtons:buttonToolbar style="margin: 0 0 10px 10px">
    <academyButtons:buttonGroup>
        <academyButtons:create/>
    </academyButtons:buttonGroup>
</academyButtons:buttonToolbar>

<div id="list-group" class="content scaffold-list" role="main">

    <academyMessages:showFlash flash="${flash}"/>

    <table class="academy-table">
        <thead>
        <tr>
           <th>Name</th>
           <th>Created on</th>
           <th>Type</th>
           <th>Max Student Amount</th>
           <th>Student Amount</th>
        </tr>
        </thead>
        <tbody>

        <g:each in="${groupInstanceList}" var="groupInstance">
            <tr>
                <td><g:link action="show" id="${groupInstance.id}">
                    ${fieldValue(bean: groupInstance, field: "name")}
                </g:link></td>
                <td>${fieldValue(bean: groupInstance, field: "createdOn")}</td>
                <td>${fieldValue(bean: groupInstance, field: "maxStudentAmount")}</td>
                <td>${message(code: groupInstance.groupType)}</td>
                <td>${fieldValue(bean: groupInstance, field: "maxStudentAmount")}</td>
                <td>${groupInstance.students?.size()}</td>
            </tr>
        </g:each>

        <g:if test="${groupInstanceCount > 1}">
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
