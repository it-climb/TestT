<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
    <title>Edit</title>
</head>
<body>

<table width="600px">
    <c:forEach var="employee" items="${employee}">

        <tr>
        <td>Name </td>
        <td>${employee.name}</td>
    </tr>

    <tr>
        <td>Surname</td>
        <td>${employee.surname}</td>
    </tr>
    <tr>
        <td>Patronimyc </td>
        <td>${employee.patronimyc}</td>
    </tr>

    <tr>
        <td>Birthday</td>
        <td>${employee.birthday}</td>
    </tr>
    <tr>
        <td>Telephone</td>
        <td>${employee.tel_number}</td>
    </tr>
    <tr>
        <td>Mail</td>
        <td>${employee.mail}</td>
    </tr>
    <tr>
        <td>Department </td>
        <td>${employee.department}</td>
    </tr>

    <tr>
        <td>Position</td>
        <td>${employee.position}</td>
    </tr>
    <tr>
        <td>Date of registration</td>
        <td>${employee.date_of_registration}</td>
    </tr>

    <tr>
        <td>Current project</td>
        <td>${employee.current_project}</td>
    </tr>
    </c:forEach>
</table>

</body>
</html>
