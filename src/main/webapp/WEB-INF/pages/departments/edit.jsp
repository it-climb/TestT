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
    <title>Edit DEPARTMENT</title>
</head>
<body>
<center>
<table width="400">
<tr>
    <td width="40" height="60px"><b>ID</b></td>
    <td width="320"><b>Name</b></td>
</tr>
<tr>
    <td width="40">${dep.id}</td>
    <td>
    <form:form method="post" action ="/depSave">
        <input width="200px" type="text" name = "departmentName" placeholder="${dep.name}" autofocus required>
        <input width="200px" type = "submit" value ="Rename">
        <input width="0px" type="hidden" name = "id" value="${dep.id}">
        <%--<input type="hidden" name="depID" value="${depID}"/>--%>
    </form:form>
    </td>
</tr>
</table>
</center>
</body>
</html>
