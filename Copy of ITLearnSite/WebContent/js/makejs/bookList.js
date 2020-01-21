$(function(){
	var path = window.location.pathname;
	var path = path.split("/");
	var path = path[2].trim();
	
	var direction = path;
	if(direction != null){
		console.log("요청 페이지=" +direction);
		booklist(direction);
	}
});

function Request(){
	var requestParam ="";
        this.getParameter = function(param){
    	var url = unescape(location.href); //현재 주소를 decoding
        var paramArr = (url.substring(url.indexOf("?")+1,url.length)).split("&"); //파라미터만 자르고, 다시 &그분자를 잘라서 배열에 넣는다. 
        for(var i = 0 ; i < paramArr.length ; i++){

            var temp = paramArr[i].split("="); //파라미터 변수명을 담음
            if(temp[0].toUpperCase() == param.toUpperCase()){
            	requestParam = paramArr[i].split("=")[1]; // 변수명과 일치할 경우 데이터 삽입
                break;
            }
        }
        return requestParam;
    };
}

function setBooklist(getData){
	var string ="";
	
	for(var i = 0; i < getData.list.length; i++) {
		var booktitle = getData.list[i].book_title;
		
		/*pasing 책이름*/
		var title = booktitle.split('[');
		title = title[0];
//		title = title.substring(0, title.length-1);
		var comments = 
			"<div class='booklist'>"
			+ 	"<div class='bookimg'>"
			+		"<img src='./images/" + getData.list[i].book_filename+"'>"
			+	"</div>"
			+	"<div class='content_wrap'>"
			+		"<a href='bookView.text?product_no=" + getData.list[i].product_no +"&word=" + title + "'>"
			+			"<p class='booktitle'>" + getData.list[i].book_title + "</p>"
			+			"<p class='bookcontent'>가격 : " + getData.list[i].book_price +"원<br>페이지 수 : " + encodeURI(getData.list[i].book_page) + "쪽<br>출판사 : " + getData.list[i].book_publisher + "<br>작가 : " + getData.list[i].book_writer + "<br>출판일 : "+ getData.list[i].book_uploaddate
			+			"</p>"
			+		"</a>"
			+		"<button class='btn btn-color1'> 담기 </button>"
			+		"<button class='btn btn-color1'> 맛보기 </button>"
			+		"<button class='btn btn-danger float-r'> 삭제 </button>"
			+	"</div>";
			
		string = string + comments;
	}
	$(".wrapboard").html(string);
}

function setBookDetail(getData){
	var request = new Request();
	var product_no = request.getParameter("product_no");
	var string ="";
	var i = product_no;
	
		var comments = 
			"<div class='wrap'>"
			+ 	"<div class='bookimg'>"
			+	"</div>"
			+	"<div class='bookinfo'>"        
			+		"<span class='booktitle'>"
			+			getData.list[i].book_title
			+		"</span>"
			+		"<span class='bookdetail'>"
			+			"<div class='detail-align'>"
			+				"<p class='p1'>"+" 정&nbsp;&nbsp;&nbsp;가"+"</p>"
			+				"<p class='p2'>"+getData.list[i].book_price+"원</p>"
			+			"</div>"
			+			"<div class='detail-align'>"
			+				"<p class='p1'>출&nbsp;&nbsp;&nbsp;간</p>"
			+				"<p class='p2'>"+getData.list[i].book_publisher+"</p>"
			+			"</div>"
			+			"<div class='detail-align'>"
			+				"<p class='p1'>지은이</p>"    
			+				"<p class='p2'>"+getData.list[i].book_writer+"</p>"
			+			"</div>"
			+			"<div class='detail-align'>"
			+				"<p class='p1'>부&nbsp;&nbsp;&nbsp;록</p>"
			+				"<p class='p2'><a href='#'>자료실</a></p>"
			+			"</div>"
			+		"</span>"
			+		"<span class='bookdetail2'>"
            +        	"<div class='detail-align'>"
	        +        		"<p class='p1'>분&nbsp;&nbsp;&nbsp;량</p>"
	        +        		"<p class='p2'>"+getData.list[i].book_page+"쪽</p>"
            +        	"</div>"
            +        	"<div class='detail-align'>"
	        +        		"<p class='p1'>구매</p>"
	        +        		"<p class='p2 buylink'>"
	        +  				"</p>"
            +        	"</div>"
            +    	"</span>"
			+"</div>"; 
			
		string = string + comments;
	$(".list").html(string);
	$(".bookimg1").insertAfter(".bookimg");
	$(".link").insertAfter(".buylink");
}
function booklist(direction)
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
			if(direction == "bookList.text")
			{
				setBooklist(getData);
			}
			else if(direction == "bookView.text")
			{
				setBookDetail(getData);
			}
		},
		error : function(request,status,error){
			alert("code = "+ request.status + " message = " + request.responseText + " error = " + error);
			console.log(error);
		}
	});
	/* 페이지 요청시 댓글을 불러온다.*/
}