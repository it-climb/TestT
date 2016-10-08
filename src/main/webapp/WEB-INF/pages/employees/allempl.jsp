<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>Employees</title>--%>
<%--</head>--%>
<%--<body>--%>

<%--<table border="1">--%>
    <%--<caption> Department's employees</caption>--%>
    <%--<tr>--%>
        <%--<th>id</th>--%>
        <%--<th>Name</th>--%>
        <%--<th>Delete</th>--%>
        <%--<th>Edit</th>--%>
        <%--<th>Employees</th>--%>
    <%--</tr>--%>

    <%--<c:forEach var="employees" items="${employees}">--%>

        <%--<tr/><td>${employees.id}</td><td>${employees.name}</td>--%>
        <%--<td><a href="/emplDelete?id=${employees.id}">Delete</a></td>--%>
        <%--<td><a href="/emplEdit?id=${employees.id}">Edit</a></td>--%>
    <%--</c:forEach>--%>

<%--</table>--%>



<%--<a href="/emplAdd">Add new employee</a>--%>


<%--</body>--%>














//------------------------------------------------------------------------------

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees</title>
</head>
<body>

<table border="1">
    <caption> Department's employees</caption>
    <tr>
        <th>id</th>
        <th>Name</th>
        <th>Delete</th>
        <th>Edit</th>
        <th>Employees</th>
    </tr>

    <c:forEach var="employee" items="${employees}">

        <tr><td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>

                <form:form method="post" action="/emplDelete">
                    <input type="hidden" name="id" value="${employee.id}">
                    <input type="submit" value="delete">
                </form:form>



            </td>
            <td>

                <form:form method="post" action="/emplEdit">
                    <input type="hidden" name="id" value="${employee.id}">
                    <input type="submit" value="edit">
                </form:form>
            </td>

            <td>


                <form:form method="post" action="/empl">
                <input type="hidden" name="id" value="${department.id}">
                <input type="submit" value="employees">
                </form:form>
        </tr>
    </c:forEach>

</table>



<a href="/emplAdd">Add new employee</a>


</body>