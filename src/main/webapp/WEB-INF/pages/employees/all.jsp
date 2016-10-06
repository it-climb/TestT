<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
    <link rel="stylesheet" href="/resources/css/outputEmp.css" type="text/css">
    <title>Employeers</title>
</head>
<body>
    <table>
        <tr>
            <td>name</td>
            <td>surname</td>
            <td>patronymic</td>
            <td>mail</td>
            <td>birthday</td>
            <td>tel</td>
            <td>position</td>
            <td>department</td>
            <td>project</td>
            <td>registration</td>

        </tr>
<c:forEach var="employee" items="${employeers}">
        <tr>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td>${employee.patronymic}</td>
            <td>${employee.mail}</td>
            <td>${employee.birthday}</td>
            <td>${employee.tel}</td>
            <td>${employee.position}</td>
            <td>${employee.department}</td>
            <td>${employee.project}</td>
            <td>${employee.registration}</td>
    </tr>
</c:forEach>
    </table>

</body>
</html>
