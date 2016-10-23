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

    <input type="hidden" name="idDep" value="${idDep}"/>
    <input type="hidden" name="idEmp" value="${getEmpById.id}"/>

    <div id="textDiv">
        <p>employee</p>
    </div>
    <div id="inputs">
        <div id="firstFive">
            <div id="nameDiv">
                <p>name: </p><input type="text" name="name" class="textInput" value="${getEmpById.name}"/>
            </div>
            <div id="surnameDiv">
                <p>surname: </p><input type="text" name="surname" class="textInput" value="${getEmpById.surname}"/>
            </div>
            <div id="mailDiv">
                <p>mail: </p><input type="text" name="mail" class="textInput" value="${getEmpById.mail}"/>
            </div>
        </div>

            <input type="submit" class="buttonInput" value="save"/>

    </div>
</form:form>


<form:form method="get" action="/empOutput">
    <input type="submit" class="buttonInput" value="emp"/>
</form:form>

<form:form method="get" action="/">
    <input type="submit" class="buttonInput" value="<-"/>
</form:form>

</body>
</html>
