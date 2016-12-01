<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form:form method="post" action="/emplSave">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" value=${empl.firstName}></td>
            <td><input type="text" name="secondName" value=${empl.secondName}></td>
            <td><input type="hidden" name="id" value=${empl.id}></td>
            <td><input type="hidden" name="dep" value=${dep.id}></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value = "OK" />
            </td>
        </tr>
    </table>



    <!-- Инициализация виджета "Bootstrap datetimepicker" -->
    <script type="text/javascript">
        $(function () {
            //Идентификатор элемента HTML (например: #datetimepicker1), для которого необходимо инициализировать виджет "Bootstrap datetimepicker"
            $('#datetimepicker1').datetimepicker();
        });
    </script>

<div class="form-group">
    <label for="inputDate"> Input date:</label>
    <input type="date" class="form-control">
</div>



</form:form>
</body>
</html>
