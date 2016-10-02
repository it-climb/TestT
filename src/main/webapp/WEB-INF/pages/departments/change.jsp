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
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <c:forEach var="department" items="${departments}">

        <tr>
            <td>${department.name}</td>
            <td>
                <form action="/edit" method="post">
                    <input type="text" size="30" value="${department.id}">
                </form>
            </td>
                <%--<td><a href="/depAdd?id=${contact.id}">Edit</a> | <a href="/delete?id=${contact.id}">Delete</a></td>--%>
        </tr>
        </c:forEach>
        </tr>
    </table>
</form:form>
</body>
</html>
