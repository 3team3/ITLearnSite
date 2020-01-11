<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ResourceList.jsp</h1>
	<a href="resourceList.bo">
		<button>
			<span>글 리스트 페이지</span>
		</button>
	</a>
	<a href="resourceView.bo">
		<button>
			<span>글 내용 페이지</span>
		</button>
	</a>
	<a href="resourceWrite.bo">
		<button>
			<span>글 쓰기 페이지</span>
		</button>
	</a>
	<a href="resourceModify.bo">
		<button>
			<span>글 수정 페이지</span>
		</button>
	</a>
	<!-- 	int res_no = 0; -->
	<!-- 		String res_title = null; -->
	<!-- 		String res_email = null; -->
	<!-- 		String rest_content = null; -->
	<!-- 		String res_filename = null; -->
	<!-- 		Timestamp res_writedate = new Timestamp(System.currentTimeMillis()); -->
	<div>
		<table>
			<tr>
				<td>no</td>
				<td>title</td>
				<td>writer</td>
			</tr>
		</table>
	</div>
	
	<!-- 자료 검색 -->
	<div>
		<form action="resourceSelect.bo" method="post" >
			<select name="select_subject" >
				<option value="title" selected="selected">제목</option>
				<option value="content">내용</option>
			</select>
			
			<input type="text" name="select_content"> 
			<button type="submit">검색</button>
		</form>
	</div>
	
</body>
</html>