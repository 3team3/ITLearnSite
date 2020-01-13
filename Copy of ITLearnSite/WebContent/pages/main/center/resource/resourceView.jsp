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
<c:set var="email" value="${sessionScope.email}"></c:set>
<c:set var="co_no" value="${sessionScope.co_no}"></c:set>
<script>
    
</script>

</head>
	<body>
	 <h1>자료실</h1>
	<form>
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" value="${rBean.res_title}"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" value="${rBean.res_email}"></td>
			</tr>
			<tr>
				<td>등록일</td>
				<td><input type="text" value="${rBean.res_writedate}"></td>
			</tr>
			<tr>
				<td colspan="2">파일다운위치지렁</td>
			</tr>
			<tr>
				<td colspan="2"><textarea readonly="readonly">${rBean.res_content}</textarea></td>
			</tr>
			<tr>
				<td><input type="submit" value="수정"></td>
				<td><input type="button" value="삭제"></td>
			</tr>				
		</table>
		
	</form> 
	<hr>
	<!-- 댓글자리 -->
	<div>
			<h5>전체 리플 0개</h5>
			<hr>
			<c:if test="${email == null}">
				<textarea id="commentContent" placeholder="로그인 후 댓글 작성이 가능합니다" readonly="readonly"></textarea>
				<br>
				<input type="button" id="commentWrite" value="댓글 작성" disabled="disabled">
			</c:if>
			<c:if test="${email != null }">
				<form onsubmit="comments();" action="commentsWrite.co">
					<!-- co_no ? autoincrements? 로직 생각해보기-->
					<!-- 현재 글에 comments table을 조회해서 코멘트 순서 번호를 가져와야함 select  -->
					<input type="hidden" id="co_no" value="">
					<input type="hidden" id="res_no" value="${requestScope.res_no}">
					<input type="hidden" id="co_email" value="${email}">
					<textarea id="commentContent" placeholder="바르고 고운말"></textarea>
					<input type="submit" id="commentWrite" value="댓글 작성">
				</form>
			</c:if>
			<br>
	</div>
	<script src="${path}/js/makejs/resourceView.js"></script>
	</body>
</html> 