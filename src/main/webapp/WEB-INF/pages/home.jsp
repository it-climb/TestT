<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello world</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/main.css" />
</head>

<body>

<header id="header">
    <nav class="left">
        <a href="#menu"><span>Menu</span></a>
    </nav>
    <a href="/home" class="logo">Mary</a>
    <nav class="right">
        <security:authorize access="isAnonymous()">
            <a href="/login" class="button alt">Log in</a>
        </security:authorize>
        <security:authorize access="isAuthenticated()">
            <a href="/logout" class="button alt">Log out</a>
        </security:authorize>
    </nav>
</header>

<!-- Menu -->
<nav id="menu">
    <ul class="links">
        <li><a href="/home">Home</a></li>
        <li><a href="/dep">Departments</a></li>
        <security:authorize access="hasRole('ROLE_ADMIN')">
            <li><a href="/users">Users</a></li>
        </security:authorize>
    </ul>
</nav>

<!-- Scripts -->
<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.scrolly.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/skel.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/util.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/main.js"></script>
</body>
</html>
