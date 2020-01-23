<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<c:set var="bookdetail" value="${requestScope.bookdetail}"></c:set>
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
	<div>
	
	</div>
	<script src="${path}/js/jquery-3.3.1.min.js"></script>
	<script src="${path}/js/makejs/bookList.js"></script>
</body>
</html>