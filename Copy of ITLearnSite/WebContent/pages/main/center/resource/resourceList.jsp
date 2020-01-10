<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="resourcesList" value="${resourcesMap.resourcesList}" />
<c:set var="totResources" value="${resourcesMap.totResources}" />
<c:set var="section" value="${resourcesMap.section}" />
<c:set var="pageNum" value="${resourcesMap.pageNum}" />
<c:set var="path" value="${pageContext.request.contextPath}" />

<style type="text/css">
.no-uline {
	text-decoration: none;
}

/*선택된 페이지 번호를 빨간색으로 표시*/
.sel-page {
	text-decoration: none;
	color: red;
}

.cls1 {
	text-decoration: none;
}

.cls2 {
	text-align: center;
	font-size: 30px;
}
</style>

</head>
<body>
	<div class="pagemargin">
		<h1>ResourceList.jsp</h1>
		<a href="resourceList.bo">
			<button>
				<span>글 리스트 페이지</span>
			</button>
		</a> <a href="resourceView.bo">
			<button>
				<span>글 내용 페이지</span>
			</button>
		</a> <a href="resourceWrite.bo">
			<button>
				<span>글 쓰기 페이지</span>
			</button>
		</a> <a href="resourceModify.bo">
			<button>
				<span>글 수정 페이지</span>
			</button>
		</a>
		<!-- 	int res_no = 0; -->
		<!-- 		String res_title = null; -->
		<!-- 		String res_email = null; -->
		<!-- 		String rest_content = null; -->
		<!-- 		String res_filename = null; -->
		<!-- 		Timestamp res_writedate = new Timestamp(System.currentTimeMillis()); -->
		<div>

			<div class="boardoutline">
				<div class="content">
					<table class="table">
						<thead>
							<tr>
								<td>글번호</td>
								<td>제목</td>
								<td>작성자</td>
								<td>일자</td>
							</tr>
						</thead>
						<c:choose>
							<%--
				BoaqrdController.java 서블릿으로부터 전달 받은 request 영역에 저장되어 
				articlesList 속성으로 바인딩된 ArrayList 객체가 저장되어 있지 않다면				
			 --%>
								<c:when test="${resourcesList == null }">
									<tr height="10">
										<td colspan="4"><p>
												<b><span style="font-size: 9pt;">등록된 글이 없습니다.</span></b>
											</p></td>
									</tr>
								</c:when>

								<c:when test="${resourcesList != null }">
									<%--
					BoardController.java 서블릿으로부터 전달받은 request 영역에
					articlesList 속성으로 바인된 ArrrayList 객체의 크기(검색한 글의 개수)만큼 반복, 
					검색한 글정보(ArticleVO)들을 ArrayList 객체 내부의 인덱스 위치로부터 글목록 표시 
				 --%>
									<c:forEach var="resource" items="${resourcesList }" varStatus="resourceNum">
										<tr align="center">
											<%-- varStatus의 count 속성을 이용 글번호를 1부터 자동으로 표시 --%>
											<td width="5%">${resourceNum.count }</td>
											<td align="left" width="35%">
												<%--왼쪽으로 30px만큼 여백을 준 후 글제목을 표시할 목적으로 여백을 줌 --%> <span style="padding-right: 30px;"></span> <c:choose>
													<%-- <forEach> 태그 반복 시 각 글의 level 값이 1보다 크다면 답변글(자식글) --%>
													<c:when test="${resource.level > 1 }">
														<%-- 
									다시 내부 <forEach 태그 이용, 1부터 level 값까지 반복
									부모글 밑에 들여스기하여 답급(자식글)표시
									 --%>
														<c:forEach begin="1" end="${resource.level }" step="1">
															<span style="padding-left: 10px;"></span>
														</c:forEach>
														<%--
								 	공백 다음 자식들 표시
								  --%>
														<span style="font-size: 12px;">[답변]</span>
														<a class="cls1" href="${path }/경로.bo?res_no=${resource.res_no}">${resource.res_title }</a>
													</c:when>
													<%-- level값이 1보다 크지 않으면 부모글이므로 공백 없이 표시 --%>
													<c:otherwise>
														<a class="cls1" href="${path }/경로.bo?res_no=${resource.res_no}">${resource.res_title }</a>
													</c:otherwise>
												</c:choose>
											</td>
											<td width="10%">${resource.res_email }</td>
											<td width="10%"><fmt:formatDate value="${resource.res_writedate }" /></td>
										</tr>
									</c:forEach>
								</c:when>
						</c:choose>
					</table>
				</div>
			</div>
			<div class="cls2">
				<%--전체 글수에 따라 페이징 표시를 다르게 합니다. --%>
				<c:if test="${totResources != null }">
					<c:choose>
						<c:when test="${totResources >100 }">
							<!-- 전체 글수가 100보다 클때... -->
							<c:forEach var="page" begin="1" end="10" step="1">

								<%--섹션값 2부터는 앞 섹션으로 이동할수 있는 pre를 표시합니다. --%>
								<c:if test="${section >1 && page==1 }">
									<a class="no-uline" href="${path }/listArticles.do?section=${section-1}&pageNum=${(section-1)*10 +1 }">&nbsp; pre </a>
								</c:if>

								<a class="no-uline" href="${path }/resourceList.bo?section=${section}&pageNum=${page}">${(section-1)*10 +page } </a>

								<%--페이지번호 10 오른쪾에는 다음섹션으로 이동할수 있는 next를 표시합니다.--%>
								<c:if test="${page ==10 }">
									<a class="no-uline" href="${path }/board8/resourceList.bo?section=${section+1}&pageNum=${section*10+1}">&nbsp; next</a>
								</c:if>
							</c:forEach>
						</c:when>

						<%--전체글수가 100개일떄는 첫번째 섹션의 10개의 페이지만 표시하면 됩니다. --%>
						<c:when test="${totResources ==100 }">
							<!--등록된 글 개수가 100개인경우  -->
							<c:forEach var="page" begin="1" end="10" step="1">
								<a class="no-uline" href="#">${page } </a>
							</c:forEach>
						</c:when>


						<c:when test="${totResources< 100 }">
							<!--등록된 글 개수가 100개 미만인 경우  -->
							<%--
						글수가 100개가 되지 않으므로 표시되는 페이지는
	     				10개가 되지 않고, 전체 글수를 10으로 나누어
	     				구한 몫에 1을 더한 페이지까지 표시합니다.
	     			 --%>
							<c:forEach var="page" begin="1" end="${totResources/10 +1}" step="1">
								<c:choose>
									<%--
						페이지번호와 컨트롤러에서 넘어온 pageNum이 같은경우
	         			페이지번호를 빨간색으로 표시하여 현재 사용자가 보고 있는 페이지임을 나타냄
	         	 	--%>
									<c:when test="${page==pageNum }">
										<a class="sel-page" href="${path }/resourceList.bo?section=${section}&pageNum=${page}">${page } </a>
									</c:when>

									<%--페이지 번호를 클릭하면 section값과 pageNum값을 컨트롤러로 전송 합니다. --%>
									<c:otherwise>
										<a class="no-uline" href="${path }/resourceList.bo?section=${section}&pageNum=${page}">${page } </a>
									</c:otherwise>

								</c:choose>
							</c:forEach>

						</c:when>
					</c:choose>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>