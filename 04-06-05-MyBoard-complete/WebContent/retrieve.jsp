<%@page import="com.dto.MyBoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> 상세 화면</h1>
<form action="MyBoardUpdateServlet" method ="post">
<input type="hidden" name="num" value="${retrieve.num}">
글번호 : ${retrieve.num} &nbsp;&nbsp; 작성일:${retrieve.writeday} &nbsp;&nbsp; 조회수: ${retrieve.readCnt}<br/>
제목<input type="text" name="title" value="${retrieve.title}"> <br/>
작성자<input type="text" name ="author" value="${retrieve.author}"> <br/>
내용<textarea rows="10" cols="10" name="content">${retrieve.content}</textarea>
<input type="submit" value="수정">
</form>
<a href="MyBoardListServlet">목록</a>
<a href="MyBoardDeleteServlet?num=${retrieve.num}">삭제</a>
<!-- write 복붙함 -->
</body>
</html>