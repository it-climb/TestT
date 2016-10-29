<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addOrUpdate</title>
</head>
<body>
<form:form method="post" action="/empSave">
    <table>
        <tr>
            <td>Name:</td>
            <td>
                <input type="text" name="firstName">
                <input type="text" name="secondName">
                <input type="hidden" name="id_department" value="${employees.id}">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="submit">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
