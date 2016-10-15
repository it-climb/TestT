<%@ taglib prefix="em" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<strong>Employees of selected department</strong>
<table width="600px">
    <tr>
        <td><b>FirstName</b></td>
        <td><b>SecondName</b></td>
    </tr>
    <em:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.firstName}</td>
            <td>${employee.secondName}</td>
            <td>
                <form method="get" action="/empAdd">
                    <input type="hidden" name="id" value="${employee.id}"/>
                    <input type="hidden" name="firstName" value="${employee.firstName}"/>
                    <input type="hidden" name="secondName" value="${employee.secondName}"/>
                    <input type="submit" value="Edit Employee"/>
                </form>
            </td>
            <td>
                <form method="post" action="/empDel">
                    <input type="hidden" name="id" value="${employee.id}"/>
                    <input type="submit" value="Delete Employee"/>
                </form>
            </td>
        </tr>
    </em:forEach>
    <tr>
        <td>
            <form:form method="get" action="/empAdd">
                <input type="hidden" name="depId" value="${depId}"/>
                <input type="hidden" name="id" value="${null}"/>
                <input type="submit" value="Insert new employee"/>
            </form:form>
        </td>
        <td>
            <form:form method="get" action="/dep">
                <input type="submit" value="View Departments"/>
            </form:form>
        </td>
    </tr>
</table>
</body>
</html>
