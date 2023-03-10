<%@ page import="academy.product.course.AcademyCourseType" %>

<academyField:formField bean="${courseTypeInstance}"
                   originalEntity="${AcademyCourseType}"
                   required="true"
                   field="tittle">
    <g:textField name="tittle" required="required" value="${courseTypeInstance?.tittle}"/>
</academyField:formField>

<academyField:formField bean="${courseTypeInstance}"
                   originalEntity="${AcademyCourseType}"
                   required="true"
                   field="code">
    <g:textField name="code" required="required" value="${courseTypeInstance?.code}"/>
</academyField:formField>

