<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
    <link rel="stylesheet" href="/resources/css/empEdit.css" type="text/css">
    <title>Employee</title>
</head>
<body>
<form:form method="post" action="/empSave">
<div id="textDiv">
    <p>employee</p>
</div>
<div id="inputs">

    <div id="firstFive">
        <div id="nameDiv">
            <p>name: </p><input type="text" name="name" class="textInput" />
            </div>

            <div id="surnameDiv">
            <p>surname: </p><input type="text" name="surname" class="textInput"/>
            </div>

            <div id="mailDiv">
            <p>mail: </p><input type="text" name="mail" class="textInput"/>
            </div>

        </div>
    <%--<c:forEach var="employee" items="${departments.employeers}">--%>
        <form:form method="get" action="/empSave">
            <input type="hidden" name="idDep" value="${idDep}"/>
            <input type="submit" class="buttonInput" value="save"/>
            </form:form>
                <%--</c:forEach>--%>
        </div>


        </form:form>


        <form:form method="get" action="/emp">
        <input type="submit" class="buttonInput" value="emp"/>
        </form:form>

        <form:form method="get" action="/">
        <input type="submit" class="buttonInput" value="<-"/>
        </form:form>

</body>
</html>
