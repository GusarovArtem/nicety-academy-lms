<%@ page import="academy.product.course.CourseType; academy.product.course.Course; academy.product.price.AcademyProductPrice; academy.product.course.AcademyCourse; academy.product.course.AcademyCourseType;" %>

<field:formField bean="${courseInstance}"
                   originalEntity="${Course}"
                   required="true"
                   field="tittle">
    <g:textField name="tittle" required="required" value="${courseInstance?.tittle}"/>
</field:formField>

<field:formField bean="${courseInstance}"
                   originalEntity="${Course}"
                   required="true"
                   field="description">
    <g:textField name="description" required="required" value="${courseInstance?.description}"/>
</field:formField>


<field:formField bean="${courseInstance}"
                        originalEntity="${Course}"
                        field="courseType"
                        required="true">

    <select name="courseType">
        <g:each in="${academy.product.course.CourseType.all}" var="type">
            <option value="${type.id}">${type.tittle}</option>
        </g:each>
    </select>
</field:formField>

<field:formField bean="${courseInstance}"
                        originalEntity="${academy.product.course.Course}"
                        field="coursePrice"
                        required="true">
    <g:textField name="coursePrice.price"
                 required="required"
                 value="${courseInstance?.coursePrice?.price_usd}"/>
</field:formField>



<field:formField bean="${courseInstance}"
                   originalEntity="${Course}"
                   field="active">
    <components:checkbox name="active" value="${courseInstance?.active}"/>
</field:formField>




