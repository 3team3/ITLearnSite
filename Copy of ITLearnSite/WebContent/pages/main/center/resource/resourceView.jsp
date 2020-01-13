<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>

<%--JSTL CORE라이브러리 태그들 사용을 위한 선언 --%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>     
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">	<meta charset="UTF-8">
<title>자료실</title>
<%
	request.setCharacterEncoding("UTF-8");
	String email = (String)session.getAttribute("email"); 
%>

<script>
    // Perform an asynchronous HTTP (Ajax) request.
    // 비동기 통신 Ajax를 Setting한다.
    $.ajaxSetup({
        type:"POST",
        async:true,
        dataType:"json",
        error:function(xhr) {
            console.log("댓글에서 오류 = " + xhr.statusText);
        }
    });
    
    $(function() {
        $("#commentWrite").on("click", function() {
            $.ajax({
                url:"/bbs/commentWrite.bbs",
                data:{
                    commentContent:$("#commentContent").val(),
                    articleNumber:"${article.articleNumber}"
                },
                beforeSend:function() {
                    console.log("시작 전...");
                },
                complete:function() {
                    console.log("완료 후...");
                },
                success:function(data) {            // 서버에 대한 정상응답이 오면 실행, callback
                    if(data.result == 1) {            // 쿼리 정상 완료, executeUpdate 결과
                        console.log("comment가 정상적으로 입력되었습니다.");
                        $("#commentContent").val("");
                        showHtml(data.comments, 1);
                    }
                }
            })
        });
    });
 
    function showHtml(data, commPageNum) {
        let html = "<table class='table table-striped table-bordered' style='margin-top: 10px;'><tbody>";
        $.each(data, function(index, item) {
            html += "<tr align='center'>";
            html += "<td>" + (index+1) + "</td>";
            html += "<td>" + item.id + "</td>";
            html += "<td align='left'>" + item.commentContent + "</td>";
            let presentDay = item.commentDate.substring(0, 10);
            html += "<td>" + presentDay + "</td>";
            html += "</tr>";
        });
        html += "</tbody></table>";
        commPageNum = parseInt(commPageNum);        // 정수로 변경
        // commentCount는 동기화되어 값을 받아오기 때문에, 댓글 insert에 즉각적으로 처리되지 못한다.
        if("${article.commentCount}" > commPageNum * 10) {
            nextPageNum = commPageNum + 1;
            html +="<input type='button' class='btn btn-default' onclick='getComment(nextPageNum, event)' value='다음 comment 보기'>";
        }
        
        $("#showComment").html(html);
        $("#commentContent").val("");
        $("#commentContent").focus();
    }
    
    function getComment(commPageNum, event) {
        $.ajax({
            url:"/bbs/commentRead.bbs",
            data:{
                commPageNum:commPageNum*10,
                articleNumber:"${article.articleNumber}"
            },
            beforeSend:function() {
                console.log("읽어오기 시작 전...");
            },
            complete:function() {
                console.log("읽어오기 완료 후...");
            },
            success:function(data) {
                console.log("comment를 정상적으로 조회하였습니다.");
                showHtml(data, commPageNum);
                
                let position = $("#showComment table tr:last").position();
                $('html, body').animate({scrollTop : position.top}, 400);        // 두 번째 param은 스크롤 이동하는 시간
            }
        })
    }
    
</script>

</head>
	<body>
	 <h1>자료실</h1>
	<form>
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" value="${rBean.res_title}"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" value="${rBean.res_email}"></td>
			</tr>
			<tr>
				<td>등록일</td>
				<td><input type="text" value="${rBean.res_writedate}"></td>
			</tr>
			<tr>
				<td colspan="2">파일다운위치지렁</td>
			</tr>
			<tr>
				<td colspan="2"><textarea readonly="readonly">${rBean.res_content}</textarea></td>
			</tr>
			<tr>
				<td><input type="submit" value="수정"></td>
				<td><input type="button" value="삭제"></td>
			</tr>				
		</table>
		
	</form> 
	
	<!-- 댓글자리 -->
	<div>

			<h5>아이디</h5>
			<input type="text" value="<%=email%>" readonly> <br>
			<h5>패스워드</h5>
			<input type="password"> <br>
			<h5>내용</h5>
			<input type="text" id="commentContent"><br>
			<input type="button" id="commentWrite" value="댓글 작성">
	
	</div>
	</body>
</html> 