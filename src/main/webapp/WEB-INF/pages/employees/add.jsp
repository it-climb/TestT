<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<center>
<form:form modelAttribute="Employee" method="post" action="/emplSave">
    <table>
    <caption>New Employee</caption>
        <tr>
            <td align="center">FirstName:</td>
            <td><input type="text" name="firstName" placeholder="Иван" autofocus required/></td>
        </tr>
        <tr>
            <td align="center">SecondName:</td>
            <td><input type="text" name="secondName" placeholder="Иванов" autofocus required/></td>

        </tr>
        <tr>
            <td align="center">Phone:</td>
            <td><input type="text" name="phone" placeholder="+38(0XX)XX-XXX-XX" autofocus required/></td>
        </tr>
        <tr>
            <td align="center">E-mail:</td>
            <td><input type="text" name="email" placeholder="user@gmail.com" autofocus required/></td>
        </tr>
        <tr>
            <td align="center">Date of Birth:</td>
            <td><input type="date" name="dateOfBirth" placeholder="Year-Month-Day" autofocus required/></td>
        </tr>
        <tr>
            <td align="center">Gender:</td>
            <td><input type="text" name="gender" placeholder="male/female" autofocus required/></td>
        </tr>
    </table>
    <form>
        <td><input type="submit" value="Create"/></td>
        <td><input type="hidden" name="depID" value="${depID}"/></td>

    </form>
</form:form>
    <%--<div>--%>
        <%--<c:forEach var="violations" items="${violations}">--%>
            <%--<p>--%>
                <%--${violations.message}--%>
            <%--</p>--%>
    <%--</div>--%>
<%--</c:forEach>--%>
</center>
</body>
</html>
