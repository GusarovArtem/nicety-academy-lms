<%@ page import="academy.user.AcademyUser" %>

<academyForm:field bean="${userInstance}"
                   originalEntity="${AcademyUser}"
                   required="true"
                   field="name">
    <g:textField name="name" required="required" value="${userInstance?.name}"/>
</academyForm:field>

<academyForm:field bean="${userInstance}"
                   originalEntity="${AcademyUser}"
                   required="true"
                   field="surname">
    <g:textField name="surname" required="required" value="${userInstance?.surname}"/>
</academyForm:field>

<academyForm:field bean="${userInstance}"
                   originalEntity="${AcademyUser}"
                   field="email">
    <g:textField name="email" value="${userInstance?.email}"/>
</academyForm:field>

<academyForm:field bean="${userInstance}"
                   originalEntity="${AcademyUser}"
                   field="dateOfBirth">
    <g:textField name="dateOfBirth" value="${userInstance?.dateOfBirth}"/>
</academyForm:field>

<academyForm:field bean="${userInstance}"
                   originalEntity="${AcademyUser}"
                   field="phoneNumber">
    <g:textField name="phoneNumber" value="${userInstance?.phoneNumber}"/>
</academyForm:field>

<academyForm:field bean="${userInstance}"
                   originalEntity="${AcademyUser}"
                   field="location">
    <g:textField name="location" value="${userInstance?.location}"/>
</academyForm:field>

<academyForm:field bean="${userInstance}"
                   originalEntity="${AcademyUser}"
                   field="englishLevel">
    <g:textField name="englishLevel" value="${userInstance?.englishLevel}"/>
</academyForm:field>

<academyForm:field bean="${userInstance}"
                   originalEntity="${AcademyUser}"
                   required="true"
                   field="password">
    <g:passwordField name="password" required="" value="${userInstance?.password}"/>
</academyForm:field>

<academyForm:field bean="${userInstance}"
                   originalEntity="${AcademyUser}"
                   required="true"
                   field="passwordConfirm">
    <g:passwordField name="passwordConfirm" required="" value="${userInstance?.passwordConfirm}"/>
</academyForm:field>
