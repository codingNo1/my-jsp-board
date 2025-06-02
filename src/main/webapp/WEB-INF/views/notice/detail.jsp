<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>공지사항 상세</h3>
	<p><strong>제목:</strong><br>
		<c:choose>
		<c:when test="${empty notice.title}">제목없음</c:when>
		<c:otherwise>${notice.title}</c:otherwise>
		</c:choose>
		
	<div style="width: 100%;">
  	<p><strong>내용:</strong></p>
  		<pre style="width: 100%; font-family: inherit; padding: 10px; overflow-x: auto;">${notice.content}
  		
  		</pre>
	</div>

	<p><strong>작성일:</strong> ${notice.regDate} </p>

<%
    Boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
   	 if (isAdmin == null) isAdmin = false;
%>

<%	 if (isAdmin) { %>
	<a href="${pageContext.request.contextPath}/notice/update?num=${notice.num}"><button type ="button">수정</button></a>
	<a href="${pageContext.request.contextPath}/notice/delete?num=${notice.num}" onclick="return confirm('정말 삭제 하시겠습니까?');"><button type="button">삭제</button></a>
<% } %>
	<a href="list"><button type="button">목록</button></a>
	<p>조회수 :${notice.viewCount}</p>

	
</body>
</html>