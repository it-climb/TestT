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
<center>
    <form:form method="post" action ="/emplSave">
    <table width="400">
        <tr>
            <td width="40">${empl.id}</td>
            <td>
                <input width="200px" type="text" name = "employeeFirstName" placeholder="${empl.firstName}"
                       autofocus required>
            </td>
            <td>
                <input width="200px" type="text" name = "employeeSecondName" placeholder="${empl.secondName}"
                       autofocus required>
            </td>
            <td>
                <input width="200px" type="text" name = "employeePhone" placeholder="${empl.phone}"
                       autofocus required>
            </td>
            <td>
                <input width="200px" type="text" name = "employeeEmail" placeholder="${empl.email}"
                       autofocus required>
            </td>
        </tr>
    </table>
        <input width="200px" type = "submit" value ="Rename">
        <input width="0px" type="hidden" name = "emplID" value="${empl.id}">
        <input width="0px" type="hidden" name="depID" value=${depID}>
    </form:form>
</center>
</body>
</html>
