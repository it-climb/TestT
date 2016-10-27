<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
    <title>All Employees</title>
</head>
<table width="600px">
    <tr>
        <td><b>Name</b></td>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.firstName}</td>
            <td>${employee.secondName}</td>
            <td>
                <form method="get" action="/empDelete">
                    <input type="hidden" name="id" value="${employee.id}">
                    <input type="submit" value="delete">
                </form>
            </td>
            <td>
                <form method="get" action="/empUpdate">
                    <input type="hidden" name="id" value="${employee.id}">
                    <input type="submit" value="update">
                </form>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="5">
            <a href="/empAdd">Add new employee</a>
        </td>
    </tr>
</table>