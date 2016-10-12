<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<table width="600px">
  <tr>
    <td><b>DepID</b></td>
    <td><b>DepName</b></td>
  </tr>
  <c:forEach var="department" items="${departments}">
    <tr>
      <td>${department.id}</td>
      <td>${department.name}</td>
      <td>
        <form:form method ="post" action ="/depDel">
          <input type="submit" value="Delete" />
          <input type="hidden" name = "id" value="${department.id}">
        </form:form>
      </td>
      <td>
        <form:form method ="get" action ="/depEdit">
          <input type="submit" value="Edit" />
          <input type="hidden" name = "id" value="${department.id}">
        </form:form>
      </td>
      <td>
        <form:form method ="get" action ="/allEmplInDep">
          <input type="submit" value="Employees" />
          <input type="hidden" name = "depID" value="${department.id}">
        </form:form>
      </td>
    </tr>
  </c:forEach>
  <tr>
    <td colspan="5">
      <form action="/depAdd" method="get">
        <input type="submit" value="Add new Dep">
      </form>
    </td>
  </tr>
</table>
<body>

</body>
</html>
