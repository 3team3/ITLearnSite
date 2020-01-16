$(function(){
	booklist();
});

function booklist()
{
	var url = "bookselect.text";
	var form_data = {
			/**/
	}
	
	$.ajax({
		type : "post",
		url : url,
		data : form_data,
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		dataType : "json",
		success : function(getData) {
			console.log(getData);
			var string ="";
			
			for (var i = 0; i < getData.list.length; i++) {
				var comments = 
					"<div class='booklist'>"
					+ 	"<div class='bookimg'>"
					+		"<img src='./images/book1.jpg'>"
					+	"</div>"
					+	"<div class='content_wrap'>"
					+		"<a href='#'>"
					+			"<p class='booktitle'>" + getData.list[i].book_title + "</p>"
					+			"<p class='bookcontent'>" + getData.list[i].book_price +"<br>" + getData.list[i].book_page + "<br>" + getData.list[i].book_publisher + "<br>"+ getData.list[i].book_uploaddate
					+			"</p>"
					+		"</a>"
					+	"</div>";
					
				string = string + comments;
			}
			$(".wrapboard").html(string);
		},
		error : function(request,status,error){
			alert("code = "+ request.status + " message = " + request.responseText + " error = " + error);
			console.log(error);
		}
	});
	/* 페이지 요청시 댓글을 불러온다.*/
}