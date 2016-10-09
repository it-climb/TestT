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
      <td>
        <form method="get" action="/depAdd">
          <input type="hidden" name="id" value="${department.id}"/>
          <input type="hidden" name="name" value="${department.name}"/>
          <input type="submit" value="Edit Department"/>
        </form>
      </td>
      <td>
        <form method="get" action="/emp">
          <input type="hidden" name="id" value="${department.id}"/>
          <input type="submit" value="View/Add Employees"/>
        </form>
      </td>
      <td>
        <form method="post" action="/depDel">
          <input type="hidden" name="id" value="${department.id}"/>
          <input type="submit" value="Delete Department"/>
        </form>
      </td>
    </tr>
  </c:forEach>
  <tr>
    <td colspan="5">
      <form method="get" action="/depAdd">
        <input type="hidden" name="id" value="${null}"/>
        <input type="submit" value="Insert new Department"/>
      </form>
    </td>
  </tr>
</table>