<%@ page import="academy.course.group.AcademyGroup" %>

<academyForm:field bean="${groupInstance}"
                   originalEntity="${AcademyGroup}"
                   required="true"
                   field="name">
    <g:textField name="name" required="required" value="${groupInstance?.name}"/>
</academyForm:field>

<academyForm:field bean="${groupInstance}"
                   originalEntity="${AcademyGroup}"
                   field="maxStudentAmount">
    <g:textField name="maxStudentAmount" value="${groupInstance?.maxStudentAmount}"/>
</academyForm:field>

<academyForm:field bean="${groupInstance}"
                   originalEntity="${AcademyGroup}"
                   field="groupType">
    <g:textField name="groupType" value="${groupInstance?.groupType}"/>
</academyForm:field>





