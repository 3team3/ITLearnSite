$(function(){
	console.log("asdf");
	var url = "commentsList.co";
	var res_no = $("#res_no").val();
	
	alert(res_no);
	
	var form_data = {
			res_no : res_no,
	}
	
	$.ajax({
		type : "post",
		url : url,
		data : form_data,
		dataType : "json",
		contentType: 'application/x-www-form-urlencoded; charset=euc-kr',
		success : function(getData) {
			for (var i = 0; i < getData.list.length; i++) {
				console.log(getData.list[i].co_no);
				console.log(getData.list[i].co_email);
				console.log(getData.list[i].co_content);
				console.log(getData.list[i].co_date);
				
				$(".co_email").html(getData.list[i].co_email);
				$(".co_content").html(getData.list[i].co_content)
				$(".co_date").html(getData.list[i].co_date)
			}
		},
		error : function(request,status,error){
			alert("code = "+ request.status + " message = " + request.responseText + " error = " + error);
			console.log(error);
		}
	});
	/* 페이지 요청시 댓글을 불러온다.*/
});
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
				alert("댓글이 등록되었습니다");
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