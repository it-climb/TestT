<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<table width="600px">
    <tr>
        <td><b>DepName</b></td>
        <td><b>DepID</b></td>
    </tr>
    <c:forEach var="employee" items="${allEmplInDep}">
        <tr>
            <td>${department.id}</td>
            <td>${employee.firstName}</td>
            <td>${employee.secondName}</td>
            <td>${employee.id}</td>
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
    <tr>
        <td colspan="5">
            <form action="/emplAdd" method="post">
                <input type="submit" value="Add new Empl">
                <input type="hidden" name = "depID" value="${department.id}">
            </form>
        </td>
    </tr>
</table>
<body>

</body>
</html>
