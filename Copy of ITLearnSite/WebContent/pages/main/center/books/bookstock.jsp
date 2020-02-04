<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
						<th width="50px" height="112px">번호</th>
						<th width="100px" height="112px">이미지</th>
						<th width="700px" height="112px">책 제목</th>
						<th width="150px" height="112px">가격</th>
						<th width="150px" height="112px">수량</th>
						<th width="150px" height="112px">수정</th>
						<th width="150px" height="112px">삭제</th>
					</tr>
					<!-- 	책 제목 / 수량 / -->
					<c:forEach var="books" begin="0" items="${booklist}">
						<tr>
							<td>${books.product_no}</td>
							<td><img src="${books.book_image}"></td>
							<td>${books.book_title}</td>
							<td><input id="price${books.product_no}" type="text" value="${books.book_price}" style="width: 70px;"></td>
							<td><input id="stock${books.product_no}" type="text" value="${books.book_stock}" style="width: 70px;"></td>
							<td><button onclick="modify('${books.product_no}');" >수정</button></td>
							<td><button onclick="deleteQues('${books.product_no}');">삭제</button></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	<script src="${path}/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="${path}/js/makejs/bookstock.js"></script>
</body>
</html>