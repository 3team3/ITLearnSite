<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="pagemargin">
		<div class="boardoutline">
			<div class="content">
				<h1>NoticeList.jsp</h1>
				<h1>공지게시판</h1>
				<br>
				<div>pagemargin으로 묶어주면 상단에 100px만큼 밀려서 안겹침</div>
				<div>
				<c:set>
					<table class="table">
						<thead>
							<tr>
								<td>번호</td>
								<td>제목</td>
								<td>글쓴이</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>제목 쓰는 라인</td>
								<td>글쓴놈</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>