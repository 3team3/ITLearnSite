<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<c:set var="count" value="${count}"></c:set>
<!-- 전체 글 수 -->
<c:set var="pagePerData" value="5"></c:set>
<!-- 한페이지에 보여줄 데이타 수 -->
<c:set var="block" value="2"></c:set>
<!-- 한페이지 당 보여줄 페이지 수 -->
<c:set var="beginPageNum" value="0"></c:set>
<!-- 시작 글 번호 -->

<c:set var="nowBlock" value="${nowBlock}"></c:set>
<!-- 현재 보여질 블럭 -->
<c:set var="totalPage" value="0"></c:set>
<!-- 총 페이지 수 -->
<c:set var="totalBlock" value="0">
</c:set>
<!-- 총 블럭 수 -->
<c:set var="nowPage" value="${nowPage}"></c:set>
<!-- 현재페이지 -->
<c:set var="num" value="${param.num}"></c:set>

<!-- 총 페이지 갯수 결정 -->
<c:choose>
	<c:when test="${count % pagePerData == 0}">
		<fmt:parseNumber var="totalPage" integerOnly="true" value="${count / pagePerData}"></fmt:parseNumber>
	</c:when>
	<c:otherwise>
		<fmt:parseNumber var="totalPage" integerOnly="true" value="${(count / pagePerData) + 1 }"></fmt:parseNumber>
	</c:otherwise>
</c:choose>

<!-- 총 블럭 수 결정 -->
<c:choose>
	<c:when test="${totalPage%block == 0}">
		<fmt:parseNumber var="totalBlock" integerOnly="true" value="${totalPage / block }"></fmt:parseNumber>
	</c:when>
	<c:otherwise>
		<fmt:parseNumber var="totalBlock" integerOnly="true" value="${(totalPage / block) + 1 }"></fmt:parseNumber>
	</c:otherwise>
</c:choose>

<!-- 현재 페이지가 null이 아닐 때 -->
<c:if test="${not empty nowPage }">
	<fmt:parseNumber var="nowPage" integerOnly="true" value="${nowPage}"></fmt:parseNumber>
</c:if>
<!-- 현재 블럭이 null이 아닐 때 -->
<c:if test="${not empty nowBlock }">
	<fmt:parseNumber var="nowBlock" integerOnly="true" value="${nowBlock}"></fmt:parseNumber>
</c:if>
<c:if test="${empty nowBlock }">
	<fmt:parseNumber var="nowBlock" integerOnly="true" value="0"></fmt:parseNumber>
</c:if>
<c:set var="beginPageNum" value="${nowPage * pagePerData}"></c:set>

<c:set var="pageNum" value="${param.pageNum}"></c:set>

<c:if test="${empty pageNum }">
	<c:set var="pageNum" value="1"></c:set>
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/css/bookstock.css">
<script src="${path}/js/jquery-3.3.1.min.js"></script>
<script src="${path}/js/makejs/bookList.js"></script>
</head>
<style type="text/css">
@font-face {
	font-family: 'NIXGONM-Vb';
	src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_six@1.2/NIXGONM-Vb.woff') format('woff');
	font-weight: normal;
	font-style: normal;
}

