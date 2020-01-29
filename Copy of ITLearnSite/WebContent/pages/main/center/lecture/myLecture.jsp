<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${path}/css/lectureDetail.css" rel="stylesheet">

<script type="text/javascript">
	function passChange() {
		var width = 450;
		var height = 490;
		var winL = (screen.width - width) / 2;
		var winT = (screen.height - height) / 2;
		var property = "width=" + width + "," + "height=" + height + ","
				+ "left=" + winL + "," + "top=" + winT + " menubar=no, scrollbars=no, status=no, location=no, toolbar=no, menubar=no";

		email_Check = false;

		window.open("passChange.jsp", "인증 페이지", property);

	}
</script>

</head>

<body>
	<div class="site-section ftco-subscribe-1 site-blocks-cover pb-4"
		style="background-image: url('../images/bg_1.jpg')">
		<div class="container">
			<div class="row align-items-end justify-content-center text-center">
				<div class="col-lg-7">
					<h2 class="mb-0">나의 강의실</h2>
					<p>Lecture Register</p>
				</div>
			</div>
		</div>
	</div>

	<div class="custom-breadcrumns border-bottom">
		<div class="container">
			<a href="${path}/index.do">Home</a> <span
				class="mx-3 icon-keyboard_arrow_right"></span> <span class="current">나의
				강의실</span>
		</div>
	</div>


	<div class="container">
		<div class="pagewrap">
			<div class="pagebottom">
				<div class="divide">
					<h3>나의 강의실</h3>
					<hr>

					<div class="boardoutline" style="margin-bottom: 100px;">
						<div class="content">
							<table class="table-striped">
								<thead>
									<tr class="tb_head">
										<td>번호</td>
										<td>강의명</td>
										<td>만료일</td>
										<td>삭제</td>

									</tr>
								</thead>
								<tbody>
									<c:choose>
										<c:when test="${myList == null}">

											<tr align="center">
												<td colspan="4"><p>
														<b><span style="font-size: 9pt;">결제하신 강의가 없습니다.</span></b>
													</p></td>
											</tr>
										</c:when>
										<c:when test="${myList != null}">
											<c:forEach var="bean" items="${myList }" varStatus="num">
												<tr align="center">
													<td width="10%">${num.count }</td>
													<td width="40%"><a href="javascript:void(0);"
													onclick="deleteNo(${lecture.lec_no}, '${lecture.lec_title }');">${bean.set_lec_title }</a></td>
													<td width="20%">${bean.between }일남았습니다.</td>
													<td></td>
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

				</div>
			</div>
		</div>
	</div>

	<script src="${path}/js/jquery-3.3.1.min.js"></script>
</body>
</html>