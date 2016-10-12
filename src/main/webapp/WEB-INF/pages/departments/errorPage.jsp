<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form:form method="post" action="/errorPage">

        <tr>
            <td>Error in Department's name! </td>
            <p> The length of the names of the department should be from 3 to 10 characters. Department name must contain uppercase and lowercase characters as well as numbers from 0 to 9.</p>
        </tr>
         </td>
        <tr>

            </td>
        </tr>

</form:form>

<a href="/depAdd"> <button> Back  </button> </a>
</body>
</html>