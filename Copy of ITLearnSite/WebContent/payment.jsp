<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" href="${path}/css/style.css">

</head>

<body>
   <!-- 주문페이지 시작  -->
	<form action="" method="post">
	<div class="payment">
		<!-- 회원&배송지 정보 시작 -->
		<div class="payment_left">
		<h2>배송지 정보</h2>
        	<label>아이디*</label>
            <input type="text" id="" name="" readonly><br>
            
            <label>이름*</label>
           	<input type="text" id="" name="" placeholder="" required><br>
            
			<label>주소*</label><br>
			<input type="text" name="" id="" placeholder="우편번호" required readonly>
			
			<input type="button" onclick="execDaumPostcode1()" value="찾기" class="btn"><br>
				
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
                                          

        </div>    
        <!-- 회원&배송지 정보 끝 -->
        
        <!-- 장바구니 정보--> 
        <div class="payment_right">   
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
                  
            <button class="btn btn_right" type="submit">주문하기</button>
        </div>
    </div>    
  	</form>
    <!-- 주문 페이지 끝 -->
    
</body>

</html>