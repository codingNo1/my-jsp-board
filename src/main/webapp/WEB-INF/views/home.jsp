<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
<c:if test="${empty loginUser}">
	<a href="<c:url value='/user/login'/>">로그인</a>
	<a href="<c:url value='/user/regist'/>">회원가입</a>
</c:if>
<c:if test="${not empty loginUser}">
	<a href="<c:url value='/user/logout'/>">로그아웃</a>
</c:if>
<h3>Home</h3>
<p>현재 시간: ${now}입니다.</p>
</body>
</html>




