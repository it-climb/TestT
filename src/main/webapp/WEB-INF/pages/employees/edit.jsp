<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
    <link rel="stylesheet" href="/resources/css/empEdit.css" type="text/css">
    <title>Edit</title>
</head>
<body>
<form:form method="post" action="/empSave">

    <div id="textDiv">

        <p>employee</p>
    </div>
    <div id="inputs">

        <div id="firstFive">
            <div id="nameDiv">
                <p>name: </p><input type="text" name="name" class="textInput"/>
            </div>

            <div id="surnameDiv">
                <p>surname: </p><input type="text" name="surname" class="textInput"/>
            </div>

            <div id="patronymicDiv">
                <p>patronymic: </p><input type="text" name="patronymic" class="textInput"/>
            </div>

            <div id="mailDiv">
                <p>mail: </p><input type="text" name="mail" class="textInput"/>
            </div>

            <div id="birthdayDiv">
                <p>birthday: </p><input type="text" name="birthday" class="textInput"/>
            </div>
        </div>

        <div id="secondFive">
            <div id="telDiv">
                <p>tel: </p><input type="text" name="tel" class="textInput"/>
            </div>

            <div id="positionDiv">
                <p>position: </p><input type="text" name="position" class="textInput"/>
            </div>

            <div id="departmentDiv">
                <p>department: </p><input type="text" name="department" class="textInput"/>
            </div>

            <div id="projectDiv">
                <p>project: </p><input type="text" name="currentProject" class="textInput"/>
            </div>

            <div id="registrationDiv">
                <p>registration: </p><input type="text" name="dateregistration" class="textInput"/>
            </div>
        </div>

        <div id="buttonDiv">
            <input type="submit" class="buttonInput"/>
        </div>

    </div>


</form:form>

</body>
</html>
