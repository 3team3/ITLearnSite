<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Starter Template for Bootstrap 4.4.1</title>
<link rel="shortcut icon" href="">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="new.css">
<style>
body {
	padding-top: 50px;
}

.starter-template {
	padding: 40px 15px;
	text-align: center;
}
</style>
</head>

<body>
	<div class="container">
		<form action="addProduct.pd" method="POST" role="form">
			
			<div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
                <legend>상품등록</legend>
				<div class="form-group">
					<input type="text" class="form-control" id="item_name" placeholder="이름">
				</div>
			</div>
			<div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
				<div class="form-group">
					<input type="number" class="form-control" id="item_price" placeholder="가격">
				</div>
			</div>
			<div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
				<div class="form-group">
					<input type="text" class="form-control" id="item_content" placeholder="내용">
				</div>
			</div>
            <br>
            <div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
               <select name="type" id="type" class="form-control" required="required" onchange="select();">
                    <option value="">선택</option>
                   <option value="book">책</option>
                   <option value="lecture">강의</option>
                </select>
            </div>

            <div class="col-xs-5 col-sm-5 col-md-5 col-lg-5 addtag">
                
            </div>
            <div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
                <br>
                 <button type="submit" class="btn btn-primary">등록</button>
            </div>
		</form>
	</div>
	<script type="text/javascript" src="${path }/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="${path }/js/makejs/product.js"></script>
</body>
</html>