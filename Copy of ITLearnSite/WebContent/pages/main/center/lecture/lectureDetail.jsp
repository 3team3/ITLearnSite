<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<c:set var="naver" value="${requestScope.result}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${path}/css/lectureDetail.css" rel="stylesheet">
</head>

<body>
	<div class="site-section ftco-subscribe-1 site-blocks-cover pb-4"
		style="background-image: url('../images/bg_1.jpg')">
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
			<a href="${path}/index.do">Home</a> <span
				class="mx-3 icon-keyboard_arrow_right"></span> <span class="current">해당
				도서 정보</span>
		</div>
	</div>
	<div class="pagewrap">
		<div class="list">
			<div class='wrap'>
				<div class='bookimg'>
					<img src='${path }/pages/main/center/lecture/temp/${lecture.lec_imgfile }'>
				</div>
				<div class='bookinfo'>
					<span class='booktitle'> </span> <span class='bookdetail'>
						<div class='detail-align'>
							<p class='p1'>정&nbsp;&nbsp;&nbsp;가</p>
							<p class='p2'>원</p>
						</div>
						<div class='detail-align'>
							<p class='p1'>출&nbsp;&nbsp;&nbsp;간</p>
							<p class='p2'></p>
						</div>
						<div class='detail-align'>
							<p class='p1'>지은이</p>
							<p class='p2'></p>
						</div>
						<div class='detail-align'>
							<p class='p1'>부&nbsp;&nbsp;&nbsp;록</p>
							<p class='p2'>
								<a href='#'>자료실</a>
							</p>
						</div>
					</span> <span class='bookdetail2'><div class='detail-align'>
							<p class='p1'>분&nbsp;&nbsp;&nbsp;량</p>
							<p class='p2'>쪽</p>
						</div>
						<div class='detail-align'>
							<p class='p1'>구매</p>
							<p class='p2 buylink'></p>
						</div> </span>
				</div>
			</div>
		</div>

		<a class="link" href="${naver.items[0].link}">네이버 책</a>
		<div class="pagebottom">
			<div class="divide">
				<span>목차</span>
				<hr>
				<br> <span>1권 – 기본기 다지기</span><br>  <
				<br>
				<p>
					시나공 홈페이지(sinagong.gilbut.co.kr)에 15년간 쌓인 50만 회원들의 질문과 답변 데이터를 철저하게
					분석하여 1분 1초가 아까운 수험생들의 궁금증을 100% 반영하였습니다.<br> 무엇이든 물어보세요! <br>
					<br>‘수험생 지원센터 운영’ 공부하다 답답하거나 궁금한 내용이 있으면, 시나공 카페 ‘묻고 답하기’ 게시판에
					질문을 올리세요. 길벗알앤디의 전문가들이 빠짐없이 답변해드립니다. <br>이메일(qna@gilbut.co.kr)로
					질문해도 빠른 시간 내에 답변을 보내드립니다.<br>
					<br> ‘합격 보장’ 이메일 안내 서비스 제공
					<최신기출문제 3회분 및 해설> 최근에 출제된 기출문제<br>
					3회분에 문제마다 자세한 설명이 달려있어서 마무리 공부로 활용하기에 좋습니다. <br>
					최신기출문제로 현장 감각을 키우세요. 
				</p>
				
			</div>
		</div>
		<script src="${path}/js/jquery-3.3.1.min.js"></script>
</body>
</html>