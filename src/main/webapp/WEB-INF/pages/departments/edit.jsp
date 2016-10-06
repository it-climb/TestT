<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/depEdit.css" type="text/css">
    <title>Departments</title>
</head>
<body>
    <form:form method="post" action="/depSave">
        <div id="textDiv">
            <p>department</p>
        </div>
        <div id="inputs">
            <div id="nameDiv">
                <p>name: </p><input class="textInput" type="text" name="name">
            </div>

            <div id="mailDiv">
                <p>mail: </p><input class="textInput" type="text" name="mail">
            </div>

            <div id="telDiv">
                <p>telephone: </p><input class="textInput" type="text" name="tel">
            </div>

            <div id="buttonDiv">
                <input class="buttonInput" type="submit">
            </div>
        </div>
</form:form>
</body>
</html>
