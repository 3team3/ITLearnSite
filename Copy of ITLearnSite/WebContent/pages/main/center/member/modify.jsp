<%@page import="member.db.MemberBean"%>
<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String email = (String)session.getAttribute("email"); 
%>


<style type="text/css">
.form {
	width: 475px;
}
</style>

</head>

<body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">

	<div class="site-wrap">
		<div class="site-section ftco-subscribe-1 site-blocks-cover pb-4" style="background-image: url('../images/bg_1.jpg')">
			<div class="container">
				<div class="row align-items-end justify-content-center text-center">
					<div class="col-lg-7">
						<h2 class="mb-0">마이페이지</h2>
						<p>Mypage</p>
					</div>
				</div>
			</div>
		</div>

		<div class="custom-breadcrumns border-bottom">
			<div class="container">
				<a href="${path}/index.do">Home</a> <span class="mx-3 icon-keyboard_arrow_right"></span> <span class="current">마이페이지</span>
			</div>
		</div>


		<div class="justify-content-center text-center section-title-underline mt-5">
			<h2>
				<span>회원정보 수정</span>
			</h2>
		</div>

		<div class="site-section">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-md-5">
						<div class="row">
							<form class="form" onsubmit="return submitter();" action="UpdateMember.do" method="post">
								<div class="col-md-12 form-group">
									<div class="form-group">
										<h4>기본 정보</h4>
									</div>
									<label for="email">아이디</label> <input type="email" name="email" id="email" readonly value="${mBean.email}"
										class="form-control form-control-lg">
								</div>
								<div class="col-md-12 form-group">
									<label for="pw1">패스워드</label> <input type="password" name="pw1" id="pw1" class="form-control form-control-lg" onkeyup="pwdRegChk();"
										required="required">
								</div>
								<div class="col-md-12 form-group">
									<label for="pw2">패스워드 확인</label> <input type="password" name="pw2" id="pw2" class="form-control form-control-lg" onkeyup="pwdEqualChk();"
										required="required">
								</div>
								<div class="col-md-12 form-group">
									<label for="name">이름</label> <input type="text" name="name" id="name" value="${mBean.name}" readonly="readonly"
										class="form-control form-control-lg">
								</div>
								<div class="col-md-12 form-group">
									<label for="gender">성별</label><br>
									<c:if test="${mBean.gender eq '1'}">
										<input type="radio" name="gender" id="gender1" value="1" required="required" checked="checked">남 &nbsp; 
									<input type="radio" name="gender" id="gender2" value="2" required="required" disabled="disabled">여<br>
									</c:if>
									<c:if test="${mBean.gender eq '2'}">
										<input type="radio" name="gender" id="gender1" value="1" required="required" disabled="disabled">남 &nbsp; 
									<input type="radio" name="gender" id="gender2" value="2" required="required" checked="checked">여<br>
									</c:if>
								</div>
								<div class="col-md-12 form-group mb-3">
									<label for="birth">생년월일</label><br> <label for="birth_year">년</label> <input type="text" name="birth_year" value="${mBean.birth_year}"
										readonly class="form-control form-control-lg"> <label for="birth_month">월</label> <input type="text" name="birth_month"
										value="${mBean.birth_month}" readonly class="form-control form-control-lg"> <label for="birth_day">일</label> <input type="text"
										name="birth_day" value="${mBean.birth_day}" readonly class="form-control form-control-lg">
								</div>

								<div class="form-group mt-5">
									<h4>추가 정보</h4>
								</div>
								<div class="col-md-12 form-group">
									<label for="phonenumber">휴대전화</label> <input type="text" name="phonenumber" id="phonenumber" value="${mBean.phonenumber}" required="required"
										class="form-control form-control-lg">
								</div>
								<div class="col-md-12 form-group">
									<label for="address">주소</label> <input type="text" name="address" id="address" placeholder="우편번호" value="${mBean.address}"
										readonly="readonly" class="form-control form-control-lg"> <br> <input type="button" onclick="DaumPostcode();"
										class="btn btn-primary btn-lg" value="우편번호 찾기"><br> <input type="text" name="address1" id="address1" placeholder="주소"
										value="${mBean.address1}" readonly="readonly" required="required" class="mt-5 form-control form-control-lg"> <br> <input
										type="text" name="address2" id="address2" placeholder="상세주소" value="${mBean.address2}" required="required"
										class="form-control form-control-lg"> <br>
								</div>
								<div class="col-md-12 form-group">
									<label for="address">sms수신동의</label><br> <input type="checkbox" class="mb-5" name="sms" id="sms" value="1"><br>
								</div>
								<div class="col-md-12 form-group">
									<input type="submit" id="submit" value="수정하기" class="btn btn-primary btn-lg"> <input type="button" value="탈퇴하기"
										onclick="location.href='${path}/MemberDeleteAction.do'" class="btn btn-primary btn-lg">
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script type="text/javascript" src="${path}/js/DaumPostAPI.js"></script>
	<script type="text/javascript" src="${path}/js/commons.js"></script>
