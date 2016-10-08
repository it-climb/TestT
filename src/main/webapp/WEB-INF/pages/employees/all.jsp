<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html> class="no-js">
<head>
    <title>Employees</title>
</head>
<body>

<table border="1">
    <caption> Department's employees</caption>
    <tr>
        <th>id</th>
        <th>First name</th>
        <th>Second name</th>
        <th>Delete</th>
        <th>Edit</th>
    </tr>

    <c:forEach var="employee" items="${employees}">

        <tr>
            <td>${employee.id}</td>
            <td>${employee.firstName}</td>
            <td>${employee.secondName}</td>
            <td>
                <form:form method="post" action="/emplDelete">
                    <input type="hidden" name="id" value="${employee.id}">
                    <input type="submit" value="delete">
                </form:form>
            </td>
            <td>
                <form:form method="post" action="/emplEdit">
                    <input type="hidden" name="id" value="${employee.id}">
                    <input type="submit" value="edit">
                </form:form>
            </td>
        </tr>
    </c:forEach>

</table>

<a href="/emplAdd">Add new employee</a>


</body>


