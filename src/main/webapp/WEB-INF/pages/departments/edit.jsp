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
            <td> <input type="text" name="name"  value="${editDepartment.name}" <p>(Length from 3 to 10 characters are allowed digits from 0 to 9)</p></td>
        </tr>

        <tr>
            <td>Phone number:</td>
            <td><input type="text" name="depPhone" value="${editDepartment.depPhone}" <p>(Example +380951234567)</p></td>
        </tr>
        <td><input type="hidden" name = "id" value="${editDepartment.id}"/> </td>
        <tr>
            <td colspan="2">
                <input type="submit" />
            </td>
        </tr>
    </table>
</form:form>

<a href="/dep"> <button> Back to list of departments </button> </a>
</body>
</html>

