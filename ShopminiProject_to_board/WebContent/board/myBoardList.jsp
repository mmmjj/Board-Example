<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>	

<table border="1" >
<tr align="right">
	<td colspan="5">
     <table border="0">	
	  <tr>
	   <td>

	   <form action="list.board">
		<select name="search">
			<option value="title">제목</option>
			<option value="content">내용</option>
		</select>
		<input type="text"/>
		<input type="submit" value="검색">
		</form>
	   </td>
	  </tr>
	 </table> 
	</td>
</tr>
<!-- board list -->
<tr border="1">
	<td width="50" align="center">글번호</td>
	<td width="400" align="center">제목</td>
	<td width="80" align="center">작성자</td>
	<td width="60" align="center">작성일</td>
	<td width="60" align="center">조회수</td>
</tr>

<c:forEach var="bDTO" items="${bList.getList() }">
	<tr>
		<td align="center">${bDTO.num }</td>
		<td align="left" >&nbsp;&nbsp;${ bDTO.title }</td>
		<td align="center">${bDTO.author }</td>
		<td align="center">${bDTO.writeday }</td>
		<td align="center">${bDTO.readCnt }</td>
	</tr>
</c:forEach>
<!-- paging -->
<tr>
	<td colspan="5" align="center">
		<jsp:include page="boardpage.jsp"/>
	</td>
</tr>
<tr>
	<td colspan="5" align="right"> <a href="writeui.board">글 작성</a>
	</td>
</tr>

</table>


