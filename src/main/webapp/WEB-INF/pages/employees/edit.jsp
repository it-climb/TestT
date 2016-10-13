<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees</title>
</head>
<body>
<form:form method="post" action="/emplSave">
    <table>
        <tr>
            <td>First name:</td>
            <td><input type="text" name="firstName" value="${employee.firstName}"
                <p> Employee's names must contain uppercase and lowercase characters </p>  </td>
        <tr> </tr>
        <td>Second name:</td>
        <td><input type="text" name="secondName" value="${employee.secondName}"
            <p> The length of the names of the employee should be from 1 to 12 characters.</p></td>
        </tr>
        <td><input type="hidden" name = "idDep" value="${department.id}"/> </td>
        <td><input type="hidden" name = "idEmpl" value="${employee.id}"/> </td>
        <tr>
            <td colspan="2">
                <input type="submit"/>
            </td>
        </tr>
    </table>
</form:form>


<input type="button" onclick="history.back()" value="Back to employees of ${department.name}">

</body>
</html>