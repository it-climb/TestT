<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <link rel="stylesheet" href="../resources/css/home.css" type="text/css">
      <title>Main page</title>
  </head>
  <body>
    <div id="mainButton">
        <form:form action="/depEdit" method="get">
            <button id="button" type = "submit" name = "todepartments">Departments</button>
        </form:form>
    </div>
  </body>
</html>
