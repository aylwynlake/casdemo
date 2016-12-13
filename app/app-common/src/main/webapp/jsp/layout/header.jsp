<%@page pageEncoding="utf-8" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
应用: ${appName}<br />
<sec:authorize access="isAuthenticated()">
    用户: <sec:authentication property="principal.username" /><br />
    <a href="logout">下线</a>
    <br /><br />
</sec:authorize>