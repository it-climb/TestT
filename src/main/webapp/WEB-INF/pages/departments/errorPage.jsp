<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<form:form method="post" action="/errorPage">

        <tr>
            <td>Error in Department's name! </td>
            <p> The length of the names of the department should be from 3 to 10 characters. </p>
            <p> Department name must contain uppercase and lowercase characters as well as numbers from 0 to 9.</p>
            <p>     </p>
            <p> The phone number should start with a "+" sign and contain 12 digits.</p>

        </tr>
         </td>
        <tr>

            </td>
        </tr>

</form:form>

<a href="/depAdd"> <button> Back  </button> </a>
</body>
</html>