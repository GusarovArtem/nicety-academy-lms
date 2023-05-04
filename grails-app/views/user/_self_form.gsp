<%@ page import="academy.user.User; academy.user.User" %>

<field:formField bean="${userInstance}"
                   originalEntity="${academy.user.User}"
                   required="true"
                   field="name">
    <g:textField name="name" required="required" value="${userInstance?.name}"/>
</field:formField>

<field:formField bean="${userInstance}"
                   originalEntity="${User}"
                   required="true"
                   field="surname">
    <g:textField name="surname" required="required" value="${userInstance?.surname}"/>
</field:formField>

<field:formField bean="${userInstance}"
                   originalEntity="${User}"
                   field="email">
    <g:textField name="email" value="${userInstance?.email}"/>
</field:formField>

<field:formField bean="${userInstance}"
                   originalEntity="${User}"
                   field="dateOfBirth">
    <g:textField name="dateOfBirth" value="${userInstance?.dateOfBirth}"/>
</field:formField>

<field:formField bean="${userInstance}"
                   originalEntity="${User}"
                   field="phoneNumber">
    <g:textField name="phoneNumber" value="${userInstance?.phoneNumber}"/>
</field:formField>

<field:formField bean="${userInstance}"
                   originalEntity="${User}"
                   field="location">
    <g:textField name="location" value="${userInstance?.location}"/>
</field:formField>

<field:formField bean="${userInstance}"
                   originalEntity="${User}"
                   field="englishLevel">
    <g:textField name="englishLevel" value="${userInstance?.englishLevel}"/>
</field:formField>

<field:formField bean="${userInstance}"
                   originalEntity="${User}"
                   required="true"
                   field="password">
    <g:passwordField name="password" required="" value="${userInstance?.password}"/>
</field:formField>

<field:formField bean="${userInstance}"
                   originalEntity="${User}"
                   required="true"
                   field="passwordConfirm">
    <g:passwordField name="passwordConfirm" required="" value="${userInstance?.passwordConfirm}"/>
</field:formField>
