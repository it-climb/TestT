<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 9/28/15
  Time: 4:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table width="400">
    <tr>
        <td width="400"><b>Old name Employeet</b></td>
    </tr>
    <tr>
        <td width="40" height="60px"><b>ID</b></td>
        <td width="40">${empl.id}</td>
        <td width="320">${empl.firstName}</td>
        <td width="320">${empl.secondName}</td>
    </tr>
    <tr>
        <td width="400px"><b>New name Employee!!!</b></td>
    </tr>
    <tr>
        <td>
            <form:form method="post" action ="/emplSave">
                <input width="200px" type="text" name = "employeeFirstName">
                <input width="200px" type="text" name = "employeeSecondName" >
                <input width="200px" type = "submit" value ="Create new Name">
                <input width="0px" type="hidden" name = "id" value="${empl.id}">
                <input width="0px" type="hidden" name="depID" value=${depID}>

            </form:form>
        </td>
    </tr>
</table>
</body>
</html>
