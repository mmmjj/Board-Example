<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 글쓰기 화면</h1>
<form action="MyBoardWriteServlet" method ="post">
제목<input type="text" name="title"> <br/>
작성자<input type="text" name ="author"> <br/>
내용<textarea rows="10" cols="10" name="content"></textarea>
<input type="submit" value="글쓰기">
</form>
<a href="MyBoardListServlet">목록</a>


</body>
</html>