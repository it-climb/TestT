<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form:form method="post" action="/depSave">
    <table>
        <tr>
            <td>Name:</td>
            <td>
                <input type="text" name="name" value="${department.name}"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="hidden" name="id" value="${department.id}">
                <input type="submit" value="submit"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
