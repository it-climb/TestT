<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 9/28/15
  Time: 6:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Hello world</title>
</head>
<body>
  Home World !
  <a href="/dep" > список департмент</a>


  <!-- Инициализация виджета "Bootstrap datetimepicker" -->
  <div class="form-group">
    <!-- Элемент HTML с id равным datetimepicker1 -->
    <div class="input-group date" id="datetimepicker1">
      <input type="text" class="form-control" />
      <span class="input-group-addon">
      <span class="glyphicon glyphicon-calendar"></span>
    </span>
    </div>
  </div>
  <!-- Инициализация виджета "Bootstrap datetimepicker" -->
  <script type="text/javascript">
    $(function () {
      //Идентификатор элемента HTML (например: #datetimepicker1), для которого необходимо инициализировать виджет "Bootstrap datetimepicker"
      $('#datetimepicker1').datetimepicker();
    });
  </script>

</body>


</html>
