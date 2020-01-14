$(function(){
	cmtlist();
});
function nologin()
{
	var results = confirm("로그인 하시겠습니까?");
	if(results == true)
	{
		location.href = "login.do";
	}
}

function cmtlist()
{
	var url = "commentsList.co";
	var res_no = $("#res_no").val();
	
	
	var form_data = {
			res_no : res_no,
	}
	
	$.ajax({
		type : "post",
		url : url,
		data : form_data,
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		dataType : "json",
		success : function(getData) {
			var string ="";
			for (var i = 0; i < getData.list.length; i++) {
				var comments = 
					 	"<tr>"
					+ 		"<td width='10%'>"+getData.list[i].co_email+"</td>"
					+		"<td width='70%'>"+getData.list[i].co_content+"</td>"
					+ 		"<td width='10%'>"+getData.list[i].co_date+"</td>"
					+ 	"</tr>";
				
				string = string + comments;
			}
			$("#cmt").html(string);
		},
		error : function(request,status,error){
			alert("code = "+ request.status + " message = " + request.responseText + " error = " + error);
			console.log(error);
		}
	});
	/* 페이지 요청시 댓글을 불러온다.*/
}
function comments(){
	
	var url = "commentsWrite.co";
	var co_no = $("#co_no").val();
	var res_no = $("#res_no").val();
	var co_email = $("#co_email").val();
	var content = $("#content").val();
	
	var form_data = {
			co_no : co_no,
			res_no : res_no,
			co_email : co_email,
			content : content,
	}
	
	$.ajax({
		type : "post",
		url : url,
		data : form_data,
		dataType : "text",
		success : function(getData) {
			if(getData == 1)
			{
				alert("댓글이 등록되었습니다.");
				cmtlist();
			}
		}
	});
	
}
/*로직
 * 
 * 1. 댓글 작성을 눌렀을 때 ajax로 id pw 맞는지 확인하고 맞으면! : select count(email) ? 1 : 0
 * 2. ajax로 한번더 1 -> insert into 
 * 3. 
 * 
 */