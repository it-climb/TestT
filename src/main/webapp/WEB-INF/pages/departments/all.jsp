<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
  <title>Departments</title>
</head>
<body>

<table border="1">
  <caption>Our departments</caption>
  <tr>
    <th>id</th>
    <th>Name</th>
    <th>Phone number</th>
    <th>Delete</th>
    <th>Edit</th>
    <th>Employees</th>
  </tr>

  <c:forEach var="department" items="${departments}">

  <tr>
      <td>${department.id}</td>
      <td>${department.name}</td>
      <td>${department.depPhone}</td>
      <td>
            <form:form method="post" action="/depDelete">
              <input type="hidden" name="id" value="${department.id}">
             <input type="submit" value="delete">
             </form:form>
      </td>
      <td>
            <form:form method="post" action="/depEdit">
            <input type="hidden" name="id" value="${department.id}">
            <input type="submit" value="edit">
            </form:form>
      </td>
      <td>
            <form:form method="post" action="/empl">
            <input type="hidden" name="id" value="${department.id}">
            <input type="submit" value="employees">
            </form:form>
      </td>
  </tr>
  </c:forEach>
  </table>

<a href="/depAdd">Add new department</a>
</body>

