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
	<div class="container">
	 <h1>자료실</h1>
	<form>
		<table  class="table table-striped" style="text-align: center;">
			<tr>
				<td>제목</td>
				<td><input type="text" class="form-control" value="${rBean.res_title}" readonly></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" class="form-control" value="${rBean.res_email}" readonly></td>
			</tr>
			<tr>
				<td>등록일</td>
				<td><input type="text" class="form-control" value="${rBean.res_writedate}" readonly></td>
			</tr>
			<tr>
				<td colspan="2"><a href="filedown.bo?res_no=${rBean.res_no}">${rBean.res_filename}</a></td>
			</tr>
			<tr>
				<td colspan="2"><textarea class="form-control" readonly>${rBean.res_content}</textarea></td>
			</tr>
			<tr>
				<td><input type="submit"  class="btn btn-color1 pull-right" value="수정"></td>
				<td><input type="button"  class="btn btn-color1 pull-right" value="삭제"></td>
			</tr>				
		</table>
		
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