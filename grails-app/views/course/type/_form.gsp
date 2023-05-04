<%@ page import="academy.product.course.CourseType" %>

<field:formField bean="${courseTypeInstance}"
                   originalEntity="${CourseType}"
                   required="true"
                   field="tittle">
    <g:textField name="tittle" required="required" value="${courseTypeInstance?.tittle}"/>
</field:formField>

<field:formField bean="${courseTypeInstance}"
                   originalEntity="${CourseType}"
                   required="true"
                   field="code">
    <g:textField name="code" required="required" value="${courseTypeInstance?.code}"/>
</field:formField>

