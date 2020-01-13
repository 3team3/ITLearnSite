<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%--JSTL CORE라이브러리 태그들 사용을 위한 선언 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="UTF-8">
<title>자료실</title>
<c:set var="email" value="${sessionScope.email}"></c:set>
<c:set var="co_no" value="${sessionScope.co_no}"></c:set>
<script>
    
</script>

</head>
<body>
	<div class="container">
		<h1>자료실</h1>
		<form>
			<table class="table table-striped" style="text-align: center;">
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
					<td><input type="submit" class="btn btn-color1 pull-right" value="수정"></td>
					<td><input type="button" class="btn btn-color1 pull-right" value="삭제"></td>
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
				<form>
					<!-- co_no ? autoincrements? 로직 생각해보기-->
					<!-- 현재 글에 comments table을 조회해서 코멘트 순서 번호를 가져와야함 select  -->
					<input type="hidden" id="res_no" name="res_no" value="${rBean.res_no}"> 
					<input type="hidden" id="co_email" name="co_email" value="${email}">
					<textarea id="content" name="content" placeholder="바르고 고운말"></textarea>
					<input type="button" id="commentWrite" name="commentWrite" value="댓글 작성" onclick="comments();">
				</form>
			</c:if>
			<br>
		</div>
	</div>
	<script src="${path}/js/makejs/resourceView.js"></script>
</body>
</html>
