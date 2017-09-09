<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


    
<table width="100%" cellspacing="0" cellpadding="0" >
	<tr border="1">
		<td height="30">
	</tr>
	
	
	<tr>
		<td>
			<table align="center" width="710" cellspacing="0" cellpadding="0"
				border="0">
				
				<tr>
					<td height="5"></td>
				</tr>
				<tr>
					<td height="1" colspan="8" bgcolor="CECECE"></td>
				</tr>
				<tr>
					<td height="10"></td>
				</tr>

				<tr>
<c:forEach var="xxx" items="${goodsList}" varStatus="status" >

<!-- 0. 이 테이블을 4열로 표현할것 
		변수명은 xxx로 주고 GoodsListServlet에 저장된 goodsList를 저장하자-->
						<td>
							<table style='padding:15px'>
								<tr><!-- 이미지  gImage-->
									<td>
										<a href="GoodsRetrieveServlet?gCode=${xxx.gCode}">
											<!--xxx에 저장된 list의 gCode로 이동하는 하이퍼링크-->
											<img src="images/items/${xxx.gImage }.gif" 
													border="0" align="center" width="200">
										</a>
									</td>
								</tr>
								
								<tr><!-- 공백 -->
									<td height="10">
								</tr>
								
								<tr><!-- 상품명  gCode, 상품이름 gName-->
									<td class= "td_default" align ="center">
										<a class= "a_black" href="GoodsRetrieveServlet?gCode=${xxx.gCode }"> 
											${xxx.gName }<br>
										</a>
											<font color="gray">--------------------</font>
									</td>
								</tr>
								
								<tr><!-- 공백 -->
									<td height="10" />
								</tr>
								
								<tr><!-- 꼬리말 gContent -->
									<td class="td_gray" align ="center">
										${xxx.gContent }
									</td>
								</tr>
								
								<tr><!-- 공백 -->
									<td height="10">
								</tr>
								
								<tr><!-- 가격 gPrice-->
									<td class="td_red" align ="center">
										<font color="red"><strong>${xxx.gPrice }</strong></font>
									</td>
								</tr>
								
							</table>
						</td>
						
						<c:if test="${(status.index+1)%4==0 }"> <!-- index는 0부터시작한다 -->
							<!-- a-2. 이걸 4번째마다한다 -->
							<!-- a-1.tr은 행바꿈 -->
							<tr>
							</tr>
						</c:if>
						
</c:forEach>


				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td height="10">
	</tr>
</table>