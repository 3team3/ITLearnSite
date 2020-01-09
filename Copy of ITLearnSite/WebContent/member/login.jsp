<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="ko">

<head>  

  <jsp:include page="../inc/css.jsp"/>


</head>

<body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">
<c:if test="${ loginResult == -1 || loginResult == 0 }">
		<script>
			alert("이메일 혹은 비밀번호가 틀렸습니다.");
		</script>
	</c:if>

	<c:if test="${email != null }">
		<script>
			alert("이미 로그인 중입니다.");
			location.href = "../index.jsp";
		</script>
	</c:if>


  <div class="site-wrap">

   
    <jsp:include page="../inc/top.jsp"/>

    
    <div class="site-section ftco-subscribe-1 site-blocks-cover pb-4" style="background-image: url('images/bg_1.jpg')">
        <div class="container">
          <div class="row align-items-end justify-content-center text-center">
            <div class="col-lg-7">
              <h2 class="mb-0">로그인</h2>
              <p>Sign in</p>
            </div>
          </div>
        </div>
      </div> 
    

    <div class="custom-breadcrumns border-bottom">
      <div class="container">
        <a href="index.jsp">Home</a>
        <span class="mx-3 icon-keyboard_arrow_right"></span>
        <span class="current">로그인</span>
      </div>
    </div>

    <div class="site-section">
        <div class="container">

  <form action="${path}/login1.do" method="post">
            <div class="row justify-content-center">
                <div class="col-md-5">
                    <div class="row">
                        <div class="col-md-12 form-group">
                            <label for="email">이메일</label>
                            <input type="text" id="email" name="email" class="form-control form-control-lg">
                        </div>
                        <div class="col-md-12 form-group">
                            <label for="password">비밀번호</label>
                            <input type="password" id="password" name="pw" id="pw" class="form-control form-control-lg">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <input type="submit" value="로그인" class="btn btn-primary btn-lg px-5">
                        </div>
                    </div>
                </div>
            </div>
            </form>

          
        </div>
    </div>

    

   <jsp:include page="../inc/footer.jsp"/>    

  </div>
  <!-- .site-wrap -->

  <!-- loader -->
 <jsp:include page="../inc/js.jsp"/>

</body>

</html>