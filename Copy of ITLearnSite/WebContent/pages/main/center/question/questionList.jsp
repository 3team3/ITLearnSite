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
<c:set var="questionsList1" value="${questionsMap1.questionsList1}" />
<c:set var="questionsList2" value="${questionsMap2.questionsList2}" />
<c:set var="totQuestions" value="${questionsMap2.totQuestions}" />
<c:set var="section" value="${questionsMap2.section}" />
<c:set var="pageNum" value="${questionsMap2.pageNum}" />
<c:set var="email" value="${email}" />
<c:set var="path" value="${pageContext.request.contextPath}" />

<script src='https://kit.fontawesome.com/a076d05399.js'></script>
</head>

   <div class="site-section ftco-subscribe-1 site-blocks-cover pb-4" style="background-image: url('../images/bg_1.jpg')">
        <div class="container">
          <div class="row align-items-end justify-content-center text-center">
            <div class="col-lg-7">
              <h2 class="mb-0">고객센터</h2>
              <p>Customer Service Center</p>
            </div>
          </div>
        </div>
      </div> 
    
    <div class="custom-breadcrumns border-bottom">
      <div class="container">
        <a href="${path}/index.do">Home</a>
        <span class="mx-3 icon-keyboard_arrow_right"></span>
        <span class="current">고객센터</span>
      </div>
    </div>
    
    
    
<body>
	<div class="pagemargin">
		<div class="wrapboard">
			<div class="row">
				<div class="col-lg-12" style="display: inline-block; text-align: center;">
					<div class="btn-wrap">

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
								<td>조회수</td>
							</tr>
						</thead>
							<c:if test="${questionsList1 != null }">
								<tbody>
								<c:forEach var="question" items="${questionsList1 }" varStatus="questionNum">
										<tr align="center">
											<%-- varStatus의 count 속성을 이용 글번호를 1부터 자동으로 표시 --%>
											<td width="5%">공지</td>
											<td align="left" width="30%">
												<a class="cls1" href="questionView.ques?ques_no=${question.ques_no}">${question.ques_title}</a>
											</td>
											<td width="7%">${question.ques_email }</td>
											<td width="7%"><fmt:formatDate value="${question.ques_writedate}" /></td>
											<td width="7%">${question.ques_readcount }</td>
										</tr>
								</c:forEach>
							</c:if>
							
							<%--
				BoaqrdController.java 서블릿으로부터 전달 받은 request 영역에 저장되어 
				articlesList 속성으로 바인딩된 ArrayList 객체가 저장되어 있지 않다면				
			 --%>
							<c:if test="${questionsList2 == null }">
								<tr align="center">
									<td colspan="5"><p>
											<b><span style="font-size: 9pt;">등록된 글이 없습니다.</span></b>
										</p></td>
								</tr>
							</c:if>
							
							
							<c:if test="${questionsList2 != null }">
								<%--
					BoardController.java 서블릿으로부터 전달받은 request 영역에
					articlesList 속성으로 바인된 ArrrayList 객체의 크기(검색한 글의 개수)만큼 반복, 
					검색한 글정보(ArticleVO)들을 ArrayList 객체 내부의 인덱스 위치로부터 글목록 표시 
				 --%>
								<c:forEach var="question" items="${questionsList2 }" varStatus="questionNum">
										<tr align="center">
											<%-- varStatus의 count 속성을 이용 글번호를 1부터 자동으로 표시 --%>
											<td width="5%">${question.ques_no }</td>
											<td align="left" width="30%">
												<%--왼쪽으로 30px만큼 여백을 준 후 글제목을 표시할 목적으로 여백을 줌 --%>
												 <!-- <span style="padding-right: 30px;"></span>  -->
												 <c:if test="${question.isSecret == 'y' }">
														<span><i class='fas fa-lock'></i></span>
												</c:if>
												 <c:choose>
													<%-- <forEach> 태그 반복 시 각 글의 level 값이 1보다 크다면 답변글(자식글) --%>
													<c:when test="${question.level > 1 }">
														<%-- 다시 내부 <forEach 태그 이용, 1부터 level 값까지 반복 부모글 밑에 들여쓰기하여 답급(자식글)표시 --%>
														<c:forEach begin="1" end="${question.level }" step="1">
															<span style="padding-left: 10px;"></span>
														</c:forEach>
														<%--공백 다음 자식들 표시  --%>
														<span style="font-size: 12px;">[답변]</span>
