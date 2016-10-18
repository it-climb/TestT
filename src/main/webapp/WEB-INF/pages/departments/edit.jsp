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
<table>
    <tr>
        <td><b>ID</b></td>
        <td align="center"><b>Name</b></td>
    </tr>
    <form:form method="post" action ="/depSave">
    <tr>
        <td>${dep.id}</td>
        <td>
            <input type="text" name = "departmentName" placeholder="${dep.name}" autofocus required>
        </td>
    </tr>
    <tr>
        <td colspan="2", align="center">
        <input type = "submit" value ="Rename">
        <input width="0px" type="hidden" name = "id" value="${dep.id}">
        </td>
    </tr>
    </form:form>

</table>
</center>
</body>
</html>
