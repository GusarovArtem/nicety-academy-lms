<%@ page import="academy.product.price.AcademyProductPrice; academy.product.course.AcademyCourse; academy.product.course.AcademyCourseType;" %>

<academyField:formField bean="${courseInstance}"
                   originalEntity="${AcademyCourse}"
                   required="true"
                   field="tittle">
    <g:textField name="tittle" required="required" value="${courseInstance?.tittle}"/>
</academyField:formField>

<academyField:formField bean="${courseInstance}"
                   originalEntity="${AcademyCourse}"
                   required="true"
                   field="description">
    <g:textField name="description" required="required" value="${courseInstance?.description}"/>
</academyField:formField>


<academyField:formField bean="${courseInstance}"
                        originalEntity="${AcademyCourse}"
                        field="courseType"
                        required="true">

    <select name="courseType">
        <g:each in="${AcademyCourseType.all}" var="type">
            <option value="${type.id}">${type.tittle}</option>
        </g:each>
    </select>
</academyField:formField>

<academyField:formField bean="${courseInstance}"
                        originalEntity="${AcademyCourse}"
                        field="coursePrice"
                        required="true">
    <g:textField name="coursePrice.price"
                 required="required"
                 value="${courseInstance?.coursePrice?.price}"/>
    <select name="courseType">
        <g:each in="${AcademyProductPrice.Currency}" var="currency">
            <option value="${currency}">${currency}</option>
        </g:each>
    </select>
</academyField:formField>



<academyField:formField bean="${courseInstance}"
                   originalEntity="${AcademyCourse}"
                   field="active">
    <academyComponents:checkbox name="active" value="${courseInstance?.active}"/>
</academyField:formField>




