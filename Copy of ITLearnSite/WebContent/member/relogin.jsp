<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../inc/css.jsp"/>
</head>

<body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">

	<c:if test="${ loginResult == 0 }">
		<script>
			alert("이메일 혹은 비밀번호가 틀렸습니다.");
		</script>
	</c:if>
	
 <div class="site-wrap">
 <jsp:include page="../inc/top.jsp"/>
	
   <div class="site-section ftco-subscribe-1 site-blocks-cover pb-4" style="background-image: url('../images/bg_1.jpg')">
        <div class="container">
          <div class="row align-items-end justify-content-center text-center">
            <div class="col-lg-7">
              <h2 class="mb-0">로그인</h2>
              <p>Login</p>
            </div>
          </div>
        </div>
      </div> 
    
    <div class="custom-breadcrumns border-bottom">
      <div class="container">
        <a href="${path}/index.do">Home</a>
        <span class="mx-3 icon-keyboard_arrow_right"></span>
        <span class="current">마이페이지</span>
      </div>
    </div>


    <div class="justify-content-center text-center section-title-underline mt-5">
            <h2><span>비밀번호 확인</span></h2>
  	</div>

    <div class="site-section">
       	<div class="container">
        	<h5><span>본인 확인을 위해 비밀번호를 다시 한번 입력해주세요</span></h5>
        <hr/>
        <form action="relogin1.do" method="post">
        <div class="col-md-12 form-group">
        	<input type="hidden" name = "email" value="${requestScope.email}">
            <input type="password" placeholder="비밀번호" name="pw" required class="form-control form-control-lg"><br>
            <input type="submit" value="확인" class="login btn btn-primary btn-lg">
        </div>
        </form>
        <hr/>
    </div>
    </div>
     <jsp:include page="../inc/footer.jsp"/>
  </div>
  
  <jsp:include page="../inc/js.jsp"/>
</body>
</html>

