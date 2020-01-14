<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>

<%--JSTL CORE라이브러리 태그들 사용을 위한 선언 --%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>     
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">	<meta charset="UTF-8">
<title>자료실</title>
<%
	request.setCharacterEncoding("UTF-8");
	String email = (String)session.getAttribute("email"); 
%>


</head>
	<body>
	
	   <div class="site-section ftco-subscribe-1 site-blocks-cover pb-4" style="background-image: url('../images/bg_1.jpg')">
        <div class="container">
          <div class="row align-items-end justify-content-center text-center">
            <div class="col-lg-7">
              <h2 class="mb-0">자료실</h2>
              <p>Resource room</p>
            </div>
          </div>
        </div>
      </div> 
    
    <div class="custom-breadcrumns border-bottom">
      <div class="container">
        <a href="${path}/index.do">Home</a>
        <span class="mx-3 icon-keyboard_arrow_right"></span>
        <span class="current">자료실</span>
      </div>
    </div>
	
	
	<div class="container mt-5 mb-5">
	 <h1>자료실</h1>
	<form action="resourceModify.bo" method="post">
		<table  class="table table-striped" style="text-align: center;">
			<tr>
				<td>번호</td>
				<td><input type="text" name="res_no" class="form-control" value="${rBean.res_no}" readonly></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="res_title" class="form-control" value="${rBean.res_title}" readonly></td>
			</tr>
			<tr>
				<td>글쓴이</td>
				<td><input type="text" name="res_email" class="form-control" value="${rBean.res_email}" readonly></td>
			</tr>
			<tr>
				<td>작성일</td>
				<td><input type="text" name="res_writedate" class="form-control" value="${rBean.res_writedate}" readonly></td>
			</tr>
			<tr>
				<td colspan="2"><textarea name="res_content" class="form-control" readonly rows="10" cols="120">${rBean.res_content}</textarea></td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td colspan="2"><a href="filedown.bo?res_no=${rBean.res_no}">${rBean.res_filename}</a></td>
			</tr>
			</table>
			<div class="text-right">
				<input type="button" value="목록으로" class="btn btn-color1" onclick="location.href='resourceList.bo'">
				<input type="submit"  class="btn btn-color1" value="수정">
				<input type="button"  class="btn btn-color1" value="삭제">
			</div>
	</form> 
	</div>
	
	<!-- 댓글자리 
	<div>

			<h5>아이디</h5>
			<input type="text" value="<%=email%>" readonly> <br>
			<h5>패스워드</h5>
			<input type="password"> <br>
			<h5>내용</h5>
			<input type="text" id="commentContent"><br>
			<input type="button" id="commentWrite" value="댓글 작성">
	
	</div>
	-->
	</body>
</html> 