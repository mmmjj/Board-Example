<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>	

<table width="90%" cellspacing="0" cellpadding="0" border="0">

	<tr>
		<td height="30">
	</tr>

	<tr>
		<td colspan="5" class="td_default">&nbsp;&nbsp;&nbsp; <font
			size="5"><b>- 장바구니-</b></font> &nbsp;
		</td>
	</tr>

	<tr>
		<td height="15">
	</tr>

	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>

	<tr>
		<td height="7">
	</tr>

	<tr>
		<td class="td_default" align="center">
		<input type="checkbox" name="allCheck" id="allCheck" onchange="allCheck(this)"> <strong>전체선택</strong></td>
		<td class="td_default" align="center"><strong>주문번호</strong></td>
		<td class="td_default" align="center" colspan="2"><strong>상품정보</strong></td>
		<td class="td_default" align="center"><strong>판매가</strong></td>
		<td class="td_default" align="center" colspan="2"><strong>수량</strong></td>
		<td class="td_default" align="center"><strong>합계</strong></td>
		<td></td>
	</tr>

	<tr>
		<td height="7">
	</tr>
	<c:if test="${fn:length(cartList)==0}"> <!-- 이거뭐지 -->
	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>

	<tr>
		<td height="5">
	</tr>
	<tr>
		<td class="td_default" align="center">카트에 추가된 상품이 없습니다.</td>
	</tr>
	</c:if>
	
	<c:if test="${fn:length(cartList)!=0}">
	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>



	<form name="myForm">
	<c:forEach var="cartList" items="${cartList}" >
  <input type="hidden" name="userid" value="${cartList.userid }"/>
		<tr>
			<td class="td_default" width="80">
			<!-- checkbox는 체크된 값만 서블릿으로 넘어간다. 따라서 value에 삭제할 num값을 설정한다. -->
			<input type="checkbox"
				name="check" id="check${cartList.num}" class="check" value="${cartList.num }"></td>
			<td class="td_default" width="80">${cartList.num}</td>
			<td class="td_default" width="80">
				<img src="images/items/${cartList.gImage}.gif" border="0" align="center" width="80" /></td>
				
			<td class="td_default" width="300" style='padding-left: 30px'>
				${cartList.gName }<br>
				<font size="2" color="#665b5f">[옵션 : 사이즈(${cartList.gSize }), 색상(${cartList.gColor })]
				</font>
			</td>
			
			<td class="td_default" align="center" width="110">
			<fmt:formatNumber value="${cartList.gPrice}" type="currency" />
			</td>
			
			<td class="td_default" align="center" width="90">
				<input class="input_default" type="text" name="CART_AMOUNT" id="CART_AMOUNT${cartList.num}"
					   style="text-align: right" maxlength="3" size="2" value="${cartList.gAmount }"/>
			</td>
			
			<td><input type="button" value="수정" onclick="amountUpdate('${cartList.num}')" />
			</td>
			
			<td class="td_default" align="center" width="80" style='padding-left: 5px'>
				<span id="sum${cartList.num}">
				<fmt:formatNumber value="${cartList.gPrice * cartList.gAmount}" type="currency" />
				</span>
			</td>
				
			<td><input type="button" value="주문" onclick="order('${cartList.num}','${cartList.userid}')">
			</td>
			
			<td class="td_default" align="center" width="30" style='padding-left: 10px'>
				<input type="button" value="삭제" onclick="delCart('${cartList.num}')">
			</td>
			
			<td height="10"></td>
		</tr>
	</c:forEach>  
  

	</form>
	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>
	<tr>
		<td height="30">
	</tr>

	<tr>
		<td align="center" colspan="5">
			<a class="a_black" href="javascript:orderAll(myForm)"> 전체 주문하기 </a>&nbsp;&nbsp;&nbsp;&nbsp; 
			<a class="a_black" href="javascript:delAllCart(myForm)"> 전체 삭제하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a class="a_black" href="index.jsp"> 계속 쇼핑하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
	</tr>
	<tr>
		<td height="20">
	</tr>
</c:if>
</table>



<script>
	function orderAll(f){
		f.action="OrderConfirmAllServlet"
		f.submit();
	}

	function order(num, userid){
		location.href="OrderConfirmServlet?num="+num+"&userid="+userid;
	//number에해당되는물품정보 id에해당되는 개인정보
	}

	function delAllCart(f){
		f.action="CartDelAllServlet";//파라미터로 넘겨야하지않고 액션으로 넘김 폼안의 내용을
		f.submit();
	}
	
	function delCart(num){
		location.href="CartDelServlet?num="+num;
	}
	
	//수정하기
	function amountUpdate(num){
		var amount = document.getElementById("CART_AMOUNT"+num).value;
		location.href="CartAmountUpdateServlet?num="+num+"&amount="+amount;
	}
	//전체선택
	function allCheck(chk){
		var check = document.querySelectorAll(".check");
		for(i=0;i<check.length;i++){
			console.log(check[i].checked);
			check[i].checked=chk.checked;
		}
	}
</script>

<c:if test="${!empty requestScope.amountUpdate }">
  <script>
    alert('${requestScope.amountUpdate}');
  </script>
</c:if>