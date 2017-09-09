<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%><!--멤버폼 안의 멤버폼, 테이블넣을것 -->
<style type="text/css">
.blue {
	color: blue;
}

.red {
	color: red;
}
</style>
<script type="text/javascript" src="../jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
	})



</script>

<!-- DAUM 주소 라이브러리 시작 -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="js/daum.js"></script>
<!-- DAUM 주소 라이브러리 끝 -->
<form action="MemberAddServlet">
	아이디<input type="text" name="userid" id="userid"> <span
		id="result"></span><br> 비밀번호<input type="password" name="passwd"
		id="passwd"> <span id="result2"></span><br> 비밀번호<input
		type="password" name="passwd2" id="passwd2"><br> 이름<input
		type="text" name="username" id="username"><br>
	<!-- 다음주소 시작-->
	<input name="post1" id="post1" size="5" readonly=""> - <input
		name="post2" id="post2" size="5" readonly=""> <input
		onclick="openDaumPostcode()" type="button" value="우편번호찾기"> <br>
	<input name="addr1" id="addr1" size="40" readonly=""
		placeholder="도로명주소"> <br> <span style="line-height: 10%;"><br></span>
	<input name="addr2" id="addr2" size="40" placeholder="지번주소">
	<!-- 다음주소 끝 -->
	<br> 휴대폰<select name="phone1" id="phone1">
		<option value="010">010</option>
		<option value="011">011</option>
		<option value="017">017</option>
	</select>- <input type="text" name="phone2" id="phone2">- <input
		type="text" name="phone3" id="phone3"><br> 이메일<input
		type="text" name="email1" id="email1">@ <input type="text"
		name="email2" id="email2"><br> <input type="submit"
		value="회원가입"> <input type="reset" value="취소">
</form>