</body>

</html>

=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
<%
	request.setCharacterEncoding("UTF-8");
	String email = (String)session.getAttribute("email"); 
%>

</head>
<body>

	<h1>회원정보수정</h1>
	<form onsubmit="return modifySubmitter();" action="UpdateMember.do" method ="post">
		<fieldset>
			<legend>기본 정보</legend>
			<h5>아이디</h5>
				<input type="email" name="email" id="email" readonly value="${mBean.email}" > <br>
			<h5>패스워드</h5>
				<input type="password" name="pw1" id="pw1" onblur="pwdRegChk();" required="required"> <br>
			<h5>패스워드 확인</h5>
				<input type="password" name="pw2" id="pw2" onkeyup="pwdEqualChk();" required="required"> <br>
			<h5>이름</h5>
				<input type="text" name="name" id="name" value="${mBean.name}" readonly="readonly"> <br>
			<h5>성별</h5> <br>
				<c:if test="${mBean.gender eq '1'}">
					<input type="radio" name="gender" id="gender1" value="1" required="required" checked="checked">남 &nbsp; 
					<input type="radio" name="gender" id="gender2" value="2" required="required" disabled="disabled">여<br>
				</c:if>
				<c:if test="${mBean.gender eq '2'}">
					<input type="radio" name="gender" id="gender1" value="1" required="required" disabled="disabled">남 &nbsp; 
					<input type="radio" name="gender" id="gender2" value="2" required="required" checked="checked">여<br>
				</c:if>
			<h5>생년월일</h5>
			<br>
			<h5>연</h5>
				<input type="text" name="birth_year" value="${mBean.birth_year}" readonly>
			<h5>월</h5>
				<input type="text" name="birth_month" value="${mBean.birth_month}" readonly>
			<h5>일</h5>
				<input type="text" name="birth_day" value="${mBean.birth_day}" readonly>
		</fieldset>
		
		<fieldset>
			<legend>추가 정보</legend>
			<h5>휴대전화</h5>
			<input type="text" name="phonenumber" id="phonenumber" value="${mBean.phonenumber}" required="required"> <br>
			<input type="text" name="address" id="address" placeholder="우편번호" value="${mBean.address}" readonly="readonly"> <br> 
			<input type="button" onclick="DaumPostcode();" value="우편번호 찾기"><br> 
			<input type="text" name="address1" id="address1" placeholder="주소" value="${mBean.address1}" readonly="readonly" required="required"> <br> 
			<input type="text" name="address2" id="address2" placeholder="상세주소" value="${mBean.address2}" required="required"> <br>
		 	<h5>sms수신동의</h5>
			<input type="checkbox" name="sms" id="sms" value="1"><br>
			<input type="submit" id="submit" value="수정하기">
			<input type="button" value="탈퇴하기" onclick="location.href='${path}/MemberDeleteAction.do'" >
		</fieldset>
		
	</form>
	
	<script type="text/javascript"
		src="http://code.jquery.com/jquery-latest.js"></script>
	<script
		src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script type="text/javascript" src="${path}/js/DaumPostAPI.js"></script>
	<script type="text/javascript" src="${path}/js/commons.js"></script>
	
</body>
</html>
>>>>>>> refs/remotes/origin/ran
