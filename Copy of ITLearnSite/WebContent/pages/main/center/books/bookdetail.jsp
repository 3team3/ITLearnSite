<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/css/bookdetail.css">

</head>
<div class="container">
	<div class="row align-items-end justify-content-center text-center">			
			<img src="${path }/images/book.png">			
	</div>
</div>

<div class="custom-breadcrumns border-bottom">
	<div class="container">
		<a href="${path}/index.do">Home</a> <span class="mx-3 icon-keyboard_arrow_right"></span> <span class="current">도서보기</span>
	</div>
</div>
<body>
	<div class="container">
		<div class="row">
			<div class="wrap">
				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
						<div class="info">
							<div class="imgwrap">
								<c:if test="${1 == 1}">
									<img class="img1" src="${detail.book_image}">
								</c:if>
							</div>
							<div class="info_left">
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">

									<div class="col-margin col-xs-12 col-sm-12 col-md-12 col-lg-12">
										<p class="label label-1">상품번호 : ${detail.product_no}</p>
									</div>

									<div class="col-margin col-xs-12 col-sm-12 col-md-12 col-lg-12">
										<p class="label label-1">책 제목 : ${detail.book_title}</p>
									</div>

									<div class="col-margin col-xs-12 col-sm-12 col-md-12 col-lg-12">
										<p class="label label-1">저 자 : ${detail.book_author}</p>
									</div>

									<div class="col-margin col-xs-12 col-sm-12 col-md-12 col-lg-12">
										<p class="label label-1">가 격 : ${detail.book_price}</p>
									</div>

									<div class="col-margin col-xs-12 col-sm-12 col-md-12 col-lg-12">
										<p class="label label-1">출판사 : ${detail.book_publisher }</p>
									</div>

									<div class="col-margin col-xs-12 col-sm-12 col-md-12 col-lg-12">
										<p class="label label-1">출판일 : ${detail.book_pubdate}</p>
									</div>

									<div class="col-margin col-xs-12 col-sm-12 col-md-12 col-lg-12">
										<p class="label label-1">ISBN : ${detail.book_isbn }</p> 
									</div>

									<div class="col-margin col-xs-12 col-sm-12 col-md-12 col-lg-12">
										<p class="label label-1">남은 수량 : ${detail.book_stock}</p> 
									</div>

								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="bookcontent">
					<h3>내용</h3>
					<hr>
					<p>${detail.book_description }</p>
				</div>

<!-- 				<div class="bookcontent"> -->
<!-- 					<h3>사진</h3> -->
<!-- 					<hr> -->
<!-- 					<img src=""> -->
<!-- 				</div> -->

			</div>

		</div>
	</div>
</body>
<script src="${path}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${path}/js/makejs/bookdetail.js"></script>

</html>