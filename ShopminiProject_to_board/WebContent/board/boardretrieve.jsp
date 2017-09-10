<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">

<tr>
	<tr>
			<td>NUM.${rdto.num }</td>
			<td>작성일: ${rdto.writeday }</td>
		</tr>
		<tr>
			<td colspan="2" align="center">제목: ${rdto.title }</td>
		</tr>
		<tr>
			<td colspan="2">내용<br /> <input type="text" height="100%"
				width="100%" value="${rdto.content }">
			</td>
		</tr>
		<tr>
			<td colspan="5" align="right"><input type="button" value="돌아가기"
				id=""></td>
		</tr>
</tr>



</table>
<a href="list.board">돌아가기</a>
</body>
</html>