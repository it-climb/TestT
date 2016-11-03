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
            <td>Firstname:</td>
            <td><input type="text" name="firstName"/></td>
            <td>Secondname:</td>
            <td><input type="text" name="secondName" /></td>
            <%--<td><input type="hidden" name="id" value="${employees.id}"/></td>--%>
            <td><input type="hidden" name="depId" value="${depId}"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" />
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
