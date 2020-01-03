<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<div>
		<form action="${path}/insertMember.do" method="post">
			<h5>아이디</h5>
			<input type="email" name="email" id="email" onkeyup="emailDupChk();">
			<br>
			<h5>패스워드</h5>
			<input type="password" name="pw1" id="pw1" onkeyup="pwdRegChk();">
			<br>
			<h5>패스워드 확인</h5>
			<input type="password" name="pw2" id="pw2" onkeyup="pwdEqualChk();">
			<br>
			<h5>이름</h5>
			<input type="text" name="name" id="name" onkeyup="nameChk();">
			<br>
			<h5>성별</h5>
			<br> <input type="radio" name="gender" id="gender1" value=1>남
			&nbsp; <input type="radio" name="gender" id="gender2" value=2>여<br>
			<h5>생년월일</h5>
			<br>
			<h5>연</h5>
			<c:set var="i" value="1980"></c:set>
			<!-- int i = 0 와 같은 의미 -->
			<select name="birth_year">
				<c:forEach begin="1900" end="2020" step="1" var="year">
					<option value="${year}" <c:if test="${year==i}"> selected </c:if>>${year}년</option>
				</c:forEach>
			</select>
			<h5>월</h5>
			<select name="birth_month">
				<c:forEach begin="1" end="12" step="1" var="month">
					<option value="${month}">${month}월</option>
				</c:forEach>
			</select>
			<h5>일</h5>
			<select name="birth_day">
				<c:forEach begin="1" end="31" step="1" var="day">
					<option value="${day}">${day}일</option>
				</c:forEach>
			</select>
			<h5>휴대전화</h5>
			<input type="text" name="phonenumber" id="phonenumber"> <br>
			<h5>주소</h5>
			<input type="text" name="address" id="address" placeholder="우편번호"
				readonly="readonly"> <br> <input type="button"
				onclick="DaumPostcode();" value="우편번호 찾기"><br> <input
				type="text" name="address1" id="address1" placeholder="주소"
				readonly="readonly"> <br> <input type="text"
				name="address2" id="address2" placeholder="상세주소"> <br>
			<h5>sms수신동의</h5>
			<input type="checkbox" name="sms" id="sms" value=1><br>
			<input type="submit" value="이메인 인증">
		</form>
	</div>
	<script type="text/javascript"
		src="http://code.jquery.com/jquery-latest.js"></script>
	<script
		src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script type="text/javascript" src="${path}/js/DaumPostAPI.js"></script>
	<script type="text/javascript" src="${path}/js/commons.js"></script>

</body>
</html>