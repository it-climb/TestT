<%@ taglib prefix="em" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table width="600px">
    <tr>
        <td><b>FirstName</b></td>
        <td><b>SecondName</b></td>
    </tr>
    <em:forEach var="employee" items="${employees}">
        <tr>
            <td>${employees.firstName}</td>
            <td>${employees.secondName}</td>
        </tr>
    </em:forEach>
    <tr>
        <td colspan="5">
            <form method="get" action="/empAdd">
                <input type="hidden" name="id" value="${null}"/>
                <input type="submit" value="Insert new employees"/>
            </form>
        </td>
    </tr>
</table>
</body>
</html>
