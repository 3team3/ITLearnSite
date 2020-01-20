<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<c:set var="naver" value="${requestScope.result}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${path}/css/bookView.css" rel="stylesheet">
</head>

<body>
	<div class="site-section ftco-subscribe-1 site-blocks-cover pb-4" style="background-image: url('../images/bg_1.jpg')">
		<div class="container">
			<div class="row align-items-end justify-content-center text-center">
				<div class="col-lg-7">
					<h2 class="mb-0">해당 도서 정보</h2>
				</div>
			</div>
		</div>
	</div>
	<div class="custom-breadcrumns border-bottom">
		<div class="container">
			<a href="${path}/index.do">Home</a> <span class="mx-3 icon-keyboard_arrow_right"></span> <span class="current">해당 도서 정보</span>
		</div>
	</div>
	<div class="pagewrap">
		<div class="list"></div>
	</div>
	<div class="pagewrap">
		<div class="defaultimg">
			<img src="${path}/images/detailpage.jpg">
			<hr>
		</div>
	</div>
	<a class="link" href="${naver.items[0].link}">네이버 책</a>
	<div class="pagebottom">
		<div class="divide">
			<span>목차</span><hr><br> <span>1권 – 기본기 다지기</span><br> <span>2권 – 엑셀 함수 사전+함수 문제 모음 22회 </span><br> <span>PDF 부록 – 실전 모의고사 10회 -
				시간이 부족한 수험생들의 궁금증 완전 해결!</span><br><br>
			<p>
		시나공 홈페이지(sinagong.gilbut.co.kr)에 15년간 쌓인 50만 회원들의 질문과 답변 데이터를 철저하게 분석하여 1분 1초가 아까운 수험생들의 궁금증을 100% 반영하였습니다.<br>
		무엇이든 물어보세요! <br><br>‘수험생 지원센터 운영’ 공부하다 답답하거나 궁금한 내용이 있으면, 시나공 카페 ‘묻고 답하기’ 게시판에 질문을 올리세요. 
		길벗알앤디의 전문가들이 빠짐없이 답변해드립니다. <br>이메일(qna@gilbut.co.kr)로 질문해도 빠른 시간 내에 답변을 보내드립니다.<br><br>
		‘합격 보장’ 이메일 안내 서비스 제공 <최신기출문제 3회분 및 해설> 최근에 출제된 기출문제<br>
		3회분에 문제마다 자세한 설명이 달려있어서 마무리 공부로 활용하기에 좋습니다. <br>최신기출문제로 현장 감각을 키우세요. 
		
			</p>
			<div class="author">
				<span>저자</span>
				<hr>
				<span>${naver.items[0].author} </span>

			</div>
			<div class="description">
				<span>요약</span>
				<hr>
				<span>${naver.items[0].description}</span>
			</div>
		</div>
	</div>
	<script src="${path}/js/jquery-3.3.1.min.js"></script>
	<script src="${path}/js/makejs/bookList.js"></script>
</body>
</html>