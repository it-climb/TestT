<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.js"></script>
    <script src="resources/js/validation.js"></script>
</head>
<body>
<form:form method="post" class="cmxform" id="updateDepartment" action="/depSave">
    <fieldset>
        <legend>Please provide your Department name</legend>
        <p>
            <label for="cname">Name (required, 3-30 characters)</label>
            <input id="cname" name="name" type="text" required value="${department.name}">
            <input type="hidden" name="id" value="${department.id}"></td>
        </p>
        <p>
            <input class="submit" type="submit" value="Update">
        </p>
    </fieldset>
</form:form>
</body>
</html>
