<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head><!-- 1. 홈페이지를 만들자 2.는 로그인게시판,과 include게시판 -->
<body>

<a href="home.jsp">
<h1>홈페이지</h1></a>
<jsp:include page="include/top.jsp" flush="true"/><br>
<jsp:include page="include/submenu.jsp" flush="true"/>
<hr>
<c:if test="${!empty result}" >
<script >
	alert("회원가입을 축하합니다.");
</script>
</c:if>

<c:if test="${!empty requestScope.login}" >
<script>
	alert('${requestScope.login}');
</script>
</c:if>


<c:if test="${!empty requestScope.logout}" >
<script>
	alert('${requestScope.logout}');
</script>
</c:if>

<c:if test="${!empty requestScope.update}" >
<script>
	alert('${requestScope.update}');
</script>

</c:if>

<c:if test="${!empty requestScope.delete}" >
<script>
	alert('${requestScope.delete}');
</script>
</c:if>




</body>
</html>