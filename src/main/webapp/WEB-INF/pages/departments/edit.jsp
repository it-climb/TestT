<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.js"></script>
    <script src="resources/js/departments.js"></script>
</head>
<body>
<form:form method="post" action="/depSave">
    <table>
        <tr>
            <td>Name:</td>
            <td><input id="departmentName" type="textarea" name="name" value="${department.name}" required/></td>
            <td><input type="hidden" name="id" value="${department.id}"></td>
        </tr>
        <tr>

        </tr>
        <tr>
            <td>
                <form:form method="post" action="/"></form:form>
            </td>
            <td colspan="2">
                <input type="submit" value="Update"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
