<%@ page import="academy.product.course.group.Group; academy.product.course.group.AcademyGroup" %>

<field:formField bean="${groupInstance}"
                   originalEntity="${academy.product.course.group.Group}"
                   required="true"
                   field="name">
    <g:textField name="name" required="required" value="${groupInstance?.name}"/>
</field:formField>

<field:formField bean="${groupInstance}"
                   originalEntity="${Group}"
                   field="maxStudentAmount">
    <g:textField name="maxStudentAmount" value="${groupInstance?.maxStudentAmount}"/>
</field:formField>

<field:formField bean="${groupInstance}"
                   originalEntity="${Group}"
                   field="groupType">
    <g:textField name="groupType" value="${groupInstance?.groupType}"/>
</field:formField>





