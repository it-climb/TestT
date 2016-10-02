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
<table width="400">
<tr>
    <td width="400"><b>Old name Department</b></td>
</tr>
<tr>
    <td width="40" height="60px"><b>ID</b></td>
    <td width="40">${dep.id}</td>
    <td width="320">${dep.name}</td>
</tr>
<tr>
    <td width="400px"><b>New name Departmen!!!</b></td>
</tr>
<tr>
    <td>
    <form:form method="post" action ="/depSave">
        <input width="200px" type="text" name = "departmentName" >
        <input width="200px" type = "submit" value ="Create new Name">
        <input width="0px" type="hidden" name = "id" value="${empl.id}">
        <input type="hidden" name="depID" value="${depID}"/>
    </form:form>
    </td>
</tr>
</table>

<%--<a href="/depSave?id=${dep.id}"/>--%>
</body>
</html>
