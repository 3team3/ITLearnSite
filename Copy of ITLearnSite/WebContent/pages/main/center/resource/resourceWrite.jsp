<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
	String email = (String)session.getAttribute("email"); 
%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  /> 

<head>
<meta charset="UTF-8">
<title>자료실 글쓰기</title>


<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
 
</head>

<body>

	<div class="container">
	<h1>자료실 글쓰기</h1>
  	<form name="resForm" method="post" action="addResource.bo" enctype="multipart/form-data">
    <table class="table table-striped" style="text-align: center;">
				<tr>
					<td>작성자</td>  
					<td colspan="3"><input type="text" name="res_email" class="form-control" readonly="readonly" value="${email}"></td>
				</tr>
				<tr>
					<td>글제목</td>
					<td colspan="3"><input type="text" name="res_title" class="form-control" placeholder="제목을 입력하세요."></td>
				</tr>
				<tr>
					<td>글내용</td>
					<td colspan="3"><textarea name="res_content" class="form-control" placeholder="내용을 입력하세요." rows="10" cols="120"></textarea></td>
				</tr>
				<tr>
			        <td align="right">파일 첨부:  </td>
				    <td> <input type="file" name="res_filename"/></td>
				</tr>
			</table>
				<input type="button" value="목록으로" class="btn btn-color1 pull-right" onclick="location.href='resourceList.bo'">
				<input type="submit" value="글쓰기" class="btn btn-color1 pull-right">
  </form>
  </div>
</body>
</html>