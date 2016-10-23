<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form:form method="post" action="/edit">

    <input type="hidden" name="id" value="${getDepById.id}"/>
    <div id="inputs">
        <div id="nameDiv">
            <p>name: </p><input class="textInput" type="text" name="name" value="${getDepById.name}">
        </div>
        <div id="mailDiv">
            <p>mail: </p><input class="textInput" type="text" name="mail" value="${getDepById.mail}">
        </div>
        <div id="telDiv">
            <p>telephone: </p><input class="textInput" type="text" name="tel" value="${getDepById.tel}">
        </div>
        <div id="buttonDiv">
            <input class="buttonInput" type="submit" value="ok">
        </div>
    </div>
</form:form>

</body>
</html>
