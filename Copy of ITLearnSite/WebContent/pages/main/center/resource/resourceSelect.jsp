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
<c:set var="ResourceList" value="${ResourceList}" />
<c:set var="path" value="${pageContext.request.contextPath}" />

</head>
<body>
	<div class="pagemargin">
		<div class="wrapboard">
			<div class="row">
				<div class="col-lg-12" style="display: inline-block; text-align: center;">
					<div class="btn-wrap">
						<div class="header-btn float-l">
							<a href="resourceList.bo">
								<button class="btn btn-color1">
									<span>전체글</span>
								</button>
							</a>
						</div>

						<div class="header-btn float-r">
							<a href=""> <!--  -->
								<span class="glyphicon glyphicon-pencil gi-2x"></span>
							</a>
						</div>
					</div>
				</div>
			</div>
			<div class="boardoutline">
				<div class="content">
					<table class="table">
						<thead>
							<tr class="tb_head">
								<td>번호</td>
								<td>제목</td>
								<td>글쓴이</td>
								<td>작성일</td>
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
								<c:forEach var="resource" items="${resourcesList}" varStatus="resourceNum">
									<tbody>
										<tr align="center">
											<%-- varStatus의 count 속성을 이용 글번호를 1부터 자동으로 표시 --%>
											<td width="5%">${resourceNum.count}</td>
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
														<a class="cls1" href="resourceView.bo?res_no=${resource.res_no}">${resource.res_title}</a>
													</c:when>
													<%-- level값이 1보다 크지 않으면 부모글이므로 공백 없이 표시 --%>
													<c:otherwise>
														<a class="cls1" href="resourceView.bo?res_no=${resource.res_no}">${resource.res_title}</a>
													</c:otherwise>
												</c:choose>
											</td>
											<td width="10%">${resource.res_email }</td>
											<td width="10%"><fmt:formatDate value="${resource.res_writedate}" /></td>
										</tr>
									</tbody>
								</c:forEach>
							</c:when>
						</c:choose>
					</table>
				</div>
			</div>
			<div class="btn-wrap">
				<div class="header-btn float-l">
					<a href="resourceList.bo">
						<button class="btn btn-color1">
							<span>전체글</span>
						</button>
					</a>
				</div>

				<div class="header-btn float-r">
					<a href="resourceWrite.bo">
						<button class="btn btn-color1">
							<span>글쓰기</span>
						</button>
					</a>
				</div>
			</div>
	
			<div class="btn-wrap text-align">
			<form action="resourceSelect.bo" method="post" >
				<div class="selector-wrap">
					<select class="box selectbox" name="select_subject">
							<option value="title" selected="selected">제목</option>
							<option value="content">내용</option>	
					</select>			
				</div>
				<div class="search-wrap">
					<input class="box inputbox" type="text"> 
					<span class="lookimg"> 			
						<button type="submit"><img src="${path}/images/look.png" width="30px" height="35px"></button>
					</span>
				</div>
			</form>
			</div>
		</div>
	</div>
</body>
</html>