<%@ page import="academy.course.AcademyCourse" %>

<academyForm:field bean="${courseInstance}"
                   originalEntity="${AcademyCourse}"
                   required="true"
                   field="tittle">
    <g:textField name="tittle" required="required" value="${courseInstance?.tittle}"/>
</academyForm:field>

<academyForm:field bean="${courseInstance}"
                   originalEntity="${AcademyCourse}"
                   required="true"
                   field="description">
    <g:textField name="description" required="required" value="${courseInstance?.description}"/>
</academyForm:field>

<academyForm:field bean="${courseInstance}"
                   originalEntity="${AcademyCourse}"
                   field="courseType">
    <g:textField name="courseType" value="${courseInstance?.courseType}"/>
</academyForm:field>

<academyForm:field bean="${courseInstance}"
                   originalEntity="${AcademyCourse}"
                   field="active">
    <academyComponents:checkbox name="active" value="${courseInstance?.active}"/>
</academyForm:field>




