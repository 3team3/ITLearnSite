<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--JSTL CORE라이브러리 태그들 사용을 위한 선언 --%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>     
<c:set var="path" value="${pageContext.request.contextPath}"></c:set> 
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${path}/css/member.css" rel="stylesheet"> 
<title>장바구니</title>
<%
	request.setCharacterEncoding("utf-8");
%>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">

$(function(){ 
	  $('.bt_up').click(function(){ 
	    var n = $('.bt_up').index(this);
	    var num = $(".num:eq("+n+")").val();
	    num = $(".num:eq("+n+")").val(num*1+1); 
	  });
	  $('.bt_down').click(function(){ 
	    var n = $('.bt_down').index(this);
	    var num = $(".num:eq("+n+")").val();
	    num = $(".num:eq("+n+")").val(num*1-1); 
	  });
	}) 
</script>

</head>
<body data-spy="scroll" data-target=".site-navbar-target">
	<div class="site-wrap">
    <div class="site-section ftco-subscribe-1 site-blocks-cover pb-4" style="background-image: url('../images/bg_1.jpg')">
        <div class="container">
          <div class="row align-items-end">
            <div class="col-lg-7">
              <h2 class="mb-0">장바구니</h2>
              <p>장바구니->주문/결제->주문완료</p>
            </div>
          </div>
        </div>
      </div> 
    </div>

    <div class="custom-breadcrumns border-bottom">
      <div class="container">
        <a href="index.jsp">메인화면</a>
        <span class="mx-3 icon-keyboard_arrow_right"></span>
        <span class="current">장바구니</span>
      </div>
    </div>
	
	<!-- 장바구니에 대한 정보 출력 -->
	<center>	
		<div class="pagemargin">
		<div class="content">
		<table class="table">			
		<c:set var="j" value="0"/> 
			<!-- MemberListController에서 넘겨 받은 request영역 안에 있는 list사이즈 만큼 반복 -->
					<tr align="center">
					
						<tr>
							<th colspan="3">상품정보</th>
							<th colspan="2">수량</th>
							<th>가격</th>
							<th></th>
						</tr>
					
				
			 <c:forEach  var="cartlist"   items="${requestScope.cartlist}">	
					<tr>
						<td class="checkbox"><input type="checkbox"></td>
						<td class="img">이미지</td>
						<td class="name">${cartlist.pro_name }</td>
							<td class="count">
								<div class="quantity">
									<form action="cartEdit.cart">										
											<a href="#" id="minusbtn"><img src="${path}/images/minus.png" alt="" width="20px" height="20px" class="bt_down"/></a> 
											<input type="text" name="pro_cnt" value="${cartlist.pro_cnt }" class="num"> 
											<a href="#" id="plusbtn"><img src="${path}/images/plus.png" alt="" width="20px" height="20px" class="bt_up"/></a> 
											<input type="submit" class="btn btn-color1" value="변경">
									</form>
								</div>
							</td>													
						<td class="price"> ${cartlist.pro_price }</td>
						<td class="sort"> ${cartlist.pro_sort }</td>					
						<td class="delete"><input type="button" class="btn btn-color1" value="삭제" onclick="cartDelete.cart"></td>								
					</tr>	
				<%-- 	<tr>
						<td class="img">${memberlist.email}</td>
						<td class="name">${memberlist.pw}</td>
						<td class="count">${memberlist.name}</td>
						<td class="opt_change"> <input type="button" class="btn btn-color1" value="옵션변경"></td>
						<td class="price">${memberlist.gender}</td>					
						<td class="delete"><input type="button" class="btn btn-color1" value="삭제"></td>								
					</tr> --%>
					

				<!-- j변수 값 1씩 증가 -->
		<c:set var="j" value="${j+1}" />
			</c:forEach> 		
		</table>
		<div class="btn">
		<input type="button" class="btn btn-color1" value="선택상품주문">		
		<input type="button" class="btn btn-color1" value="장바구니 비우기">
		<input type="button" class="btn btn-color1" value="결제진행">
		</div>
		
		</div>
		</div>		
	</center>

	
</body>
</html>