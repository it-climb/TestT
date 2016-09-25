<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
  <title>All</title>
</head>
<body>

<table border="1">
  <caption>Our departments</caption>
  <tr>
    <th>id</th>
    <th>Name</th>
    <th>Delete</th>
    <th>Edit</th>
  </tr>

  <c:forEach var="department" items="${departments}">

  <tr><td>${department.id}</td><td>${department.name}</td>
    <td><a href="/depDelete?id=${department.id}">Delete</a></td>
    <td><a href="/depEdit?id=${department.id}">Edit</a></td></tr>
  </c:forEach>

  </table>



<a href="/depAdd">Add new one</a>



</body>



<%--<table width="600px">--%>
  <%--<tr>--%>
    <%--<td><b>Name</b></td>--%>
  <%--</tr>--%>

    <%--<tr>--%>
      <%--<td>${department.name}</td>--%>
      <%--<td> <a href="/depDelete?id=${department.id}">Delete</a></td>--%>
    <%--</tr>--%>



  <%--</c:forEach>--%>
  <%--<tr>--%>
    <%--<td colspan="5">--%>
      <%--<a href="/depAdd">Add new one</a>--%>
    <%--</td>--%>
  <%--</tr>--%>
<%--</table>--%>