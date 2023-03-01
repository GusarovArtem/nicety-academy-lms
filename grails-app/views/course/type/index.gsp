<%@ page import="grails.util.GrailsNameUtils;" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityMessageBase" value="${GrailsNameUtils.getPropertyName(courseTypeInstanceClass)}"/>
    <g:set var="entityName" value="${message(code: "${entityMessageBase}.label", default: 'CourseType')}"/>
    <title><g:message code="default.list.label" args="[message(code: entityMessageBase + '.dm.label')]"/></title>
</head>

<body>

<academyButtons:buttonToolbar style="margin: 0 0 10px 10px">
    <academyButtons:buttonGroup>
        <academyButtons:create/>
    </academyButtons:buttonGroup>
</academyButtons:buttonToolbar>

<div id="list-course" class="content scaffold-list" role="main">

    <academyMessages:showFlash flash="${flash}"/>

    <table class="academy-table">
        <thead>
        <tr>
           <th>Tittle</th>
           <th>Code</th>
        </tr>
        </thead>
        <tbody>

        <g:each in="${courseTypeInstanceList}" var="courseTypeInstance">
            <tr>
                <td><g:link action="show" id="${courseTypeInstance.id}">
                    ${fieldValue(bean: courseTypeInstance, field: "tittle")}
                </g:link></td>
                <td>${fieldValue(bean: courseTypeInstance, field: "code")}</td>
            </tr>
        </g:each>

        <g:if test="${courseTypeInstanceCount > 1}">
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
