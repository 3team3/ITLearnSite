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
	<div class="container">
        <div id="imail">
            <i class="material-icons">person_outline</i>
        </div>
        <div id="ipw">
            <i class="material-icons">lock_outline</i>
        </div>
        	<h5><span>본인확인을 위해 비밀번호를 다시한번 입력해주세요</span></h5>
        <hr/>
        <form action="${path}/relogin1.do" method="post">
        	<input type="hidden" name = "email" value="${requestScope.email}">
            <input type="password" placeholder="비밀번호" name="pw" required style="height:30px; width: 380px" /><br />
            <input type="submit" value="로그인" class="login" />
        </form>
        <hr/>
    </div>
</body>
</html>