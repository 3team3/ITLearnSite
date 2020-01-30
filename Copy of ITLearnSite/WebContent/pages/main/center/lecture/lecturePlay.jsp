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
	width: 49.7%;
	height: 49.7%;
	float: left;
	border: 1px solid red;
}
</style>
<%--${path }/pages/main/center/lecture/temp/${listBean.list_savefile} --%>
<script src="${path}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">

	function play(list_no, lec_no, list_savefile) {
		
		document.getElementById("lecture").setAttribute("src", "${path }/pages/main/center/lecture/temp/" + list_savefile);
		
		var d4 = document.getElementById("d4");
		d4.innerHTML = "";
		d4.innerHTML += list_no + "<br>";
		d4.innerHTML += lec_no + "<br>";
		
	}

</script>
</head>
<body>
	<div id="d1">
		<iframe frameborder="0" id="lecture" name="lecture"
			src="${path }/pages/main/center/lecture/temp/${lecBean.lec_spofile }"
			style="width: 100%; height: 100%; background-color: black;"></iframe>
	</div>
	<div id="d2">
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
								<%--${path }/pages/main/center/lecture/temp/${listBean.list_savefile} --%>
								<td width="70%"><a href="javascript:void(0);"
									onclick="play(${listBean.list_no }, ${listBean.lec_no }, '${listBean.list_savefile }');">${listBean.list_titleStr }</a></td>
							<tr>
						</c:forEach>
					</c:when>
				</c:choose>
				<tr class="tb_head" align="center">
					<td colspan="4">&nbsp;&nbsp;&nbsp;</td>
				</tr>
			</tbody>
		</table>

	</div>
	<div id="d3">
		강의명 : ${lecBean.lec_title }</br> 강의 내용 : ${lecBean.lec_content }
	</div>
	<div id="d4"></div>
</body>
</html>