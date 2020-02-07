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
<script src="${path}/js/jquery-3.3.1.min.js"></script>
<script src="${path}/js/makejs/bookList.js"></script>
</head>
<style type="text/css">
 @font-face { font-family: 'NIXGONM-Vb'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_six@1.2/NIXGONM-Vb.woff') format('woff'); font-weight: normal; font-style: normal; }
body{
font-family: 'NIXGONM-Vb';}
</style>
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
		<div class="pagewrap text-center">

			<div class="bookwrap pt-5 pb-5">
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
							<td><button class="btn btn-outline-success" onclick="modify('${books.product_no}');">수정</button></td>
							<td><button class="btn btn-outline-secondary" onclick="deleteQues('${books.product_no}');">삭제</button></td>
						</tr>
					</c:forEach>
				</table>

				<c:set var="page" value="${count}"></c:set>
				<!-- 전체 글수를 받아와서 block 단위로  -->
				<div style="text-align: center;">
					<c:forEach var="i" begin="1" end="${page}">
						<c:if test="${page!=0}">
							<a href="bookstock.text?num=${i}"><button class="btn btn-light" onclick="booklist('bookList.text', '${i}')">${i}</button></a>
						</c:if>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<script src="${path}/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="${path}/js/makejs/bookstock.js"></script>
</body>
</html>