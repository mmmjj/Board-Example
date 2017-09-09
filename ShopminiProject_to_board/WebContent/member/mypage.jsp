<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>	
<!-- DAUM 주소 라이브러리 시작 -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="js/daum.js"></script>
<script type="text/javascript" src="js/jquery-3.1.0.js"></script>
<!-- DAUM 주소 라이브러리 끝 -->    

<form name="myform">
아이디<input type="text" name="userid" id="userid" 
    value="${login.userid}" readonly>
비밀번호<input type="text" name="passwd" id="passwd" 
value="${login.passwd}"><br>
이름<input type="text" name="username" id="username" 
value="${login.username}" readonly><br>
<!-- 다음주소 시작-->
	<input name="post1" id="post1" size="5" 
	value="${login.post1}" readonly=""> -
	<input name="post2" id="post2" size="5" 
	value="${login.post2}" readonly="">
	<input onclick="openDaumPostcode()" type="button" value="우편번호찾기">
	<br>
	<input name="addr1" id="addr1" size="40" readonly=""
		placeholder="도로명주소" 
		value="${login.addr1}">
	<br>
	<span style="line-height: 10%;"><br></span>
	<input name="addr2" id="addr2" size="40" 
	value="${login.addr2}" placeholder="지번주소">
<!-- 다음주소 끝 -->
      <br>
휴대폰<select name="phone1" id="phone1">
      <c:choose>
       <c:when test="${login.phone1 == '010'}">
         <option value="010" selected>010</option>
         <option value="011">011</option>
         <option value="017">>017</option>
       </c:when>
       <c:when test="${login.phone1 == '011'}">
         <option value="010" >010</option>
         <option value="011" selected>011</option>
         <option value="017">017</option>
       </c:when>
      <c:when test="${login.phone1 == '017'}">
         <option value="010" >010</option>
         <option value="011" >011</option>
         <option value="017" selected>017</option>
      </c:when>
    </c:choose>
     </select>-
     <input type="text" name="phone2" id="phone2" 
     value="${login.phone2}" >-
     <input type="text" name="phone3" id="phone3" 
     value="${login.phone3}" ><br>
이메일<input type="text" name="email1" id="email1" 
value="${login.email1}">@
<input type="text" name="email2" id="email2" 
value="${login.email2}"><br>
<button onclick="memberUpdate(myform)">수정</button><!-- js사용하는것 -->
						<!-- myform은 폼테그의 이름 -->
<button onclick="memberDelete(myform)">탈퇴</button> <!-- form에 액션이없어도 버튼클릭시에 보낼 수 있다 -->
</form>

<script>
	function memberUpdate(f){
		//f는 myform객체, action이 form태그의 action과 같은것
		f.action="MemberUpdateServlet";
	}
	function memberDelete(f){
		//form의 action을 고정하지않고 js로 유동적이 가능하다
		f.action="MemberDeleteServlet";
	}

</script>










