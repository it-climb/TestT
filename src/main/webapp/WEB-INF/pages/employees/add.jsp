<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<center>
<form:form method="post" action="/emplSave">
    <table>
    <caption>New Employee</caption>
        <tr>
            <td>FirstName:</td>
            <td><input type="text" name="employeeFirstName" placeholder="Иван" autofocus required/></td>
        </tr>
        <tr>
            <td>SecondName:</td>
            <td><input type="text" name="employeeSecondName" placeholder="Иванов" autofocus required/></td>

        </tr>
        <%--<tr>--%>
            <%--<td>Phone:</td>--%>
            <%--<td><input type="text" name="employeePhone" placeholder="+38(0XX)XX-XXX-XX" autofocus required/></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>E-mail:</td>--%>
            <%--<td><input type="text" name="employeeEmail" placeholder="user@gmail.com" autofocus required/></td>--%>
            <%--<td><input type="hidden" name="depID" value="${depID}"/></td>--%>
        <%--</tr>--%>
    </table>
    <form>
        <td><input type="submit" value="Create"/></td>
    </form>
</form:form>
</center>
</body>
</html>
