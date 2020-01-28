<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--JSTL CORE라이브러리 태그들 사용을 위한 선언 --%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>     
<c:set var="path" value="${pageContext.request.contextPath}"></c:set> 
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${path}/css/member.css" rel="stylesheet"> 
<title>주문관리</title>
</head>
<c:set var="email" value="${sessionScope.email}"></c:set>
<c:if test="${email eq null}">
	<script type="text/javascript">
		alert("로그인 후 조회가능합니다.");
		location.href="${path}/index.do";
	</script>
</c:if>
<body data-spy="scroll" data-target=".site-navbar-target">
	<div class="site-wrap">
    <div class="site-section ftco-subscribe-1 site-blocks-cover pb-4" style="background-image: url('../images/bg_1.jpg')">
        <div class="container">
          <div class="row align-items-end">
            <div class="col-lg-7">
              <h2 class="mb-0">주문확인</h2>
              <p>Order confirmation</p>
            </div>
          </div>
        </div>
      </div> 
    </div>

    <div class="custom-breadcrumns border-bottom">
      <div class="container">
        <a href="index.jsp">메인화면</a>
        <span class="mx-3 icon-keyboard_arrow_right"></span>
        <span class="current">주문확인</span>
      </div>
    </div>

	<center>	
		<div class="pagemargin">
		<div class="content">
		<h3>결제 전</h3>
		
		<table class="table">
			<tr class="tb_head">
				<td colspan="4">주문</td>
			</tr>
			<c:set var="j" value="0"/>
			<c:forEach  var="paymentList"   items="${requestScope.paymentList}"	>
			<c:if test="${paymentList.pay_option==0}">
			<tr>
				<td colspan="4">${j}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${paymentList.pay_name}</td>
				<td>전화번호</td>
				<td>${paymentList.pay_phonenumber}</td>
			</tr>
			<tr>			
				<td>우편번호</td>
				<td colspan="3">${paymentList.pay_address}</td>
			</tr>
			<tr>	
				<td colspan="4">${paymentList.pay_address1}</td>
			</tr>
			<tr>
				<td colspan="4">${paymentList.pay_address2}</td>		
			</tr>			
			<tr>			
				<td>분류</td>
				<td>주문상품</td>
				<td>개수</td>					
				<td>가격</td>
			</tr>
			<tr>
				<td>${paymentList.pay_pro1_sort}</td>
				<td>${paymentList.pay_pro1_name}</td>
				<td>${paymentList.pay_pro1_cnt}</td>
				<td>${paymentList.pay_pro1_price}</td>					
			</tr>
			<c:if test="${paymentList.pay_pro2_cnt!=0}">
			<tr>
				<td>${paymentList.pay_pro2_sort}</td>
				<td>${paymentList.pay_pro2_name}</td>
				<td>${paymentList.pay_pro2_cnt}</td>
				<td>${paymentList.pay_pro2_price}</td>
			</tr>
			</c:if>
			<c:if test="${paymentList.pay_pro3_cnt!=0}">
			<tr>
				<td>${paymentList.pay_pro3_sort}</td>
				<td>${paymentList.pay_pro3_name}</td>
				<td>${paymentList.pay_pro3_cnt}</td>
				<td>${paymentList.pay_pro3_price}</td>
			</tr>
			</c:if>
			<c:if test="${paymentList.pay_pro4_cnt!=0}">
			<tr>
				<td>${paymentList.pay_pro4_sort}</td>
				<td>${paymentList.pay_pro4_name}</td>
				<td>${paymentList.pay_pro4_cnt}</td>
				<td>${paymentList.pay_pro4_price}</td>
			</tr>
			</c:if>
			<c:if test="${paymentList.pay_pro5_cnt!=0}">
			<tr>
				<td>${paymentList.pay_pro5_sort}</td>
				<td>${paymentList.pay_pro5_name}</td>
				<td>${paymentList.pay_pro5_cnt}</td>
				<td>${paymentList.pay_pro5_price}</td>
			</tr>
			</c:if>
		
			<tr>
				<td colspan="3">결제 금액</td>
				<td>${paymentList.pay_total}</td>
			</tr>
			<tr>
				<td colspan="3">결제 여부</td>			
				<td>결제안함</td>		
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td>주문취소</td>	
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td><input type="button" class="btn btn-color1" value="x" onclick="location.href='${path}/paymentDelete.pay'"></td>	
			</tr>
				<!-- j변수 값 1씩 증가 -->
				<c:set var="j" value="${j+1}" />
			</c:if>				
			</c:forEach> 
			

		</table>
		<h3>결제 후</h3>
		<table class="table after ">
			<c:set var="j" value="0"/>
			<c:forEach  var="paymentList"   items="${requestScope.paymentList}"	>
			<c:if test="${paymentList.pay_option==1}">
			<tr class="tb_head">
				<td colspan="4">주문</td>
			</tr>
			
			<tr>
				<td>이름</td>
				<td>${paymentList.pay_name}</td>
				<td>전화번호</td>
				<td>${paymentList.pay_phonenumber}</td>
			</tr>
			<tr>			
				<td>우편번호</td>
				<td colspan="3">${paymentList.pay_address}</td>
			</tr>
			<tr>	
				<td colspan="4">${paymentList.pay_address1}</td>
			</tr>
			<tr>
				<td colspan="4">${paymentList.pay_address2}</td>		
			</tr>			
			<tr>			
				<td>분류</td>
				<td>주문상품</td>
				<td>개수</td>					
				<td>가격</td>
			</tr>
			<tr>
				<td>${paymentList.pay_pro1_sort}</td>
				<td>${paymentList.pay_pro1_name}</td>
				<td>${paymentList.pay_pro1_cnt}</td>
				<td>${paymentList.pay_pro1_price}</td>					
			</tr>
			<c:if test="${paymentList.pay_pro2_cnt!=0}">
			<tr>
				<td>${paymentList.pay_pro2_sort}</td>
				<td>${paymentList.pay_pro2_name}</td>
				<td>${paymentList.pay_pro2_cnt}</td>
				<td>${paymentList.pay_pro2_price}</td>
			</tr>
			</c:if>
			<c:if test="${paymentList.pay_pro3_cnt!=0}">
			<tr>
				<td>${paymentList.pay_pro3_sort}</td>
				<td>${paymentList.pay_pro3_name}</td>
				<td>${paymentList.pay_pro3_cnt}</td>
				<td>${paymentList.pay_pro3_price}</td>
			</tr>
			</c:if>
			<c:if test="${paymentList.pay_pro4_cnt!=0}">
			<tr>
				<td>${paymentList.pay_pro4_sort}</td>
				<td>${paymentList.pay_pro4_name}</td>
				<td>${paymentList.pay_pro4_cnt}</td>
				<td>${paymentList.pay_pro4_price}</td>
			</tr>
			</c:if>
			<c:if test="${paymentList.pay_pro5_cnt!=0}">
			<tr>
				<td>${paymentList.pay_pro5_sort}</td>
				<td>${paymentList.pay_pro5_name}</td>
				<td>${paymentList.pay_pro5_cnt}</td>
				<td>${paymentList.pay_pro5_price}</td>
			</tr>
			</c:if>
		
			<tr>
				<td colspan="3">결제 금액</td>
				<td>${paymentList.pay_total}</td>
			</tr>
			<tr>
				<td colspan="3">결제 여부</td>			
				<td>결제함</td>		
			</tr>
			
				<!-- j변수 값 1씩 증가 -->
				<c:set var="j" value="${j+1}" />
			</c:if>				
			</c:forEach> 
			

		</table>
		</div>
		</div>
	</center>

	
</body>
</html>