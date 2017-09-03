<%@page import="com.dto.PageDTO"%>
<%@page import="com.dto.MyBoardDTO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시판 실습</h1>
	<table border="1">
	   <tr>
    <td colspan="5">
     <form action ="MyBoardListServlet" >
      <select name="searchName">
        <option value="title">제목</option>
        <option value="author">작성자</option>
      </select>
      <input type="text" name="searchValue">
      <input type="submit" value="검색"> 
	</form>
    </td>
   </tr>

   <tr>
   <td colspan="5">
      <form action ="MyBoardPerPageServlet" >
   	페이지에서 보여줄 행 개수

   		<select name="rowCount">
   			<option value="3">3</option>
			<option value="5">5</option>
			<option value="7">7</option>   		
   		</select>
   		<input type="submit" value="클릭">
   			</form> <!-- form위치중요한가봄 -->
   </td>
   </tr>

		<tr>
			<!-- 헤더들 -->
			<td>글번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>조회수</td>
		</tr>
		
		<c:if test="${list.getList().size()==0 }">
		<tr>
			<td colspan="5"> 레코드가없습니다. </td>
		</tr>
		
		</c:if>
		<c:if test="${list.getList().size()!=0 }">
			<c:forEach var="dto" items="${list.getList() }">
				<tr>
					<td>${dto.num }</td>
					<td><a href ="MyBoardRetrieveServlet?num=${dto.num } ">${dto.title }</a></td>
					<td>${dto.author }</td>
					<td>${dto.writeday }</td>
					<td>${dto.readCnt }</td>
				</tr>
			</c:forEach>
		</c:if>
		
<!-- 페이지번호 -->
		<tr>
		<td colspan="5">
			<jsp:include page="page.jsp" flush="true"/><!-- 페이지할때 flush ="true"는 필수, flush버퍼비워줌  -->
			<!-- 액션태그 include는 forward로 요청한다 -->
		</td>
		</tr>

		
	</table>
<!-- 2.글쓰기 -->
<a href= "BoardWriteUIServlet"> 글쓰기</a>
</body>
</html>