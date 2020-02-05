<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<c:set var="email" value="${sessionScope.email}"></c:set>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
 @font-face { font-family: 'NIXGONM-Vb'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_six@1.2/NIXGONM-Vb.woff') format('woff'); font-weight: normal; font-style: normal; }
h2,h5{
font-family: 'NIXGONM-Vb';}

input[type=password] {
font-family: fantasy;}

#loginbtn{
 width: 445px;
}


</style>
</head>

<c:if test="${email eq null}">
	<script type="text/javascript">
		alert("로그인 후 조회가능합니다.");
		location.href="${path}/index.do";
	</script>
</c:if>

<body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">

	<c:if test="${ loginResult == 0 }">
		<script>
			alert("이메일 혹은 비밀번호가 틀렸습니다.");
		</script>
	</c:if>
	
 <div class="site-wrap">
 <div class="container">
	<div class="row align-items-end justify-content-center text-center">			
			<img src="${path }/images/mypage1.png">			
	</div>
</div>

    
    <div class="custom-breadcrumns border-bottom">
      <div class="container">
        <a href="${path}/index.do">Home</a>
        <span class="mx-3 icon-keyboard_arrow_right"></span>
        <span class="current">마이페이지</span>
	        <span class="mx-3 icon-keyboard_arrow_right"></span>
	        <span class="current">회원정보 수정</span>
      </div>
    </div>


    <div class="justify-content-center text-center section-title-underline mt-5 mb-5">
            <h2><span>비밀번호 확인</span></h2>
  	</div>

       	<div class="container justify-content-center text-center">
        	<h5><span>본인 확인을 위해 비밀번호를 다시 한번 입력해주세요</span></h5>
        	
        <form action="relogin1.do" method="post">
        <div class="row justify-content-center">
			<div class="col-md-5">
				<div class="row">
		        	<input type="hidden" name = "email" value="${requestScope.email}">
		            <div class="col-md-12 form-group">
		            	<input type="password" name="pw" required class="form-control form-control-lg"><br>
		            </div>
	            </div>
				<div class="row">
					<div class="col-12">
	           		 	<input type="submit" id="loginbtn" value="확인" class="login btn btn-primary btn-lg">
	       			</div>
	       		</div>
	       	 </div>
	      </div>
        </form>
        
    </div>
  </div>
  <%-- 
  <script src="${path}/js/jquery-3.3.1.min.js"></script>
  <script src="${path}/js/jquery-migrate-3.0.1.min.js"></script>
  <script src="${path}/js/jquery-ui.js"></script>
  <script src="${path}/js/popper.min.js"></script>
  <script src="${path}/js/bootstrap.min.js"></script>
  <script src="${path}/js/owl.carousel.min.js"></script>
  <script src="${path}/js/jquery.stellar.min.js"></script>
  <script src="${path}/js/jquery.countdown.min.js"></script>
  <script src="${path}/js/bootstrap-datepicker.min.js"></script>
  <script src="${path}/js/jquery.easing.1.3.js"></script>
  <script src="${path}/js/aos.js"></script>
  <script src="${path}/js/jquery.fancybox.min.js"></script>
  <script src="${path}/js/jquery.sticky.js"></script>
  <script src="${path}/js/jquery.mb.YTPlayer.min.js"></script>
  <script src="${path}/js/main.js"></script>
  <script src="${path}/js/makejs/commons.js"></script>
  <script src="${path}/js/makejs/DaumPostAPI.js"></script> --%>
  
</body>
</html>

