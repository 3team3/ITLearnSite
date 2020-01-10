<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>

<div class="site-mobile-menu site-navbar-target">
	<div class="site-mobile-menu-header">
		<div class="site-mobile-menu-close mt-3">
			<span class="icon-close2 js-menu-toggle"></span>
		</div>
	</div>
	<div class="site-mobile-menu-body"></div>
</div>

<div class="py-2 bg-light">
	<div class="container">
		<div class="row align-items-center"></div>
	</div>
</div>
<header class="site-navbar py-4 js-sticky-header site-navbar-target" role="banner">

	<div class="container" style="height: 120px;">
		<div class="d-flex align-items-center">
			
			<div class="site-logo col-lg-2 text-left">
				<a href="index.do" class="d-block"> <img src="${path}/images/logo.jpg" alt="Image" class="img-fluid">
				</a>
			</div>
		
			<div class="mr-auto col-xs-8 col-sm-8 col-md-8 col-lg-8">
				<nav class="site-navigation position-relative text-right" role="navigation">
					<ul class="site-menu main-menu js-clone-nav mr-auto d-none d-lg-block">
						<li><a href="lectures.do" class="nav-link text-left">강의</a></li>
						<li><a href="books.do" class="nav-link text-left">도서</a></li>
						<li><a href="resourceList.bo" class="nav-link text-left">자료실</a></li>

						<li class="has-children"><a href="customer.do" class="nav-link text-left">고객센터</a>
							<ul class="dropdown">
								<li><a href="noticelist.bo">공지사항</a></li>
								<li><a href="questionlist.bo">이용문의</a></li>
							</ul></li>

						<li class="has-children"><a href="mypage.do" class="nav-link text-left">마이페이지</a>
							<ul class="dropdown">
								<li><a href="relogin.do">회원정보 수정</a></li>
								<li><a href="mylecture.do">내 강의실</a></li>
								<li><a href="myorder.do">주문 확인</a></li>
								<li><a href="myorderchange.do">주문 수정</a></li>
							</ul></li>

						<li class="has-children"><a href="admin.do" class="nav-link text-left">관리자</a>
							<ul class="dropdown">
								<li><a href="memberlist.do">회원 관리</a></li>
								<li><a href="#">주문 관리</a></li>
							</ul></li>
					</ul>
				</nav>
			</div>

			<div class="col-lg-2 text-right">
				<c:if test="${email == null }">
					<a href="login.do" class="small mr-3"><span class="icon-unlock-alt"></span> 로그인</a>
					<a href="joinMember.do" class="small btn btn-primary px-4 py-2 rounded-0"><span class="icon-users"></span> 회원가입</a>
				</c:if>

				<c:if test="${email != null }">
					<ul>
						<small>${email} 로그인 중</small>
						<a href="logout.do" class="small mr-3"><span class="icon-unlock-alt"></span> 로그아웃</a>
						<!-- 장바구니 -->
						<a href="#"><img src="${path}/images/cart.png" height="40px" width="40px"></a>
					</ul>
					<%-- <a href="${path}/member/register.jsp" class="small btn btn-primary px-4 py-2 rounded-0"><span class="icon-users"></span> 회원가입</a> --%>
				</c:if>
			</div>
		</div>
	</div>
</header>
