<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<header>
    <div align="right">User:<security:authentication property="principal.username"/></div>
    <table>
        <td><a href="/home">Home</a></td>
        <td><a href="/dep">Departments</a></td>
        <security:authorize access="isAnonymous()">
            <td><a href="/login">Login</a></td>
        </security:authorize>
        <security:authorize access="isAuthenticated()">
            <td><a href="/logout">Logout</a></td>
        </security:authorize>
        <security:authorize access="hasRole('ROLE_ADMIN')">
            <td><a href="/users">Users</a></td>
        </security:authorize>
    </table>
</header>
<sf:form modelAttribute="userDetails" method="POST" action="/userSaveEdited">
    <table>
        <tr>
            <input type="hidden" value="${id}" name="id"/>
            <th><sf:label path="firstName">First Name:</sf:label></th>
            <td><sf:input path="firstName"/><br>
                <sf:errors path="firstName"/>
            </td>
        </tr>
        <tr>
            <th><sf:label path="lastName">Last Name:</sf:label></th>
            <td><sf:input path="lastName"/><br>
                <sf:errors path="lastName"/>
            </td>
        </tr>
        <tr>
            <th><sf:label path="email">e-mail:</sf:label></th>
            <td><sf:input path="email"/><br>
                <sf:errors path="email"/>
            </td>
        </tr>
        <tr>
            <th><sf:label path="phone">Phone:</sf:label></th>
            <td><sf:input path="phone"/><br>
                <sf:errors path="phone"/>
            </td>
        </tr>
        <tr>
            <th><sf:label path="birthdayDate">Birthday Date:</sf:label></th>
            <td><sf:input path="birthdayDate"/><br>
                <sf:errors path="birthdayDate"/>
            </td>
        </tr>
        <tr>
            <th><sf:label path="registrationDate">Registration Date:</sf:label></th>
            <td><sf:input path="registrationDate"/><br>
                <sf:errors path="registrationDate"/>
            </td>
        </tr>
        <tr>
            <th><sf:label path="sex">Sex:</sf:label></th>
            <td>
                <%--<sf:label path="sex">${userDetails.sex}</sf:label>--%>
                <sf:select path="sex">
                    <sf:option value="MALE"/>
                    <sf:option value="FEMALE"/>
                </sf:select><br>
                <sf:errors path="sex"/>
            </td>
        </tr>
        <tr>
            <td colspan="6">
                <input type="submit" value="Edit User">
            </td>
        </tr>
    </table>
</sf:form>

</body>
</html>