<%-- 														<a class="cls1" href="questionView.ques?ques_no=${question.ques_no}">${question.ques_title}</a>
 --%>													
 
 													<!--추가부분 -->
													<c:if test="${question.isSecret == 'y' }">
														<c:choose>
															<c:when test="${email == 'admin@admin.com' or email == question.ques_parentemail}">
															<a class="cls1" href="questionView.ques?ques_no=${question.ques_no}">${question.ques_title}</a>
															</c:when>
															<c:otherwise>
															<a class="cls1">비밀글입니다.</a>
															</c:otherwise>
														</c:choose>
													</c:if>
													<c:if test="${question.isSecret == 'n' }">
															<a class="cls1" href="questionView.ques?ques_no=${question.ques_no}">${question.ques_title}</a>
													</c:if>
													<!--추가부분 -->
													
													
													
													</c:when>
													<%-- level값이 1보다 크지 않으면 부모글이므로 공백 없이 표시 --%>
													<c:otherwise>
														<c:if test="${question.isSecret == 'y' }">
															<c:choose>
																<c:when test="${email == 'admin@admin.com' or email == question.ques_email}">
																<a class="cls1" href="questionView.ques?ques_no=${question.ques_no}">${question.ques_title}</a>
																</c:when>
																<c:otherwise>
																<a class="cls1">비밀글입니다.</a>
																</c:otherwise>
															</c:choose>
														</c:if>
														<c:if test="${question.isSecret == 'n' }">
															<a class="cls1" href="questionView.ques?ques_no=${question.ques_no}">${question.ques_title}</a>
														</c:if>
													</c:otherwise>
												</c:choose>
											</td>
											<td width="7%">${question.ques_email }</td>
											<td width="7%"><fmt:formatDate value="${question.ques_writedate}" /></td>
											<td width="7%">${question.ques_readcount }</td>
										</tr>
								</c:forEach>
							</c:if>
							</tbody>
					</table>
				</div>
			</div>
			<div class="btn-wrap">
				<div class="header-btn float-l">
					<a href="questionList.ques">
						<button class="btn btn-color1">
							<span>전체글</span>
						</button>
					</a>
				</div>

				<div class="header-btn float-r">
					<a href="questionWrite.ques">
						<button class="btn btn-color1">
							<span>글쓰기</span>
						</button>
					</a>
				</div>
			</div>
			<div class="btn-wrap text-align" style="margin-top:20px; margin-bottom: 20px">
				<%--전체 글수에 따라 페이징 표시를 다르게 합니다. --%>
				<c:if test="${totQuestions != null }">
					<c:choose>
						<c:when test="${totQuestions >100 }">
							<!-- 전체 글수가 100보다 클때... -->
							<c:forEach var="page" begin="1" end="10" step="1">

								<%--섹션값 2부터는 앞 섹션으로 이동할수 있는 pre를 표시합니다. --%>
								<c:if test="${section >1 && page==1 }">
									<a class="no-uline" href="${path }/questionList.ques?section=${section-1}&pageNum=${(section-1)*10 +1 }">&nbsp; pre </a>
								</c:if>

								<a class="no-uline" href="${path }/questionList.ques?section=${section}&pageNum=${page}">${(section-1)*10 +page } </a>

								<%--페이지번호 10 오른쪾에는 다음섹션으로 이동할수 있는 next를 표시합니다.--%>
								<c:if test="${page ==10 }">
									<a class="no-uline" href="${path }/questionList.ques?section=${section+1}&pageNum=${section*10+1}">&nbsp; next</a>
								</c:if>
							</c:forEach>
						</c:when>

						<%--전체글수가 100개일떄는 첫번째 섹션의 10개의 페이지만 표시하면 됩니다. --%>
						<c:when test="${totQuestions ==100 }">
							<!--등록된 글 개수가 100개인경우  -->
							<c:forEach var="page" begin="1" end="10" step="1">
								<a class="no-uline" href="#">${page } </a>
							</c:forEach>
						</c:when>


						<c:when test="${totQuestions < 100 }">
							<!--등록된 글 개수가 100개 미만인 경우  -->
							<%--
						글수가 100개가 되지 않으므로 표시되는 페이지는
	     				10개가 되지 않고, 전체 글수를 10으로 나누어
	     				구한 몫에 1을 더한 페이지까지 표시합니다.
	     			 --%>
							<c:forEach var="page" begin="1" end="${totQuestions/10 +1}" step="1">
								<c:choose>
									<%--
						페이지번호와 컨트롤러에서 넘어온 pageNum이 같은경우
	         			페이지번호를 빨간색으로 표시하여 현재 사용자가 보고 있는 페이지임을 나타냄
	         	 	--%>
									<c:when test="${page==pageNum }">
										<a class="sel-page" href="${path }/questionList.ques?section=${section}&pageNum=${page}">${page } </a>
									</c:when>

									<%--페이지 번호를 클릭하면 section값과 pageNum값을 컨트롤러로 전송 합니다. --%>
									<c:otherwise>
										<a class="no-uline" href="${path}/questionList.ques?section=${section}&pageNum=${page}">${page } </a>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</c:when>
					</c:choose>
				</c:if>
			</div>
			<div class="btn-wrap text-align">
			<form action="questionSelect.ques" method="post" >
				<div class="selector-wrap">
					<select class="box selectbox" name="select_subject">
							<option value="title" selected="selected">제목</option>
							<option value="content">내용</option>	
					</select>			
				</div>
				<div class="search-wrap">
					<input class="box inputbox" type="text" name="select_content"> 
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