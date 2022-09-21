<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id=<c:out value="${member.id}"/></li>
    <li>username=<c:out value="${member.username}"/></li>
    <li>age=<c:out value="${member.age}"/></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
