<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: abonent63
  Date: 22.10.16
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <caption>Employees</caption>
    <tr>
        <th colspan="5">${department.id}  ${department.name}</th>
    </tr>
    <c:forEach var="employee" items="${birthday}">
    <td align="center">${employee.id}</td>
    <td align="center">${employee.firstName}</td>
    <td align="center">${employee.secondName}</td>

    </c:forEach>
</body>
</html>
