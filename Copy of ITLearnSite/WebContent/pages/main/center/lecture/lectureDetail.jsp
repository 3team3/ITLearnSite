<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<c:set var="lecBean" value="${lec_DetailMap.lec_Detail }" />
<c:set var="lec_list" value="${lec_DetailMap.lec_list }" />

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
					<h2 class="mb-0">강의 상세</h2>
					<p>Lecture Register</p>
				</div>
			</div>
		</div>
	</div>

	<div class="custom-breadcrumns border-bottom">
		<div class="container">
			<a href="${path}/index.do">Home</a> <span
				class="mx-3 icon-keyboard_arrow_right"></span> <a
				href="${path}/lectureList.lec">강의실</a> <span
				class="mx-3 icon-keyboard_arrow_right"></span> <span class="current">강의
				상세</span>
		</div>
	</div>
	<div class="container">
		<div class="pagewrap">
			<div class="list">
				<div class='wrap'>
					<div class='bookimg'>
						<img
							src='${path }/pages/main/center/lecture/temp/${lecBean.lec_imgfile}'>
					</div>
					<div class='bookinfo'>
						<span class='booktitle'> ${lecBean.lec_title}</span> <span
							class='bookdetail'>
							<div class='detail-align'>
								<p class='p1'>정&nbsp;&nbsp;&nbsp;가</p>
								<p class='p2'>${lecBean.lec_price}&nbsp;원</p>
							</div> <!-- 
							<div class='detail-align'>
								<p class='p1'>지은이</p>
								<p class='p2'></p>
							</div>
							 -->
							<div class='detail-align'>
								<p class='p1'>삭제</p>
								<p class='p2'>
									<a href='#' class="btn btn-primary rounded-0 px-4">자료실</a>
								</p>
							</div>
						</span>
						<!-- 
					 <span class='bookdetail2'><div class='detail-align'>
							<p class='p1'>분&nbsp;&nbsp;&nbsp;량</p>
							<p class='p2'>쪽</p>
						</div>
					</span> -->
					</div>
				</div>
			</div>

			<!-- 
		<div class="pagewrap">
			<div class="defaultimg">
				<hr>
			</div>
		</div>
 -->
			<div class="pagebottom">
				<div class="divide">
					<h3>강의 설명</h3>
					<hr>
					<!-- 
					<br> <span></span><br> <br>
					 -->
					<p>${lecBean.lec_content}</p>
					<h3>목차</h3>
					<hr>
					<div class="boardoutline" style="margin-bottom: 100px;">
						<div class="content">
							<table class="table-striped">
								<thead>
									<tr class="tb_head">
										<td>번호</td>
										<td>목차</td>

									</tr>
								</thead>
								<tbody>
									<c:choose>
										<c:when test="${lec_list == null}">

											<tr align="center">
												<td colspan="4"><p>
														<b><span style="font-size: 9pt;">등록된 글이 없습니다.</span></b>
													</p></td>
											</tr>
										</c:when>
										<c:when test="${lec_list != null}">
											<c:forEach var="listBean" items="${lec_list }">
												<tr align="center">
													<td width="5%">${listBean.list_no }</td>
													<td width="95%">${listBean.list_titleStr }</td>
												<tr>
											</c:forEach>
										</c:when>
									</c:choose>
									<tr class="tb_head" align="center">
										<td colspan="4">&nbsp;&nbsp;&nbsp;</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>

					<!-- <br> <span>1권 – 기본기 다지기</span><br> <br>
				<p>
					시나공 홈페이지(sinagong.gilbut.co.kr)에 15년간 쌓인 50만 회원들의 질문과 답변 데이터를 철저하게
					분석하여 1분 1초가 아까운 수험생들의 궁금증을 100% 반영하였습니다.<br> 무엇이든 물어보세요! <br>
					<br>‘수험생 지원센터 운영’ 공부하다 답답하거나 궁금한 내용이 있으면, 시나공 카페 ‘묻고 답하기’ 게시판에
					질문을 올리세요. 길벗알앤디의 전문가들이 빠짐없이 답변해드립니다. <br>이메일(qna@gilbut.co.kr)로
					질문해도 빠른 시간 내에 답변을 보내드립니다.<br> <br> ‘합격 보장’ 이메일 안내 서비스 제공
					<최신기출문제 3회분 및 해설> 최근에 출제된 기출문제<br>
					3회분에 문제마다 자세한 설명이 달려있어서 마무리 공부로 활용하기에 좋습니다. <br>
					최신기출문제로 현장 감각을 키우세요. 
				</p> -->

				</div>
			</div>
		</div>
	</div>

	<script src="${path}/js/jquery-3.3.1.min.js"></script>
</body>
</html>