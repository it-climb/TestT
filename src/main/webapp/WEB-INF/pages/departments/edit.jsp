<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../resources/css/edit.css" type="text/css">
    <title>Departments</title>
</head>
<body>
<form:form method="post" action="/depSave">
    <div id="departments">
        <table>
            <tr>
                <td><input type="text" name="name" placeholder="name"/></td>
            </tr>

            <tr>
                <td><input type="text" name="mail" placeholder="mail"/></td>
            </tr>

            <tr>
                <td><input type="text" name="tel" placeholder="telephone"/></td>
            </tr>

            <tr>
                <td colspan="2"><input type="submit"/></td>
            </tr>
    </table>
    </div>
</form:form>

<form:form method="post" action="/depSave">

<div id="employees">

    <table>
        <tr>
            <td><input type="text" name="name" placeholder="name"/></td>
        </tr>

        <tr>
            <td><input type="text" name="surname" placeholder="surname"/></td>
        </tr>

        <tr>
            <td><input type="text" name="patronymic" placeholder="patronymic"/></td>
        </tr>

        <tr>
            <td><input type="text" name="mail" placeholder="mail"/></td>
        </tr>

        <tr>
            <td>
                <input type="text"  placeholder="birthday" name="birthday"/>
            </td>
        </tr>

        <tr>
            <td><input type="text" name="tel_number" placeholder="telephone number"/></td>
        </tr>

        <tr>
            <td><input type="text" name="position" placeholder="position"/></td>
        </tr>

        <tr>
            <td><input type="text" name="position" placeholder="position"/></td>
        </tr>

        <tr>
            <td><input type="text" name="department" placeholder="department"/></td>
        </tr>

        <tr>
            <td><input type="text" name="currentProject" placeholder="current project"/></td>
        </tr>

        <tr>
            <td>
                <input type="text" placeholder="dateregistration" name="dateregistration"/>
            </td>
        </tr>

        <tr>
            <td><input type="submit"/></td>
        </tr>
    </table>

</div>

</form:form>
</body>
</html>
