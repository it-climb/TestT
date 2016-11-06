<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
    <title>All</title>
</head>
<table width="600px">
    <tr>
        <td><b>FirstName</b></td>
        <td><b>SecondName</b></td>
        <td><b>Department</b></td>
        <td></td>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.firstName}</td>
            <td>${employee.secondName}</td>
            <td></td>
            <td><a href="/empAdd?id=${employee.id}">Edit</a>
                <a href="/empDelete?id=${employee.id}">Delete</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="5">
            <a href="/empAdd">Add new one</a>
        </td>
    </tr>
</table>