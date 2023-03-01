<%@ page import="academy.course.AcademyCourseType" %>

<academyForm:field bean="${courseTypeInstance}"
                   originalEntity="${AcademyCourseType}"
                   required="true"
                   field="tittle">
    <g:textField name="tittle" required="required" value="${courseTypeInstance?.tittle}"/>
</academyForm:field>

<academyForm:field bean="${courseTypeInstance}"
                   originalEntity="${AcademyCourseType}"
                   required="true"
                   field="code">
    <g:textField name="code" required="required" value="${courseTypeInstance?.code}"/>
</academyForm:field>

