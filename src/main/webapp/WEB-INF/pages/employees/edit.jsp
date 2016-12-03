<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Bootstrap CSS and bootstrap datepicker CSS used for styling the demo pages-->
    <link rel="stylesheet" href="/resources/css/datepicker.css">
    <link rel="stylesheet" href="/resources/css/bootstrap.css">

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
            <td>
                <div class="container">
                    <div class="hero-unit">
                        <input  type="text" placeholder="click to show datepicker" name="dateBirth" id="dateBirth">
                    </div>
                </div>
                <!-- Load jQuery and bootstrap datepicker scripts -->
                <script src="/resources/js/jquery-1.9.1.min.js"></script>
                <script src="/resources/js/bootstrap-datepicker.js"></script>
                <script type="text/javascript">
                    // When the document is ready
                    $(document).ready(function () {
                        $('#dateBirth').datepicker({
                            format: "dd/mm/yyyy"
                        });
                    });
                </script>
            </td>
        <tr>
            <td colspan="2">
                <input type="submit" value = "OK" />
            </td>
        </tr>
    </table>

</form:form>
</body>
</html>
