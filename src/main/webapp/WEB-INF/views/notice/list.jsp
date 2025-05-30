<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 목록</title>
</head>
<body>


    <h2>📋 공지사항</h2>
    <table border="3">
        <tr><th>번호</th><th>제목</th><th>작성일</th><th>조회수</th></tr>
			<c:forEach var="notice" items="${noticelist}">
	        <tr>
        	<td>${notice.num}</td>
        	<td>
        		<a href="detail?num=${notice.num}">
				<c:choose>
				<c:when test="${empty notice.title}">제목없음</c:when>
				<c:otherwise>${notice.title}</c:otherwise>
				</c:choose>
				</a>
			</td>
			<td>${notice.regDate}</td>
			<td>${notice.viewCount}</td>
			
    		</tr>
        	</c:forEach>
    </table>
			<br>
        		<c:if test="${sessionScope.isAdmin==true}">
        		<a href="write"><button type="button">관리자 글쓰기</button></a>
        		<a href="admin-logout"><button type="button">관리자 나가기</button></a>
        		</c:if>
				<c:if test="${not empty logoutmessage}">
				<script>alert('${logoutmessage}')</script>
				</c:if>      		


</body>
</html>