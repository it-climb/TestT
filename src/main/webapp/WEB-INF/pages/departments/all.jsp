<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
  <title>All</title>
</head>
<table width="600px">
  <tr>
    <td><b>ID</b></td>
    <td><b>Name</b></td>
  </tr>
  <c:forEach var="department" items="${department}">
    <tr>
      <td>${department.id}</td>
      <td>${department.name}</td>
      <td><b><a href="/editDep?id=${department.id}">Edit</a>  | <a href="/deleteDep?id=${department.id}">Delete</a></b></td>
      <td><a href="/empl?id=${department.id}">EMPOYEES</a></td>
    </tr>
  </c:forEach>
  <tr>
    <td colspan="1">
      <b><td>
    <a href="/depAdd">Add new one</a>
    <b/></td>
    </td>
  </tr>
</table>