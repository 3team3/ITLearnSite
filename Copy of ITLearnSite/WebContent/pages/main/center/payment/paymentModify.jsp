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
<title>주문 확인</title>
</head>
<body data-spy="scroll" data-target=".site-navbar-target">
	<div class="site-wrap">
    <div class="site-section ftco-subscribe-1 site-blocks-cover pb-4" style="background-image: url('../images/bg_1.jpg')">
        <div class="container">
          <div class="row align-items-end">
            <div class="col-lg-7">
              <h2 class="mb-0">주문 확인</h2>
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
        <span class="current">주문 확인</span>
      </div>
    </div>
	
	<!-- 주문페이지 시작  -->

	<form class="form" action="" method="post">
	<div class="site-section">
	<div class="row justify-content-center">
	<div class="col-md-5">
	<div class="row"> 
		<!-- 회원&배송지 정보 시작 -->
		<div>
		<h3>배송지 정보</h3>
            <div class="col-md-12 form-group">
            <label>이름*</label>
           	<input type="text" id="pay_name" name="pay_name" required class="form-control form-control-lg"><br>
            </div>
            
            <div class="col-md-12 form-group">
            <label>전화번호*</label>
           	<input type="text" id="pay_phonenumber" name="pay_phonenumber"  required class="form-control form-control-lg"><br>
            </div>
            
            <div class="col-md-12 form-group">
	            <label for="address">주소</label>
	            <input type="text" name="address" id="address" placeholder="우편번호" readonly="readonly" class="form-control form-control-lg" onblur="addressChk();"> <br> 
				<input type="button" onclick="DaumPostcode();" class="btn btn-primary btn-lg" value="우편번호 찾기"><br>
				<input type="text" name="address1" id="address1" placeholder="주소" readonly="readonly" class="mt-5 form-control form-control-lg" onblur="addressChk();"> <br> 
				<input type="text" name="address2" id="address2" placeholder="상세주소" class="form-control form-control-lg" onblur="addressChk();"> <br>
			</div>
	
			<hr>
			
           
           	<input id="deliveryOption1" name="delivery-option" checked="checked" type="radio" value="기본 배송지" onclick="origin_delivery()" required>
            <label for="deliveryOption1">기존 배송지</label>
                                   
            <input id="deliveryOption2" name="delivery-option" type="radio" value="새로운 배송지" onclick="new_delivery()"  required>
            <label for="deliveryOption2">새로 입력</label>

                            
            <hr>
            <span>계좌이체</span>
            <div>부산은행 아이티윌<br>
            	123-45-678901-2
            </div>
       </div>
        <!-- 회원&배송지 정보 끝 -->
        
        <!-- 장바구니 정보--> 
		<div>
        <h3>장바구니</h3>    	
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
                  
            <button type="submit" class="btn btn-primary btn-lg">주문하기</button>
    	</div>
  	</div>
  	</div>
  	</div>
  	</div>
  	</form>

    <!-- 주문 페이지 끝 -->
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script type="text/javascript" src="${path}/js/DaumPostAPI.js"></script>
</body>
</html>