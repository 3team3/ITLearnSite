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
        
        <div class="row">
            
            <div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
                
            <form action="addProduct.pd" method="POST" role="form">
			
                <span class="label label-[ENTER NAME HERE]">상품 등록</span>
				<div class="form-group">
					<input type="text" class="form-control" id="item_name" placeholder="이름">
				</div>
                <br>
        
               <select name="type" id="type" class="form-control" required="required" onchange="select();">
                   <option value="">선택</option>
                   <option value="book">책</option>
                   <option value="lecture">강의</option>
                </select>
                
                <div class="addtag">

                </div>
                <br>
                <button type="submit" class="btn btn-primary">등록</button>
            
		    </form>
            </div>
            <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2"></div>
            <div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
                <div class="row">
                    <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
                        <span class="label">네이버 책 검색</span>
	                    <input type="text" class="form-control" id="word" name="word" placeholder="Search">
                    </div>
                    <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                    <br>
                        <span class="input-group-btn">
                          <button type="button" class="btn btn-primary" onclick="bookSearch(1);">Go!</button>
                        </span>
                    </div>
                </div>
                <div class="row">
                    <br><br>
                    <span class="label">[검색 결과 : <span class="find"></span>건]</span>
                    <table class="table">
                        <tbody>
                            <tr>
                                <th style="width: 20%">title</th>
                                <td class="title"></td>
                            </tr>
                            <tr>
                                <th>link</th>
                                <td class="link"></td>
                            </tr>
                             <tr>
                                <th>image</th>
                                <td class="image"></td>
                            </tr>
                            <tr>
                                <th>author</th>
                                <td class="author"></td>
                            </tr>
                             <tr>
                                <th>price</th>
                                <td class="price"></td>
                            </tr>
                            <tr>
                                <th>discount</th>
                                <td class="discount"></td>
                            </tr>
                            <tr>
                                <th>publisher</th>
                                <td class="publisher"></td>
                            </tr>
                            <tr>
                                <th>pubdate</th>
                                <td class="pubdate"></td>
                            </tr>
                            <tr>
                                <th>isbn</th>
                                <td class="isbn"></td>
                            </tr>
                            <tr>
                                <th>description</th>
                                <td class="description"></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="paging row justify-content-center align-self-center">
                    <a class="btn btn-primary" role="button">이전</a>
                    <button class="pagenum btn btn-default" role="button" onclick="bookSearch(1);">1</button>
                    <button class="pagenum btn btn-default" role="button" onclick="bookSearch(2);">2</button>
                    <button class="pagenum btn btn-default" role="button" onclick="bookSearch(3);">3</button>
                    <button class="pagenum btn btn-default" role="button" onclick="bookSearch(4);">4</button>
                    <button class="pagenum btn btn-default" role="button" onclick="bookSearch(5);">5</button>
                    <button class="pagenum btn btn-default" role="button" onclick="bookSearch(6);">6</button>
                    <button class="pagenum btn btn-default" role="button" onclick="bookSearch(7);">7</button>
                   	<button class="pagenum btn btn-default" role="button" onclick="bookSearch(8);">8</button>
                    <button class="pagenum btn btn-default" role="button" onclick="bookSearch(9);">9</button>
                    <button class="pagenum btn btn-default" role="button" onclick="bookSearch(10);">10</button>
                    <button class="btn btn-primary" role="button">다음</a>
                </div>
            </div>
        </div>
    </div>
	<script type="text/javascript" src="${path }/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="${path }/js/makejs/product.js"></script>
</body>
</html>