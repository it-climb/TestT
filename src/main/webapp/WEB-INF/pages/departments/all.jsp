<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Departments</title>
  <link rel="stylesheet" href="/resources/styles/departments/All.css" type="text/css">
</head>
<center>
<table>
<caption>Departments</caption>
<tr>
    <th align="center">DepID</th>
    <th align="center">DepName</th>
    <th colspan="3"></th>
</tr>
<c:forEach var="department" items="${departments}">
<tr>
    <td align="center">${department.id}</td>
    <td align="center">${department.name}</td>
    <form:form method ="post" action ="/depDel">
    <td>
        <input type="submit" value="Delete" />
        <input type="hidden" name = "id" value="${department.id}">
    </td>
    </form:form>
    <form:form method ="get" action ="/depEdit">
    <td>
        <input type="submit" value="Edit" />
        <input type="hidden" name = "id" value="${department.id}">
    </td>
    </form:form>
    <form:form method ="get" action ="/allEmplInDep">
    <td>
        <input type="submit" value="Employees" />
        <input type="hidden" name = "depID" value="${department.id}">
    </td>
    </form:form>
</tr>
</c:forEach>
<tr>
    <td colspan="5", align="center">
        <form:form action="/depAdd" method="get">
           <input type="submit" value="Add new Dep">
        </form:form>
    </td>
</tr>
</table>
</center>
<body>
</body>
</html>
