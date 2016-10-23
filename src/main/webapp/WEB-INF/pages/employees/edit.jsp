<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <form:form method="post" action ="/emplSave" modelAttribute="employee">
    <table width="400">
        <tr>
            <td align="center">Empl ID</td>
            <td align="center">${employee.id}</td>

        </tr>
        <tr>
            <td align="center">Firtst Name:</td>
            <td>
                <input type="text" name = "firstName" placeholder="${employee.firstName}" autofocus required>
            </td>
        </tr>
        <tr>
            <td align="center">Second Name:</td>
            <td>
                <input type="text" name = "secondName" placeholder="${employee.secondName}" autofocus required>
            </td>
        </tr>
        <tr>
            <td align="center">Phone Number:</td>
            <td>
                <input type="text" name = "phone" placeholder="${employee.phone}" autofocus required>
            </td>
        </tr>
        <tr>
            <td align="center">E-mail:</td>
            <td>
                <input type="text" name = "email" placeholder="${employee.email}" autofocus required>
            </td>
        </tr>
        <tr>
            <td align="center">Date of Birth:</td>
            <td><input type="text" name="dateOfBirth" placeholder="${employee.dateOfBirth}" autofocus required/></td>
        </tr>
        <tr>
            <td align="center">Gender:</td>
            <td><input type="text" name="gender" placeholder="${employee.gender}" autofocus required/></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input width="200px" type = "submit" value ="Rename">
                <input width="0px" type="hidden" name = "id" value="${employee.id}">
                <input width="0px" type="hidden" name="depID" value=${depID}>
            </td>
        </tr>
    </table>
    </form:form>
    <div>
        <c:forEach var="violation" items="${violations}">
            <p>
                    ${violation.message}
            </p>
        </c:forEach>
    </div>
</center>
</body>
</html>
