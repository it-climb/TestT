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
  <c:forEach var="department" items="${departments}">
    <tr>
      <td>${department.name}</td>
    </tr>
  </c:forEach>
  <tr>
    <td colspan="5">
      <a href="/depAdd">Add new one</a>
    </td>
  </tr>
</table>