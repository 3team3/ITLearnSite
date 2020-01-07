<%@page import="member.member.db.MemberBean"%>
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
	<form action="${path}/UpdateMember.do" method ="post">
		<fieldset>
			<legend>기본 정보</legend>
			<h5>아이디</h5>
				<input type="email" name="email" id="email" readonly value="${mBean.email}" > <br>
			<h5>패스워드</h5>
				<input type="password" name="pw1" id="pw1" onkeyup="pwdRegChk();" required="required"> <br>
			<h5>패스워드 확인</h5>
				<input type="password" name="pw2" id="pw2" onkeyup="pwdEqualChk()"; required="required"> <br>
			<h5>이름</h5>
				<input type="text" name="name" id="name" value="${mBean.name}" readonly="readonly"> <br>
			<h5>성별</h5> <br>
				<input type="radio" name="gender" id="gender1" value="1" required="required">남 &nbsp; 
				<input type="radio" name="gender" id="gender2" value="2" required="required">여<br>
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
			<input type="submit" id="submit" value="수정하기" onclick="checkSms();">
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