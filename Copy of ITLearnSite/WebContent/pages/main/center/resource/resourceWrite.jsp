<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--JSTL CORE라이브러리 태그들 사용을 위한 선언 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<title>자료실</title>
</head>
<c:set var="email" value="${sessionScope.email}"></c:set>
<c:if test="${email eq null}">
	<script type="text/javascript">
		alert("로그인 후 글쓰기가 가능합니다.");
		location.href="resourceList.bo";
	</script>
</c:if>
<body>
	<div class="pagemargin">
		<div class="wrapboard">
			<form action ="resource">
				<table class="table">
					<thead>
						<tr>
							<td>제목</td>
							<td><input class="form-control" type="text" id="title" name="title"></td>
						</tr>
						<tr>
							<td colspan="2">파일다운위치지정</td>
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
				<textarea name="content" id="summernote"></textarea>
				<div class="float-r">
					<input class="btn btn-color2" type="button" value="취소" onclick="canclebtn();"> <input class="btn btn-color1" type="submit" value="글쓰기">
				</div>
			</form>
		</div>
	</div>
	<script src="${path}/js/makejs/resourceWrite.js"></script>
</body>
</html>