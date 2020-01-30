<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<c:set var="lecBean" value="${lec_DetailMap.lec_Detail }" />
<c:set var="lec_list" value="${lec_DetailMap.lec_list }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>4분할</title>
<style>
html, body {
	height: 100%;
	padding: 0;
	margin: 0;
}

div {
	width: 50%;
	height: 50%;
	float: left;
}
</style>
</head>
<body>
	<div>
		<iframe name="lecture"></iframe>
	</div>
	<div>
		<table class="table-striped">
			<thead>
				<tr class="tb_head">
					<td>번호</td>
					<td>목차</td>

				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${lec_list == null}">

						<tr align="center">
							<td colspan="4"><p>
									<b><span style="font-size: 9pt;">등록된 강의가 없습니다.</span></b>
								</p></td>
						</tr>
					</c:when>
					<c:when test="${lec_list != null}">
						<c:forEach var="listBean" items="${lec_list }">
							<tr align="center">
								<td width="30%">${listBean.list_no }</td>
								<td width="70%">${listBean.list_titleStr }</td>
								<tr>
											
						</c:forEach>
										</c:when>
									</c:choose>
									<tr class="tb_head" align="center">
										<td colspan="4">&nbsp;&nbsp;&nbsp;</td>
									</tr>
								</tbody>
							</table>
   <a href="./upload/alim01.mp4" target="lecture">https://file-examples.com/wp-content/uploads/2017/04/file_example_MP4_480_1_5MG.mp4</a></d
							iv> 
 <div> 
   
 </div> 
 <div> 
    
 </div> 
</body> 
</html>