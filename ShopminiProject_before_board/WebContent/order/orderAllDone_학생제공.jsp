<%@page import="java.util.List"%>
<%@page import="com.dto.OrderDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>	    
	

<table width="70%" cellspacing="0" cellpadding="0">

	<tr>
		<td height="30">
	</tr>

	<tr>
		<td><b>주문완료</b></td>
	</tr>

	<tr>
		<td height="30">
	</tr>

	<tr>
		<td align="center"><b>주문해주셔서 감사합니다.</b></td>
	</tr>

	<tr>
		<td height="7">
	</tr>

	<tr>
		<td class="td_default" align="center"><b>a</b> 님의 주문이
			안전하게 처리되었습니다.</td>
	</tr>

	<tr>
		<td height="40">
	</tr>

	<tr>
		<td class="td_default"><b>상품 및 배송정보</b>
		</td>
	</tr>

	<tr>
		<td height="15">
	</tr>

	<tr>
		<td>
			<table width="100%" border="1" style="border-collapse: collapse"
				bordercolor="#CCCCCC">
				<tr>
					<td class="td_default" width="150" height="35"> 받으시는 분</td>
					<td class="td_default" height="35">a</td>
				</tr>
				<tr>
					<td class="td_default" height="35"> 주소</td>
					<td class="td_default" height="35"> (612-894)<br>
						부산 해운대구 APEC로 30 (우동, 벡스코제2전시장)부산 해운대구 우동 1413-4
					</td>
				</tr>
				
				<tr>
					<td class="td_default" height="35"> 휴대전화</td>
					<td class="td_default" height="35"> 01011</td>
				</tr>
			</table>
	</tr>
	</td>

	<tr>
		<td height="20">
	</tr>

	<tr>
		<td>
			<table width="100%" border="1" style="border-collapse: collapse"
				bordercolor="#CCCCCC">
				<tr>
					<td width="250" class="td_default" height="35" align="center"><strong>상품명</strong></td>
					<td width="100" class="td_default" height="35" align="center"><strong>판매가</strong></td>
					<td class="td_default" width="50" height="35" align="center"><strong>수량</strong></td>
					<td class="td_default" width="100" height="35" align="center"><strong>합계</strong></td>
				</tr>

 		
   <!--  변수 선언 -->
    
	
    <!-- 누적 -->
				
				<tr>
					<td height="35" class="td_default">
						<span class="a_default">제나 레이스 스커트 </span>
					</td>
					<td height="35" class="td_default" align="center">
						<span  id = "price1">9800</span>원
					</td>
					<td height="35" class="td_default" align="center">
						<span id = "num1">3</span>권
					</td>
					<td height="35" class="td_default" align="center">
						<span>29400</span>원
					</td>
				</tr>
			
		

    <!-- 누적 -->
				
				<tr>
					<td height="35" class="td_default">
						<span class="a_default">레이스 프린지 스커트 </span>
					</td>
					<td height="35" class="td_default" align="center">
						<span  id = "price1">9800</span>원
					</td>
					<td height="35" class="td_default" align="center">
						<span id = "num1">3</span>권
					</td>
					<td height="35" class="td_default" align="center">
						<span>29400</span>원
					</td>
				</tr>
			
		

    <!-- 누적 -->
				
				<tr>
					<td height="35" class="td_default">
						<span class="a_default">인디안 무드 엔틱 니들 드레스 </span>
					</td>
					<td height="35" class="td_default" align="center">
						<span  id = "price1">37800</span>원
					</td>
					<td height="35" class="td_default" align="center">
						<span id = "num1">3</span>권
					</td>
					<td height="35" class="td_default" align="center">
						<span>113400</span>원
					</td>
				</tr>
			
		

			</table>
		</td>
	</tr>

	<tr>
		<td height="40">
	</tr>

	<tr>
		<td class="td_default"><b>결제정보</b></td>
	</tr>

	<tr>
		<td height="15">
	</tr>

	<tr>
		<td>
			<table width="100%" border="1" style="border-collapse: collapse"
				bordercolor="#CCCCCC">
				<tr>
					<td class="td_default" width="150" height="35"> 결제금액</td>
					<td class="td_default" height="35" align = 'right'> 
					<input type = 'text' id = 'total' value = '172200' readonly>원
					</td>
				</tr>
				<tr>
					<td class="td_default" width="150" height="35"> 결제수단</td>
					<td class="td_default" height="35" align = 'right'> 
					<span></span>
					</td>
				</tr>
			</table>
		</td>
	</tr>

	<tr>
		<td height="40">
	</tr>

	

	<tr>
		<td height="40">
	</tr>

	<tr>
		<td class="td_default" align="center"><a class="a_default"
			href="OrderListDetailServlet?mem_id=guest">주문조회 페이지로 이동</a></td>
	</tr>

	<tr>
		<td height="30">
	</tr>

</table>
