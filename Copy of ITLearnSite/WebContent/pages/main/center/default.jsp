<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="path" value="${pageContext.request.contextPath}" />
<title>Insert title here</title>
</head>

<SCRIPT LANGUAGE="JavaScript"> 

function getCookie( name ){ 
var nameOfCookie = name + "="; 
var x = 0; 
while ( x <= document.cookie.length ) 
{ 
var y = (x+nameOfCookie.length); 
if ( document.cookie.substring( x, y ) == nameOfCookie ) { 
if ( (endOfCookie=document.cookie.indexOf( ";", y )) == -1 ) 
endOfCookie = document.cookie.length; 
return unescape( document.cookie.substring( y, endOfCookie ) ); 
} 
x = document.cookie.indexOf( " ", x ) + 1; 
if ( x == 0 ) 
break; 
} 
return ""; 
} 

//폼의 체크 박스를 체그 하면 새창이 나타나지 않으며, 체크 하지 않았을 경우, 계속 나타납니다. 

if ( getCookie( "Notice" ) != "done" ) { 
//새창으로 열릴 페이지의 경로 및 크기와 위치를 지정해 주세요. 
noticeWindow  =  window.open('${path}/pages/main/center/popup.jsp','','width=510, height=350, left=1400, top=650,scrollbars=no,toolbar=no,menubar=no,location=no,status=no,resizable=no'); 
noticeWindow.opener = self; } 
 
</SCRIPT> 



<%-- function notice_getCookie( name ){
    var nameOfCookie = name + "=";
    var x = 0;
    while ( x <= document.cookie.length )
    {
            var y = (x+nameOfCookie.length);
            if ( document.cookie.substring( x, y ) == nameOfCookie ) {
                    if ( (endOfCookie=document.cookie.indexOf( ";", y )) == -1 )
                            endOfCookie = document.cookie.length;
                    return unescape( document.cookie.substring( y, endOfCookie ) );
            }
            x = document.cookie.indexOf( " ", x ) + 1;
            if ( x == 0 )
                    break;
    }
    return "";
}
if ( notice_getCookie( "Notice" ) != "done" )
{
	var option = "width=500, height=330, left=1400, top=670,scrollbars=no,toolbar=no,menubar=no,location=no,status=no,resizable=no";
        window.open('${path}/pages/main/center/popup.jsp','',option); 
}

function getCookie(name) 
{ 
	var cookie = document.cookie; 
	if (document.cookie != "") 
	{ 
		var cookie_array = cookie.split("; "); 
		for ( var index in cookie_array) 
		{ 
			var cookie_name = cookie_array[index].split("="); 
			if (cookie_name[0] == "popupYN") 
			{ 
				return cookie_name[1];
			} 
		} 
	} 
		return ; 
	} 
function openPopup(url) 
{ 
	var cookieCheck = getCookie("popupYN"); 
	if (cookieCheck != 2) 
	{
		var option = "width=500, height=330, left=1400, top=670,scrollbars=no,toolbar=no,menubar=no,location=no,status=no,resizable=no;";
		window.open(url, 0, option);
	}
} 
 --%>

<body onload="notice_getCookie('Notice');">
	<div class="hero-slide owl-carousel site-blocks-cover">
		<div class="intro-section">
			<img src="images/hero_1.jpg"; data-aos="fade-up">
		</div>

		<div class="intro-section">
			<img src="images/hero_2.jpg" data-aos="fade-up">
		</div>

		<div class="intro-section">
			<img src="images/hero_3.jpg" data-aos="fade-up">
		</div>

	</div>


	<div></div>

	

	<div class="site-section">
		<div class="container">


			<div class="row mb-5 justify-content-center text-center">
				<div class="col-lg-6 mb-5">
					<h2 class="section-title-underline mb-3">
						<span>인기 강좌</span>
					</h2>
				</div>
			</div>

			<div class="row">
				<div class="col-12">
					<div class="owl-slide-3 owl-carousel">
						<div class="course-1-item">
							<figure class="thumnail">
								<a href="${path}/lectureList.lec"><img src="images/alim.png" alt="Image" class="img-fluid"></a>
								<div class="price">50000원</div>
								<div class="category">
									<h3>강의1</h3>
								</div>
							</figure>							
						</div>
						<div class="course-1-item">
							<figure class="thumnail">
								<a href="${path}/lectureList.lec"><img src="images/dongjava.png" alt="Image" class="img-fluid"></a>
								<div class="price">50000원</div>
								<div class="category">
									<h3>강의2</h3>
								</div>
							</figure>					
						</div>
						<div class="course-1-item">
							<figure class="thumnail">
								<a href="${path}/lectureList.lec"><img src="images/jeongsql.png" alt="Image" class="img-fluid"></a>
								<div class="price">50000원</div>
								<div class="category">
									<h3>강의3</h3>
								</div>
							</figure>		
						</div>
						<div class="course-1-item">
							<figure class="thumnail">
								<a href="${path}/lectureList.lec"><img src="images/ricss.png" alt="Image" class="img-fluid"></a>
								<div class="price">50000원</div>
								<div class="category">
									<h3>강의4</h3>
								</div>
							</figure>	
						</div>			
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- // 05 - Block -->
	<div class="site-section">
		<div class="container">
			<div class="row mb-5 justify-content-center text-center">
				<div class="col-lg-4">
					<h2 class="section-title-underline">
						<span>인기 교재</span>
					</h2>
				</div>
			</div>

			<div class="owl-slide owl-carousel">

				<div class="ftco-testimonial-1">
					<div class="ftco-testimonial-vcard d-flex align-items-center mb-4">
						<img src="" alt="Image" class="img-fluid mr-3">
						<div>
							<h3>책제목1</h3>
							<span>저자</span>
						</div>
					</div>
					<div>
						<p>&ldquo;책설명~~~~ &rdquo;</p>
					</div>
				</div>

				<div class="ftco-testimonial-1">
					<div class="ftco-testimonial-vcard d-flex align-items-center mb-4">
						<img src="" alt="Image" class="img-fluid mr-3">
						<div>
							<h3>책제목2</h3>
							<span>저자</span>
						</div>
					</div>
					<div>
						<p>&ldquo;책설명~~~~ &rdquo;</p>
					</div>
				</div>

				<div class="ftco-testimonial-1">
					<div class="ftco-testimonial-vcard d-flex align-items-center mb-4">
						<img src="" alt="Image" class="img-fluid mr-3">
						<div>
							<h3>책제목3</h3>
							<span>저자</span>
						</div>
					</div>
					<div>
						<p>&ldquo;책설명~~~~ &rdquo;</p>
					</div>
				</div>


			</div>

		</div>
	</div>

</body>
</html>