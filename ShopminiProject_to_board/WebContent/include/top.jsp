<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- 로그인 했을 당시 화면 변경! -->
<c:if test="${empty sessionScope.login }">
<a href="LoginFormServlet">로그인</a>
<a href="MemberFormServlet">회원가입</a>
<a href="list.board">게시판</a>
</c:if>

<c:if test="${! empty sessionScope.login }">
안녕하세요 ${sessionScope.login.username }
<a href="xx">로그아웃</a>
<a href="MyPageServlet">마이페이지</a><!-- 게시판의 글자세히보기와 비슷, 사용자의 상세내용을 보는 것  -->
<a href="CartListServlet">장바구니</a>
<a href="list.board">게시판</a>
</c:if>