body {
	font-family: 'NIXGONM-Vb';
}
</style>
<body>

	<div class="container">
		<div class="row align-items-end justify-content-center text-center">
			<img src="${path}/images/admin4.png">
		</div>
	</div>

	<div class="custom-breadcrumns border-bottom">
		<div class="container">
			<a href="index.jsp">Home</a> <span class="mx-3 icon-keyboard_arrow_right"></span> <span class="current">관리자</span> <span
				class="mx-3 icon-keyboard_arrow_right"></span> <span class="current">도서 재고 관리</span>
		</div>
	</div>



	<c:set var='booklist' value='${list}'></c:set>

	<c:set var="loop_flag" value="false"></c:set>
	<c:set var="loop_flag2" value="false"></c:set>

	<div class="container">
		<div class="pagewrap text-center">

			<div class="bookwrap pt-5 pb-5">
				<table class="tborder table-condensed table-bordered">
					<tr>
						<th width="50px" height="112px">번호</th>
						<th width="100px" height="112px">이미지</th>
						<th width="700px" height="112px">책 제목</th>
						<th width="150px" height="112px">가격</th>
						<th width="150px" height="112px">수량</th>
						<th width="150px" height="112px">수정</th>
						<th width="150px" height="112px">삭제</th>
					</tr>
					<!-- 	책 제목 / 수량 / -->
					<c:choose>
						<c:when test="${not empty list}">
							<c:forEach var="books" items="${booklist}" begin="${beginPageNum}" end="${(beginPageNum + pagePerData) - 1}" step="1" varStatus="status">
								<c:if test="${beginPageNum == count}">
									<c:set var="loop_flag" value="true"></c:set>
									<c:set var="loop_flag2" value="true"></c:set>
								</c:if>
								<c:if test="${not loop_flag}">
									<tr>
										<td>${books.product_no}</td>
										<td><img src="${books.book_image}"></td>
										<td>${books.book_title}</td>
										<td><input id="price${books.product_no}" type="text" value="${books.book_price}" style="width: 70px;"></td>
										<td><input id="stock${books.product_no}" type="text" value="${books.book_stock}" style="width: 70px;"></td>
										<td><button class="btn btn-outline-success" onclick="modify('${books.product_no}');">수정</button></td>
										<td><button class="btn btn-outline-secondary" onclick="deleteQues('${books.product_no}');">삭제</button></td>
									</tr>
								</c:if>
							</c:forEach>
							<div style="text-align: center;">
								<c:if test="${count > 0 && nowBlock > 0 } ">
									<a href="${path}/bookstock.text?nowBlock=${nowBlock-1}&num=${(nowBlock-1) * block}">◀</a>
								</c:if>

								<c:forEach var = "i" begin="0" end="${block-1}" step="1" varStatus="status">
									<c:if test="${not loop_flag2}">
										<c:if test="${(nowBlock * block) + status.index == totalPage}">
											<c:set var="loop_flag2" value="true"></c:set>
										</c:if>

										<c:if test="${not loop_flag2}">
											<a href="${path}/bookstock.text?nowBlock=${nowBlock}&num=${i+1}"> ${nowBlock * block  + 1+ status.index}
											</a>
											
											<c:if test="${(nowBlock * block) + 1 + status.index == count}">
												<c:set var="loop_flag2" value="true"></c:set>
											</c:if>
										</c:if>
									</c:if>
								</c:forEach>

								<c:if test="${totalBlock > nowBlock+1}">
									<a href="${path}/bookstock.text?nowBlock=${nowBlock}&num=${(nowBlock+1) * block}">▶</a>
								</c:if>
							</div>

						</c:when>
						<c:otherwise>
							<tr>
								<td>데이터가 없습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</table>

				<%-- <c:set var="count" value="${count}"></c:set> <!-- 전체 글 수 --> --%>
				<%-- <c:set var="pagePerData" value="5"></c:set><!-- 한페이지에 보여줄 데이타 수 --> --%>
				<%-- <c:set var="block" value="2"></c:set> <!-- 한페이지 당 보여줄 페이지 수 --> --%>
				<%-- <c:set var="beginPageNum" value="0"></c:set> <!-- 시작 글 번호 --> --%>

				<%-- <c:set var="nowBlock" value="${blockNum}"></c:set> <!-- 현재 보여질 블럭 --> --%>
				<%-- <c:set var="totalPage" value="0"></c:set> <!-- 총 페이지 수 --> --%>
				<%-- <c:set var="totalBlock" value="0"> </c:set> <!-- 총 블럭 수 --> --%>
				<%-- <c:set var="nowPage" value="${nowPage}"></c:set> <!-- 현재페이지 --> --%>


				<!-- 전체 글수를 받아와서 block 단위로  -->

			</div>
		</div>
	</div>
	<script src="${path}/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="${path}/js/makejs/bookstock.js"></script>
</body>
</html>