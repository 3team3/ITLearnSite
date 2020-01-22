function select() {

	if ($("#type").val() == 'book') {
		var string = "<legend>도서 정보</legend>";
		string += "<div class='form-group'>";
		string += "<input type='text' class='form-control' id='book_title' placeholder='책제목'>";
		string += "</div>"
		string += "<div class='form-group'>";
		string += "<input type='text' class='form-control' id='book_link' placeholder='책링크'>";
		string += "</div>";
		string += "<div class='form-group'>";
		string += "<input type='text' class='form-control' id='book_image' placeholder='책이미지'>";
		string += "</div>";
		string += "<div class='form-group'>";
		string += "<input type='text' class='form-control' id='book_author' placeholder='작가'>";
		string += "</div>";
		string += "<div class='form-group'>";
		string += "<input type='text' class='form-control' id='book_price' placeholder='책가격'>";
		string += "</div>";
		string += "<div class='form-group'>";
		string += "<input type='text' class='form-control' id='book_discount' placeholder='할인금액'>";
		string += "</div>";
		string += "<div class='form-group'>";
		string += "<input type='text' class='form-control' id='book_publisher' placeholder='출판사'>";
		string += "</div>";
		string += "<div class='form-group'>";
		string += "<input type='text' class='form-control' id='book_pubdate' placeholder='출판일'>";
		string += "</div>";
		string += "<div class='form-group'>";
		string += "<input type='text' class='form-control' id='book_isbn' placeholder='isbn'>";
		string += "</div>";
		string += "<div class='form-group'>";
		string += "<input type='text' class='form-control' id='book_description' placeholder='description'>";
		string += "</div>";

		$(".addtag").html(string);
	} else if ($("#type").val() == 'lecture') {
		var string = "<h1>강의 정보</h1>";
		string += "<hr>";
		string += "강의 제목 : <input type='text' name='book_title'><br><br>";
		string += "강의 내용 : <textarea name ='book_content'></textarea><br><br>";
		string += "<input type='submit' value='작성'>";
		$(".addtag").html(string);
	}
};

function bookSearch(page) {
	var url = "bookView.text";
	var word = $("#word").val();/* 네이버 책 검색 */
	var listArr = null;
	var data = {
		word : word,
	}

	$.ajax({
		type : "post",
		url : url,
		data : data,
		dataType : "json",
		success : function(getData) {
			console.log(getData);
			console.log(getData.total);
			var total = getData.total;
			var start = getData.start;
			var display = getData.display;
			/* 페이지= index+1 */
			$(".find").html(total);
			listArr = new Array();
			for (var i = 0; i < display; i++) {
				listArr.push(getData.items[i]);
				console.log(listArr[i].title);
			}
			var i = page-1;
			$(".title ~ p").remove();
			$(".title").after("<p>" + listArr[i].title + "</p>");
			$("#book_title").val(listArr[i].title);
			
			$(".link ~ p").remove();
			$(".link").after("<p>" + listArr[i].link + "</p>");
			$("#book_link").val(listArr[i].link);
			
			$(".image ~ p").remove();
			$(".image").after("<p>" + listArr[i].image + "</p>");
			$("#book_image").val(listArr[i].image);
			
			$(".author ~ p").remove();
			$(".author").after("<p>" + listArr[i].author + "</p>");
			$("#book_author").val(listArr[i].author);
			
			$(".price ~ p").remove();
			$(".price").after("<p>" + listArr[i].price + "</p>");
			$("#book_price").val(listArr[i].price);
			
			$(".discount ~ p").remove();
			$(".discount").after("<p>" + listArr[i].discount + "</p>");
			$("#book_discount").val(listArr[i].discount);
			
			$(".publisher ~ p").remove();
			$(".publisher").after("<p>" + listArr[i].publisher + "</p>");
			$("#book_publisher").val(listArr[i].publisher);
			
			$(".pubdate ~ p").remove();
			$(".pubdate").after("<p>" + listArr[i].pubdate + "</p>");
			$("#book_pubdate").val(listArr[i].pubdate);
			
			$(".isbn ~ p").remove();
			$(".isbn").after("<p>" + listArr[i].isbn + "</p>");
			$("#book_isbn").val(listArr[i].isbn);
			
			$(".description ~ p").remove();
			$(".description").after("<p>" + listArr[i].description + "</p>");
			$("#book_description").val(listArr[i].description);
		},
		error : function(request, status, error) {
			alert("code = " + request.status + " message = "
					+ request.responseText + " error = " + error);
			console.log(error);
		}
	});
};

function add(){
	
}
