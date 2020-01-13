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
<link href="${path}/css/style.css" rel="stylesheet"> 
<title>결제 페이지</title>
</head>
<body data-spy="scroll" data-target=".site-navbar-target">
	<div class="site-wrap">
    <div class="site-section ftco-subscribe-1 site-blocks-cover pb-4" style="background-image: url('../images/bg_1.jpg')">
        <div class="container">
          <div class="row align-items-end">
            <div class="col-lg-7">
              <h2 class="mb-0">결제페이지</h2>
              <p>by admin@admin.com</p>
            </div>
          </div>
        </div>
      </div> 
    </div>

    <div class="custom-breadcrumns border-bottom">
      <div class="container">
        <a href="index.jsp">메인화면</a>
        <span class="mx-3 icon-keyboard_arrow_right"></span>
        <span class="current">회원관리</span>
      </div>
    </div>
	
	<!-- 주문페이지 시작  -->
	<form action="" method="post">

		<!-- 회원&배송지 정보 시작 -->
		
		<h2>배송지 정보</h2>
        	<label>아이디*</label>
            <input type="text" id="" name="" readonly><br>
            
            <label>이름*</label>
           	<input type="text" id="" name="" placeholder="" required><br>
            
			<label>주소*</label><br>
			<input type="text" name="" id="" placeholder="우편번호" required readonly>
			
			<input type="button" onclick="execDaumPostcode1()" value="찾기" ><br>
				
			<input type="text" name="" id="" placeholder="주소" required readonly>
			<input type="text" name="" id="" placeholder="상세주소" required><br>
	
			<hr>
			
           
           	<input id="deliveryOption1" name="delivery-option" checked="checked" type="radio" value="기본 배송지" onclick="" required>
            <label for="deliveryOption1">기존 배송지</label>
                                   
            <input id="deliveryOption2" name="delivery-option" type="radio" value="새로운 배송지" onclick=""  required>
            <label for="deliveryOption2">새로 입력</label>

                            
            <hr>
            <span>계좌이체</span>
            <div>부산은행 아이티윌<br>
            	123-45-678901-2
            </div>
                                          
 
        <!-- 회원&배송지 정보 끝 -->
        
        <!-- 장바구니 정보--> 

        <h2>장바구니</h2>
        	<h3>교재</h3>
      		<%--상품이름  --%>상품이름자리~~~
                                 가격:<%--상품가격 --%>원 |개수:<%--상품개수 --%>개
			
			<h3>강의</h3>
			<%--강의이름  --%>강의이름자리~~
                                 가격:<%--강의가격 --%>원 
       		<hr>
       			
           	<h2>주문하기</h2>

            <h3>총금액</h3>
            <div>원</div> 
                                
            <h3>할인금액</h3>
            <div>원</div>                       
            
            <hr>
                               
            <h3>결제금액</h3>
            <div>원</div>
                  
            <button type="submit">주문하기</button>
    
  	</form>
    <!-- 주문 페이지 끝 -->
    
	
</body>
</html>