<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All employees</title>
</head>
<body>

<c:forEach var="empl" items="${employees}">
    <tr>
        <td><p> ${empl.secondName} </p> </td>
        <td><a href="/EditEmpl?id=${empl.id}">Edit</a> | <a href="/deleteEmpl?id=${empl.id}">Delete</a></td>
    </tr>
</c:forEach>



<tr>
    <td colspan="5">
        <a href="/emplAdd?dep=${dep.id}">Add new one</a>
    </td>
</tr>
</body>
</html>
