<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<link href="${path}/css/container.css" rel="stylesheet">
</head>
<body>
	<div class="header">
		<jsp:include page="/include/header.jsp"></jsp:include>
	</div>
	<div class="container">
	</div>
	<div>
		<jsp:include page="/include/footer.jsp"></jsp:include>
	</div>
	<script type="text/javascript"
		src="http://code.jquery.com/jquery-latest.js"></script>
	<script type="text/javascript" src="${path}/js/commons.js"></script>
</body>
</html>