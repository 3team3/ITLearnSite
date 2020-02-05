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
<div class="container">
	<div class="row align-items-end justify-content-center text-center">			
			<img src="${path }/images/admin4.png">			
	</div>
</div>

	 <div class="custom-breadcrumns border-bottom">
      <div class="container">
        <a href="index.jsp">Home</a>
        <span class="mx-3 icon-keyboard_arrow_right"></span>
        <span class="current">관리자</span>
        <span class="mx-3 icon-keyboard_arrow_right"></span>
        <span class="current">도서 재고 관리</span>
      </div>
    </div>
    
    
	<c:set var='booklist' value='${list}'></c:set>
	<div class="container">
		<div class="pagewrap">
			<div class="pagetitle">
				<h1>재고 관리 페이지</h1>
				<hr>
			</div>

			<div class="bookwrap pt-5 pb-5">
				<table class="tborder table-condensed table-bordered">
					<tr>
						<th width="100px" height="112px">이미지</th>				<th width="700px" height="112px">책 제목</th>
						<th width="150px" height="112px">가격</th>
						<th width="150px" height="112px">수량</th>
					</tr>
					<!-- 	책 제목 / 수량 / -->
					<c:forEach var="books" begin="0" items="${booklist}">

						<tr>
							<td><img src="${books.book_image}"></td>
							<td>${books.book_title}</td>
							<td><input type="text" value="${books.book_price}"
								style="width: 70px;">
								<button onclick="modify();">수정</button></td>
							<td><input type="text" value="${books.book_stock}"
								style="width: 70px;">
							<button onclick="modify();">수정</button></td>
						</tr>

					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	<script  type="text/javascript"></script>
</body>
</html>