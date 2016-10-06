<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <link rel="stylesheet" href="/resources/css/home.css" type="text/css">
      <title>Main page</title>
  </head>
  <body>

        <form:form action="/depEdit" method="get">
            <div id="departmentDiv">
                <button id="buttonDepartment" type = "submit">department</button>
            </div>
        </form:form>


        <form:form action="/empEdit" method="get">
            <div id="employeeDiv">
                <button id="buttonEmployee" type = "submit" name = "toemployee">employee</button>
            </div>
        </form:form>
  </body>
</html>
