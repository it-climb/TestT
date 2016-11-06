<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 9/28/15
  Time: 4:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form:form method="post" action="/empSave">
    <table>
        <tr>
            <td>FirstName:</td>
            <td><input type="text" name="firstName" value="${employee.firstName}"/></td>
        </tr>
        <tr>
            <td>SecondName:</td>
            <td><input type="text" name="secondName" value="${employee.secondName}"/></td>
        </tr>
        <tr>
            <td>Depatment:</td>
            <c:forEach var="department" items="${departments}">
            <td><select name="depId">
                <option value="${department.id}"> ${department.name}  </option> </select></td>
            </c:forEach>
        </tr>
        <tr>
            <td colspan="2">
                <input type="hidden" name="employeeId" value="${employee.id}"/>
                <input type="submit" />
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
