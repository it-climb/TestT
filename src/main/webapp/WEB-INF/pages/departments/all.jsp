<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
  <title>All Departments</title>
</head>
<table width="600px">
  <tr>
    <td><b>Name</b></td>
  </tr>
  <c:forEach var="department" items="${departments}">
    <tr>
      <td><a href="/emp">${department.name}</td>
      <td>
        <form method="get" action="/depDelete">
          <input type="hidden" name="id" value="${department.id}">
          <input type="submit" value="delete">
        </form>
      </td>
      <td>
        <form method="get" action="/depUpdate">
          <input type="hidden" name="id" value="${department.id}">
          <input type="submit" value="update">
        </form>
      </td>
    </tr>
  </c:forEach>
  <tr>
    <td colspan="5">
      <a href="/depAdd">Add new departments</a>
    </td>
  </tr>
</table>