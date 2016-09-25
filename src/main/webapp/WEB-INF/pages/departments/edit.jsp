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
            <td><input type="text" name="name" value="${editDepartment.name}"/></td>
        </tr>
        <td><input type="hidden" name = "id" value="${editDepartment.id}"/> </td>
        <tr>
            <td colspan="2">
                <input type="submit" />
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
