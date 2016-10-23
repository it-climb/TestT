<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<center>
<form:form method="post" action="/depSave">
    <table>
    <caption>New Department</caption>
        <tr>
            <th>Name:</th>
            <td><input type="text" name="departmentName" placeholder="Department's name" autofocus required/></td>
        </tr>
    </table>
    <form>
        <input type="submit" value="Create">
    </form>
</form:form>

</center>
</body>
</html>
