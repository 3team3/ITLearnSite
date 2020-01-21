function select(){
	
	if($("#type").val() == 'book')
	{
		var string = "<legend>도서 정보</legend>";
			string +=    "<div class='form-group'>";
			string +=        "<input type='text' class='form-control' id='book_title' placeholder='책제목'>";
			string +=    "</div>"
            string +=    "<div class='form-group'>";
			string +=        "<input type='text' class='form-control' id='book_content' placeholder='책내용'>";
			string +=    "</div>";
            string +=    "<div class='form-group'>";
			string +=        "<input type='text' class='form-control' id='book_writer' placeholder='작가'>";
			string +=    "</div>";
            string +=    "<div class='form-group'>";
			string +=        "<input type='text' class='form-control' id='item_publisher' placeholder='출판사'>";
			string +=    "</div>";	
            string +=    "<div class='form-group'>";
			string +=        "<input type='text' class='form-control' id='book_page' placeholder='책쪽수'>";
			string +=    "</div>";
            string +=    "<div class='form-group'>";
			string +=        "<input type='text' class='form-control' id='book_filename' placeholder='이미지'>";
			string +=    "</div>";
        
		$(".addtag").html(string);
	}
	else if($("#type").val() == 'lecture'){
		var string = "<h1>강의 정보</h1>";
		string += "<hr>";
		string +="강의 제목 : <input type='text' name='book_title'><br><br>";
		string +="강의 내용 : <textarea name ='book_content'></textarea><br><br>";
		string +="<input type='submit' value='작성'>";
	$(".addtag").html(string);
	}
};

$(function(){
	var url = "bookView.text";
	
	$.ajax({
		type : "post",
		url : url,
		dataType : "json",
		success : function(getData) {
			console.log(getData);
			
		},
		error : function(request,status,error){
			alert("code = "+ request.status + " message = " + request.responseText + " error = " + error);
			console.log(error);
		}
	});
});