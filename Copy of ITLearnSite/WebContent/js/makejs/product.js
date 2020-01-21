function select(){
	
	if($("#type").val() == 'book')
	{
		var string = "<h1>도서 정보</h1>";
			string += "<hr>";
			string +="책 제목 : <input type='text' name='book_title'><br><br>";
			string +="책 내용 : <textarea name ='book_content'></textarea><br><br>";
			string +="작가  : <input type='text' name='book_writer'><br><br>";
			string +="출판사 : <input type='text' name ='book_publisher'><br>";
			string +="책 쪽수 : <input type='number' name ='book_page'><br>";
			string +="책 이미지 파일 주소 : <input type='text' name='book_filename'><br>";
		    string +="<input type='submit' value='작성'>";
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