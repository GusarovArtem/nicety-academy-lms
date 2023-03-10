<%@ page import="academy.product.course.group.AcademyGroup" %>

<academyField:formField bean="${groupInstance}"
                   originalEntity="${AcademyGroup}"
                   required="true"
                   field="name">
    <g:textField name="name" required="required" value="${groupInstance?.name}"/>
</academyField:formField>

<academyField:formField bean="${groupInstance}"
                   originalEntity="${AcademyGroup}"
                   field="maxStudentAmount">
    <g:textField name="maxStudentAmount" value="${groupInstance?.maxStudentAmount}"/>
</academyField:formField>

<academyField:formField bean="${groupInstance}"
                   originalEntity="${AcademyGroup}"
                   field="groupType">
    <g:textField name="groupType" value="${groupInstance?.groupType}"/>
</academyField:formField>





