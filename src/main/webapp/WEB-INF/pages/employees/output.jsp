<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <td>mail</td>
    </tr>
    <c:forEach var="employee" items="${employeers}">
        <tr>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td>${employee.mail}</td>
            <td>
                <form method="post" action="/deleteEmpl">
                    <input type="hidden" name="id" value="${employee.id}"/>
                    <input type="submit" value="Delete"/>
                </form>
            </td>
            <td>
                <form method="post" action="/empEditForm">
                    <input type="hidden" name="idDep" value="${department.id}"/>
                    <input type="hidden" name="idEmp" value="${employee.id}"/>
                    <input type="submit" value="Edit"/>
                </form>
            </td>

        </tr>
    </c:forEach>
</table>



</body>
</html>
