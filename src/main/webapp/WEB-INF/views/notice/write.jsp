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

		<h2> 공지사항 작성</h2>
		<form action="write" method="post">
		 	<label>제목:</label><br>
		    <input input="text" name="title" placeholder="제목" value="${notice.title}" style="width: 20%; padding: 8px; box-sizing: border-box;" />
			<p>
		    <label>내용:</label><br>
		    <textarea input="text" name="content" placeholder="내용" rows="10" cols="50" required>${notice.content}</textarea>
			</p>
			<button type="submit">작성</button>
			
		</form>

</body>
</html>