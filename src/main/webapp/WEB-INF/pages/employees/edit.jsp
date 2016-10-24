<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 9/28/15
  Time: 4:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.js"></script>
    <script src="resources/js/validation.js"></script>
</head>
<body>
<form class="cmxform" id="updateEmployee" method="get" action="/empSave">
    <fieldset>
        <legend>Please provide First and Second name of Employee</legend>
        <p>
            <label for="fname">Name (required, 3-30 characters)</label>
            <input id="fname" name="firstName" minlength="3" maxlength="30" type="text" required value="${employee.firstName}">
        </p>
        <p>
            <label for="sname">Second Name (required, 3-30 characters)</label>
            <input id="sname" name="secondName" minlength="3" maxlength="30" type="text" required value="${employee.secondName}">
        </p>
        <p>
            <input type="hidden" name="depId" value="${depId}"/>
        </p>
        <p>
            <input type="hidden" name="id" value="${employee.id}"/>
        </p>
        <p>
            <input class="submit" type="submit" value="Update/Insert new employee">
        </p>
    </fieldset>
</form>
<form method="get" action="/dep">
    <input type="submit" value="Back to Departments"/>
</form>
</body>
</html>
