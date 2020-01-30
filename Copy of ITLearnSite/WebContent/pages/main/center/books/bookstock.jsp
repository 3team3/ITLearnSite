<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/css/bookstock.css">
</head>
<body>
	<c:set var='booklist' value='${list}'></c:set>
	<div class="container">
		<div class="pagewrap">
			<div class="pagetitle">
				<h1>재고 관리 페이지</h1>
				<hr>
			</div>

			<div class="bookwrap">
				<table class="tborder table-condensed table-bordered">
					<tr>
						<th width="100px" height="112px">이미지</th>
						<th width="750px" height="112px">책 제목</th>
						<th width="100px" height="112px">가격</th>
						<th width="100px" height="112px">수량</th>
					</tr>
					<!-- 	책 제목 / 수량 / -->
					<c:forEach var="books" begin="0" items="${booklist}">

						<tr>
							<td><img src="${books.book_image}"></td>
							<td>${books.book_title}</td>
							<td><input type="text" value="${books.book_price}"
								style="width: 70px;"></td>
							<td><input type="text" value="${books.book_stock}"
								style="width: 70px;"></td>
						</tr>

					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>