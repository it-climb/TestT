<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>All employees</title>
    </head>
    <body>
    <table border="1">
        <tr>
            <b>Name of employe</b>
        </tr>

        <c:forEach var="empl" items="${employees}">
            <tr>
                <td width="250" > <a> ${empl.firstName} </a> </td>
                <td colspan = 5 > <a> ${empl.secondName} </a> </td>
                <td><a href="/EditEmpl?id=${empl.id}">Edit</a> | <a href="/deleteEmpl?id=${empl.id}">Delete</a></td>

            </tr>
        </c:forEach>

        <tr>
            <td colspan="5">
                <a href="/emplAdd?dep=${dep.id}">Add new one</a>
            </td>
        </tr>
    </table>
    </body>
</html>
