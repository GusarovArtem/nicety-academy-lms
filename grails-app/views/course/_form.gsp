<%@ page import="academy.course.AcademyCourse" %>

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

%{--<academyField:formField bean="${courseInstance}"--}%
%{--                   field="courseType"--}%
%{--                   required="true">--}%
%{--    <academyField:select selector="courseType"--}%
%{--              name="courseType"--}%
%{--              initValue="${courseInstance.courseType?.id}"--}%
%{--              initText="${courseInstance.courseType?.tittle}"/>--}%
%{--</academyField:formField>--}%

<academyField:formField bean="${courseInstance}"
                        originalEntity="${AcademyCourse}"
                        field="courseType"
                        required="true">

    <academyField:select selector="courseType"
                         name="courseType"
                         initValue="${courseInstance.courseType?.id}"
                         initText="${courseInstance.courseType?.tittle}"/>
</academyField:formField>



<academyField:formField bean="${courseInstance}"
                   originalEntity="${AcademyCourse}"
                   field="active">
    <academyComponents:checkbox name="active" value="${courseInstance?.active}"/>
</academyField:formField>




