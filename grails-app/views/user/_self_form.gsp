<%@ page import="academy.user.AcademyUser" %>

<academyField:formField bean="${userInstance}"
                   originalEntity="${AcademyUser}"
                   required="true"
                   field="name">
    <g:textField name="name" required="required" value="${userInstance?.name}"/>
</academyField:formField>

<academyField:formField bean="${userInstance}"
                   originalEntity="${AcademyUser}"
                   required="true"
                   field="surname">
    <g:textField name="surname" required="required" value="${userInstance?.surname}"/>
</academyField:formField>

<academyField:formField bean="${userInstance}"
                   originalEntity="${AcademyUser}"
                   field="email">
    <g:textField name="email" value="${userInstance?.email}"/>
</academyField:formField>

<academyField:formField bean="${userInstance}"
                   originalEntity="${AcademyUser}"
                   field="dateOfBirth">
    <g:textField name="dateOfBirth" value="${userInstance?.dateOfBirth}"/>
</academyField:formField>

<academyField:formField bean="${userInstance}"
                   originalEntity="${AcademyUser}"
                   field="phoneNumber">
    <g:textField name="phoneNumber" value="${userInstance?.phoneNumber}"/>
</academyField:formField>

<academyField:formField bean="${userInstance}"
                   originalEntity="${AcademyUser}"
                   field="location">
    <g:textField name="location" value="${userInstance?.location}"/>
</academyField:formField>

<academyField:formField bean="${userInstance}"
                   originalEntity="${AcademyUser}"
                   field="englishLevel">
    <g:textField name="englishLevel" value="${userInstance?.englishLevel}"/>
</academyField:formField>

<academyField:formField bean="${userInstance}"
                   originalEntity="${AcademyUser}"
                   required="true"
                   field="password">
    <g:passwordField name="password" required="" value="${userInstance?.password}"/>
</academyField:formField>

<academyField:formField bean="${userInstance}"
                   originalEntity="${AcademyUser}"
                   required="true"
                   field="passwordConfirm">
    <g:passwordField name="passwordConfirm" required="" value="${userInstance?.passwordConfirm}"/>
</academyField:formField>
