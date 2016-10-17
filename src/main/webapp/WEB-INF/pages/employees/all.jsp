<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="/resources/Styles/employees/AllEmpl.css">
</head>
<center>
<table width="600px">
    <caption>Employees</caption>
    <tr>
        <th>${department.id}</th>
        <th>${department.name}</th>
    </tr>
    <c:forEach var="employee" items="${allEmplInDep}">
        <tr>

            <td>${employee.id}</td>
            <td>${employee.firstName}</td>
            <td>${employee.secondName}</td>
            <td>
                <form:form method ="post" action ="/emplDel">
                    <input type="submit" value="Delete" />
                    <input type="hidden" name = "id" value="${employee.id}">
                    <input type="hidden" name = "depID" value="${department.id}">
                </form:form>
            </td>
            <td>
                <form:form method ="post" action ="/emplEdit">
                    <input type="submit" value="Edit" />
                    <input type="hidden" name = "id" value="${employee.id}">
                    <input type="hidden" name = "depID" value="${department.id}">
                </form:form>
            </td>
        </tr>
    </c:forEach>
</table>
    <form action="/emplAdd" method="post">
        <input type="submit" value="Add new Employee">
        <input type="hidden" name = "depID" value="${department.id}">
    </form>
    <a href="/dep"><button>Back to Departments</button></a>
</center>
<body>

</body>
</html>
