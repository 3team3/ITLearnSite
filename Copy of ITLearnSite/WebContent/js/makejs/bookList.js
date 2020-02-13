$(function(){
	var path = window.location.pathname;
	var path = path.split("/");
	var path = path[2].trim();
	var num = 1;
	
	var direction = path;
	if(direction != null){
		console.log("요청 페이지=" +direction);
		booklist(direction, num);
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
			+			"<a href='cartAdd.cart?&product_no="+getData.list[i].product_no+ "&pro_name="+decodeURIComponent(getData.list[i].book_title)+"&pro_price="+getData.list[i].book_price+"&pro_img="+decodeURIComponent(getData.list[i].book_image)+"&pro_sort="+getData.list[i].product_type+"&pro_cnt=1' class='btn btn-outline-success rounded-0 px-4'> 담기 </a>"
			+		"</div>"
			+	"</div>"
			+"</div>";
		string = string + comments;
	}
	
	var pageCount = getData.count;
	console.log(pageCount);
	var pageTag = "";
	var string2 ="";
	
	if(pageCount <= 5)
	{
		pageCount = 1;
	}
	
	if(pageCount > 5)
	{
		if(pageCount % 5 != 0){
			pageCount = pageCount / 5 + 1;
		} 
		else if(pageCount % 5 == 0){
			pageCount = pageCount / 5;
		}
	}
	
	for(var i = 1; i <= pageCount; i++)
	{
		var paging ="<button class='btn btn-light' onclick = " +'"'+ "booklist('bookList.text'," + "'" +i+ "')" + '"'+">" + i + "</button>";
		string2 = string2 + paging;
	}
	
	console.log(string2);
//	for(var page = 1; pageCount > 1; page ++)
//	{
//		var pageNum = "<div style='text-align:center;'>" 
////			+	"<button onclick='booklist('bookList.text', "+page+")'>"+page+"</button>" 
//			+"</div>";
//		
//	}
//		<c:set var="page" value="${count}"></c:set>
//		<!-- 전체 글수를 받아와서 block 단위로  -->
//		<div style="text-align: center;">
//			<c:forEach var="i" begin="1" end="${page}">
//				<c:if test="${page!=0}">
//					<button onclick="booklist('bookList.text', '${i}')">${i}</button>
//				</c:if>
//			</c:forEach>
//		</div>
	
	$(".wrapboard").html(string+"<div style='text-align:center'> "+string2 + "</div>");
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
function num(no){
	var num = no;
}

function booklist(direction, num)
{
	var url = "bookselect.text?num="+num;
	
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
}