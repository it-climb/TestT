<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table width="600px">
    <tr>
        <td><b>Name</b></td>
        <td><b>Surname</b></td>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.firstName}</td>
            <td>${employee.secondName}</td>
            <td>
                <a href="/emplAdd?employee_id=${employee.id}">Edit</a>
                |<a href="/emplDelete?employee_id=${employee.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td>
            <a href="/emplAdd?department_id=${department_id}">Add new employee</a>
        </td>
    </tr>
</table>
</body>
</html>