<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form:form method="post" action="/emplSave">
    <table>
        <tr>
            <td>FirstName:</td>
            <td><input type="text" name="employeeFirstName"/></td>
            <td>SecondName:</td>
            <td><input type="text" name="employeeSecondName"/></td>
            <td><input type="hidden" name="depID" value="${depID}"/></td>
        </tr>

        <tr>
            <td colspan="4"><input type="submit" /></td>
        </tr>
    </table>
</form:form>
</body>
</html>
