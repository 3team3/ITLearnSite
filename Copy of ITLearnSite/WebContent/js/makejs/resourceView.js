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