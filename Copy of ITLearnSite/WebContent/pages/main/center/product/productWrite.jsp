<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="path" value="${pageContext.request.contextPath}" />
	<h1>상품 등록 페이지</h1>
	<form action="addProduct.pd">
		<label>상품넘버(자동생성)</label>
		<br>
		<label> 상품명 : </label>
		<input type="text" name="item">
		<br>
		<label> 상품 가격 : </label>
		<input type="text" name="price">
		<br>
		<label>상품타입</label>
		<select name="type" id="type" onchange="select();" title="상품타입">
			<option value="선택">
				상품타입
			<option value="book">
				도서 
				<c:set var="type" value="book"></c:set>
			</option>
			<option value="lecture">
				강의
				<c:set var="type" value="lecture"></c:set>
			</option>
		</select>
		<div class="addtag">
			
		</div>
	</form>
	<script src="${path}/js/jquery-3.3.1.min.js"></script>
	<script src="${path}/js/makejs/product.js" type="text/javascript"></script>
</body>
</html>