<%@ page import="academy.product.course.AcademyCourse; academy.product.course.AcademyCourse; academy.product.course.AcademyCourse; academy.product.course.AcademyCourse; academy.course.AcademyCourse; academy.product.course.AcademyCourseType" %>

<academyField:formField bean="${courseInstance}"
                   originalEntity="${academy.product.course.AcademyCourse}"
                   required="true"
                   field="tittle">
    <g:textField name="tittle" required="required" value="${courseInstance?.tittle}"/>
</academyField:formField>

<academyField:formField bean="${courseInstance}"
                   originalEntity="${academy.product.course.AcademyCourse}"
                   required="true"
                   field="description">
    <g:textField name="description" required="required" value="${courseInstance?.description}"/>
</academyField:formField>


<academyField:formField bean="${courseInstance}"
                        originalEntity="${academy.product.course.AcademyCourse}"
                        field="courseType"
                        required="true">

    <select name="courseType">
        <g:each in="${AcademyCourseType.all}" var="type">
            <option value="${type.id}">${type.tittle}</option>
        </g:each>
    </select>
</academyField:formField>



<academyField:formField bean="${courseInstance}"
                   originalEntity="${academy.product.course.AcademyCourse}"
                   field="active">
    <academyComponents:checkbox name="active" value="${courseInstance?.active}"/>
</academyField:formField>




