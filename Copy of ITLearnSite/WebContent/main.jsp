<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html lang="ko">

<head>
<!-- All page css loading -->
<jsp:include page="/pages/main/css.jsp" />
<jsp:include page="/pages/main/js.jsp"></jsp:include>
</head>
<c:set var="pages" value="${paging}" />
<c:if test="${pages} == null">
	<c:set var="pages" value="/pages/main/center/default.jsp" />
</c:if>

<body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">
	<header>
		<div class="site-wrap">
			<jsp:include page="/pages/main/top/top.jsp" />
		</div>
	</header>
	<div class="center">
		<jsp:include page="${pages}" />
	</div>
	<footer>
		<div>
			<jsp:include page="/pages/main/footer/footer.jsp" />
		</div>
	</footer>
	<!-- All page javaScript loading -->
</body>
</html>