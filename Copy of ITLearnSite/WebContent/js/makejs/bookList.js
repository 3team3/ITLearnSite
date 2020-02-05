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
		var booktitle = decodeURIComponent(getData.list[i].book_title);
		
		/*pasing 책이름*/
		var title = booktitle.split('[');
		title = title[0];
//		title = title.substring(0, title.length-1);
		var uri = decodeURIComponent(getData.list[i].book_image);
		console.log(uri);
		var p_no =  getData.list[i].product_no;
		
		var comments = 
			"<div class='booklist'>"
			+ 	"<div class='bookimg'>"
			+		"<img src='"+decodeURIComponent(getData.list[i].book_image)+"'>"
			+	"</div>"
			+	"<div class='content_wrap'>"
			+		"<a href='bookdetail.text?product_no=" + getData.list[i].product_no +"'>"
			+			"<p class='booktitle'>" + booktitle + "</p>"
			+		"</a>"
			+			"<p class='book_price'> 가격 : " + getData.list[i].book_price + "원</p>"
			+		"<div class='buttons'>"
			+			"<a href='cartAdd.cart?&pro_name="+decodeURIComponent(getData.list[i].book_title)+"&pro_price="+getData.list[i].book_price+"&pro_img="+decodeURIComponent(getData.list[i].book_image)+"&pro_sort=도서&pro_cnt=1' class='btn btn-outline-primary rounded-0 px-4'> 담기 </a>"
			+			"<button class='btn btn-outline-secondary'> 맛보기 </button>"
			+			"<input type='button' class='btn btn-outline-danger float-r' value='삭제' onclick='deleteQues("+ p_no + ");'>"
			+		"</div>"
			+	"</div>"
			+"</div>";
			
		string = string + comments;
	}
	$(".wrapboard").html(string);
}
function deleteQues(p_no){

	var Ques = confirm("선택한 책을 지우시겠습니까?");
	if(Ques == true){
		location.href='bookdelete.text?product_no='+ p_no	
	}
	else if(Ques == false)
	{
		return false;
	}
}
function setBookDetail(getData){
	var request = new Request();
	var product_no = request.getParameter("product_no");
	var url = "detailload.text";
	
	var form_data = {
		product_no : product_no
	}
	$.ajax({
		type : "post",
		url : url,
		data : form_data,
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success : function(getData) {
			
		},
		error : function(request,status,error){
			alert("code = "+ request.status + " message = " + request.responseText + " error = " + error);
			console.log(error);
		}
	});
	
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
			else if(direction == "bookdetail.text")
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