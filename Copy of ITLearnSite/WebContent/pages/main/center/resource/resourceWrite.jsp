<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--JSTL CORE라이브러리 태그들 사용을 위한 선언 --%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>     
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자료실</title>
<%
	request.setCharacterEncoding("UTF-8");
	String email = (String)session.getAttribute("email"); 
%>

</head>
<body>
	<%-- <!-- bootstrap -->
	<div class="pagemargin">
		<div class="wrapboard">
			<table class="table">
				<tr>
					<td>제목</td>
					<td><input type="text" value="${rBean.res_title}"></td>
				</tr>
				<tr>
					<td>등록일</td>
					<td><input type="text" value="${rBean.res_writedate}"></td>
				</tr>
				<tr>
					<td colspan="2">파일다운위치지렁</td>
				</tr>
			</table>
		</div>
		<textarea name="content" id="summernote">${rBean.res_content}</textarea>
	</div> --%>
	
	<!-- 자료실 출력 -->
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" value="${rBean.res_title}"></td>
			</tr>
			<tr>
				<td>등록일</td>
				<td><input type="text" value="${rBean.res_writedate}"></td>
			</tr>
			<tr>
				<td colspan="2">파일다운위치지렁</td>
			</tr>
			<tr>
				<td colspan="2"><textarea name="content" id="summernote" value="">${rBean.res_content}</textarea></td>
			</tr>	
		</table>
		<!-- include libraries(jQuery, bootstrap) -->

</body>
</html>