<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${path}/css/header.css" rel="stylesheet">
</head>
<body>
	<div class="header">
		<!-- 헤더 전체영역 -->
		<div class="header_top">
            <div class="inner">
			<!-- 헤더의 상단 -->
                <div class="sitelink">
                    <ul>
                        <li><a href="#">길벗 이지톡</a></li>
                    </ul>
                    <ul>
                        <li><a href="#">길벗 스쿨</a></li>
                    </ul>
                    <ul>
                        <li><a href="#">시나공 IT</a></li>
                    </ul>
                    <ul>
                        <li><a href="#">시나공 TOEIC</a></li>
                    </ul>
                     <ul>
                        <li><a href="${path}/memberlist.do">회원정보</a></li>
                    </ul>
                </div>

                <div class="sitejoin">
                    <!-- 회원가입 버튼/ 로그인 버튼 -->
                    <c:if test="${email == null }">
                    <ul>
                        <li><a href="${path}/login.do"> 로그인 </a></li>
                    </ul>
                    </c:if>
                    <c:if test="${email != null }">
                    <ul>
                    	<li>${email} 로그인 중</li>
					</ul>	
					<ul>
						<li><a href="logout.do"><button>로그아웃</button></a></li>
					</ul>				
					</c:if>

                    <ul>
                    	<li> | </li>
                    </ul>
						
                    <ul>
                        <li><a href="${path}/joinMember.do"> 회원가입 </a></li>
                    </ul>
                </div>
            </div>
        </div>
		<div class="header_bottom">
			<!-- 헤더의 navbar -->
			<div class="inner">
				<div class="logo">
					<h1>
						<a href="#"> 시나공 IT </a>
					</h1>
				</div>
				<div class="navbar">
					<ul>
						<li>
							<a href="#">시험정보/후기</a>
							<ul class="submenu">
								<li>
									<a href="#">시험 정보</a>
								</li>
								<li>
									<a href="#">합격전략/후기</a>
								</li>
							</ul>
						</li>
					</ul>
					<ul>
						<li>
							<a href="#">자료실</a>
							<ul class="submenu">
								<li>
									<a href="#">실습예제</a>
								</li>
								<li>
									<a href="#">학습자료</a>
								</li>
								<li>
									<a href="#">기출문제</a>
								</li>
								<li>
									<a href="#">정답지</a>
								</li>
								<li>
									<a href="#">정오표</a>
								</li>
							</ul>
						</li>
					</ul>
					<ul>
						<li>
							<a href="#">프리미엄 존</a>
							<ul class="submenu">
								<li>
									<a href="#">시험대비자료</a>
								</li>
								<li>
									<a href="#">토막강의</a>
								</li>
								<li>
									<a href="#">실기특강</a>
								</li>
							</ul>
						</li>
					</ul>
					<ul>
						<li>
							<a href="#">묻고 답하기</a>
						</li>
					</ul>
					<ul>
						<li>
							<a href="#">도서보기</a>
						</li>
					</ul>
					<ul>
						<li>
							<a href="#">동영상 강좌</a>
						</li>
					</ul>
					<ul>
						<li>
							<a href="#">고객센터</a>
							<ul class="submenu">
								<li>
									<a href="#">공지사항</a>
								</li>
								<li>
									<a href="#">시험공지</a>
								</li>
								<li>
									<a href="#">이벤트</a>
								</li>
								<li>
									<a href="#">오류제보</a>
								</li>
								<li>
									<a href="#">FAQ</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
				<div class="realtime">
					<h5>실시간 검색 순위</h5>
				</div>
				<div class="searchImg">
					<img src="" />
				</div>
			</div>


		</div>
	</div>
</body>
</html>