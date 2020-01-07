<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>LogIn</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <style>
.container {
	width: 385px;
	line-height: 50px;
	margin: 40px auto;
}
h5 {
	text-align: center;
}
h5 span {
	color: teal;
}
.login {
	background-color: rgb(255, 80, 90);
	color: white;
	border-radius: 5px;
	border: 0;
	padding: 10px 172px;
}
#signup {
	background-color: white;
	color: teal;
	border: 0;
	font-size: 17px;
}
p {
	text-align: center;
}
i {
	color: lightgray;
}
#imail {
	position: absolute;
	top: 130px;
	margin: 0 355px;
}
#ipw {
	position: absolute;
	top: 180px;
	margin: 0 355px;
}
input {
	border: 1px solid lightgray;
	border-radius: 3px;
}
</style>
</head>

<body>
	<body>
	<c:if test="${ loginResult == 0 }">
		<script>
			alert("이메일 혹은 비밀번호가 틀렸습니다.");
		</script>
	</c:if>
	<c:if test="${loginResult == -1 }">
		<script>
			alert("이메일 인증을 해주세요");
		</script>
	</c:if>
	<c:if test="${email != null }">
		<script>
			alert("이미 로그인 중입니다.");
			location.href = "../index.jsp";
		</script>
	</c:if>
	<div class="container">
        <div id="imail">
            <i class="material-icons">person_outline</i>
        </div>
        <div id="ipw">
            <i class="material-icons">lock_outline</i>
        </div>
        	<h5><span>로그인</span> 페이지입니다.</h5>
        <hr />
        <form action="${path}/login1.do" method="post">
            <input type="text" placeholder="이메일" name="email" required style="height:30px; width: 380px" /><br />
            <input type="password" placeholder="비밀번호" name="pw" required style="height:30px; width: 380px" /><br />
            <input type="submit" value="로그인" class="login" />
            <button onclick="location.href='${path}/index.do';" class="login" >HOME</button>
        </form>
        <hr />
        <p><a href="${path}/joinMember.do"><input type="button" value="회원가입" id="signup" /></a></p>
    </div>
</body>
</html>