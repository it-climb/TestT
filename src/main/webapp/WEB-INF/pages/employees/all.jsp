<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
    <title>All</title>
</head>
<table width="600px">
    <tr>
        <td><b>Name</b></td>
    </tr>
    <c:forEach var="employees" items="${employees}">
        <tr>
            <td>${employees.firstName}</td>
            <td>${employees.secondName}</td>
            <td><a href="/editEmpl?id=${employees.id}">Edit</a> | <a href="/deleteEmpl?id=${employees.id}">Delete</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="5">
            <a href="/emplAdd?id=${depId}">Add new one</a>
        </td>
    </tr>
</table>