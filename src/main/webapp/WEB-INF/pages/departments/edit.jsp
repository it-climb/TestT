<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: abonent63
  Date: 25.09.16
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit DEPARTMENT!!!!!</title>
</head>
<body>
<table width="400px">
<tr>
    <td width="400px"><b>Old name Department</b></td>
</tr>
<tr>
    <td width="40px" height="60px"><b>ID</b></td>
    <td width="40px">${dep.id}</td>
    <td width="320px">${dep.name}</td>
</tr>
<tr>
    <td width="400px"><b>New name Departmen!!!</b></td>
</tr>
</table><br/>
<form:form method="post" action ="/depSave">
    <input width="200px" type="text" name = "departmentName" >
    <input width="200" type = "submit" value ="Create new Name">
    <input width="0" type="hidden" name = "id" value="${dep.id}">
</form:form>
<%--<a href="/depSave?id=${dep.id}"/>--%>
</body>
</html>
