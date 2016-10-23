<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
    <title>Main</title>
</head>
<body>
    <table width="600px">
        <tr>
            <td><b>Name</b></td>
        </tr>

        <c:forEach var="department" items="${departments}">
        <tr>
            <td>${department.name}</td>

            <td>
                <form method="post" action="/empAddForm">
                    <input type="hidden" name="idDep" value="${department.id}"/>
                    <button type = "submit">Add Employees</button>
                </form>
            </td>
            <td>
                <form method="post" action="/empOutput">
                    <input type="hidden" name="idDep" value="${department.id}"/>
                    <button type = "submit">Employees</button>
                </form>
            </td>
            <td>
                <form method="post" action="/depEditForm">
                    <input type="hidden" name="id" value="${department.id}"/>
                    <button type = "submit">Edit Department</button>
                </form>
            </td>
            <td>
                <form method="post" action="/depDelete">
                    <input type="hidden" name="idDep" value="${department.id}"/>
                    <%--<input type="hidden" name="name" value="${department.name}"/>--%>
                    <input type="submit" value="Delete"/>
                </form>
            </td>
        </tr>
        </c:forEach>

        <form:form method="get" action="/">
            <button type = "submit"><-</button>
        </form:form>
        <form:form method="get" action="/depAdd">
            <button type = "submit">Add Department</button>
        </form:form>
        <form:form method="get" action="/allEmp">
            <button type = "submit">All Employees</button>
        </form:form>

    </table>


    </body>
</html>