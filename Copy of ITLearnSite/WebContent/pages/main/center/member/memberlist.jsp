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
<body>
	<!-- 전체 회원에 대한 정보 출력 -->
	<center>	
		<table class="list">
			<tr>
				<td colspan="12">회원 목록</td>
			</tr>
			<c:set var="j" value="0"/>
			<!-- MemberListController에서 넘겨 받은 request영역 안에 있는 list사이즈 만큼 반복 -->
			<c:forEach  var="memberlist"   items="${requestScope.memberlist}">		
					
					<tr align="center">
						<td>이메일</td>
						<td>비밀번호</td>
						<td>이름</td>
						<td>성별</td>
						<td>생년</td>
						<td>생월</td>
						<td>생일</td>
						<td>전화번호</td>
						<td>우편번호</td>
						<td>주소</td>
						<td>상세주소</td>
						<td>sms동의 여부</td>		
						<td>주문정보</td>
						<td></td>
					</tr>
					<tr>
						<td>${memberlist.email}</td>
						<td>${memberlist.pw}</td>
						<td>${memberlist.name}</td>
						<td>${memberlist.gender}</td>
						<td>${memberlist.name}</td>
						<td>${memberlist.birth_year}</td>
						<td>${memberlist.birth_month}</td>
						<td>${memberlist.birth_day}</td>
						<td>${memberlist.phonenumber}</td>
						<td>${memberlist.address}</td>
						<td>${memberlist.address1}</td>
						<td>${memberlist.address2}</td>
						<td>${memberlist.sms}</td>
						<td><input type="button" value="회원주문정보" onclick="location.href='${path}/AdminMemberOrder.do?email=${memberlist.email}'"></td>
						<td><input type="button" value="회원삭제" onclick="location.href='${path}/AdminMemberDelete.do?email=${memberlist.email}'"></td>						
					</tr>

				<!-- j변수 값 1씩 증가 -->
				<c:set var="j" value="${j+1}" />
			</c:forEach>	
		</table>
	</center>
</body>
</html>