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
<title>회원관리</title>
</head>
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
	
	<!-- 전체 회원에 대한 정보 출력 -->
	<center>	
		<div class="pagemargin">
		<div class="content">
		<table class="table">
			<tr class="tb_head">
				<td colspan="12">주문 목록</td>
			</tr>
			<%-- <c:set var="j" value="0"/> --%>
			<!-- MemberListController에서 넘겨 받은 request영역 안에 있는 list사이즈 만큼 반복 -->
					<tr align="center">
						<td>이름</td>
						<td>전화번호</td>
						<td>우편번호</td>
						<td>주소</td>
						<td>상세주소</td>
						<td>강의</td>
						<td>교재</td>
						<td>교재 개수</td>
						<td>금액</td>
						<td>결제여부</td>
						<td>주문취소</td>
						<td>주문수정</td>		
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><input type="button" class="btn btn-color1" value="x" onclick="location.href='${path}/paymentDelete.pay'"></td>
						<td><input type="button" class="btn btn-color1" value="주문수정" onclick="location.href='${path}/paymentModify.pay'"></td>		
					</tr>
			<%-- <c:forEach  var="memberlist"   items="${requestScope.memberlist}">		
					

				<!-- j변수 값 1씩 증가 -->
				<c:set var="j" value="${j+1}" />
			</c:forEach> --%>	
		</table>
		</div>
		</div>
	</center>

	
</body>
</html>