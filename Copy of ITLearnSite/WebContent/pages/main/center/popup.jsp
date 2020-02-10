<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<SCRIPT language="JavaScript"> 

function setCookie( name, value, expiredays ) 
{ 
var todayDate = new Date(); 
todayDate.setDate( todayDate.getDate() + expiredays ); 
document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + todayDate.toGMTString() + ";" 
} 

function closeWin() 
{ 
if ( document.pop.Notice.checked ) 
setCookie( "Notice", "done" , 1);//1은 하루동안 새창을 열지 않게 합니다. 
window.close(); 
} 

</SCRIPT>


<style>

@font-face { font-family: 'NIXGONM-Vb'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_six@1.2/NIXGONM-Vb.woff') format('woff'); font-weight: normal; font-style: normal; }
body{font-family: 'NIXGONM-Vb';}

</style>
<body>
<c:set var="path" value="${pageContext.request.contextPath}"/>


<form name=pop> 
<p align="center"> 
	<img src="${path}/images/sale.png">
	<input type=checkbox name="Notice" value="">하루동안 열지않기<a href="javascript:history.onclick=closeWin()">[닫기]</a>   
</form>     
</body>
</html>