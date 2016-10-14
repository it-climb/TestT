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
</head>
<body>
    <table>
        <form method="get" action="/empSave">
            <tr>
                <td>FirstName:</td>
                <td>
                    <input type="text" name="firstName" value="${employee.firstName}"/>
                </td>
            </tr>
            <tr>
                <td>SecondName:</td>
                <td>
                    <input type="text" name="secondName" value="${employee.secondName}"/>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="hidden" name="depId" value="${depId}"/>
                    <input type="hidden" name="id" value="${employee.id}"/>
                    <input type="submit" value="Insert new employee"/>
                </td>
            </tr>
        </form>
        <tr>
            <td>
                <form method="post" action="/dep">
                    <input type="submit" value="View All Departments"/>
                </form>
            </td>
        </tr>
    </table>
</body>
</html>
