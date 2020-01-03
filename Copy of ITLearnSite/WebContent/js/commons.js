var ctx = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));

/*회원가입 유효성*/

/*이메일(아이디) 유효성 체크 */
function emailDupChk(){
	var url = ctx+"/emailDupChk.do";
	var email = $("#email").val();
	var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
	
	if(!emailPattern.test(email))
	{
		$("#email ~ p").remove();
		$("#email").after("<p style = 'color : red; '> 올바른 형식이 아닙니다 </p>");
	}
	else
	{
		data = {
				email : email,
		}
		$.ajax({
			type : "post",
			url : url,
			data : data,
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			dataType : "text",
			success : function(getData){
				console.log(getData);
				
				if(getData == 1)
				{
					$("#email ~ p").remove();
					$("#email").after("<p style = 'color : red; '> 중복 </p>");
					console.log("중복");
				}
				if(getData == 0)
				{
					$("#email ~ p").remove();
					$("#email").after("<p style = 'color : green; '> 사용가능 </p>");
					console.log("사용가능");
				}
			}
		});
	}
}

function pwdRegChk(){
	var pw1 = $("#pw1").val();
	//숫자, 특수문자 1회이상 , 영문 2개 이상 8자리 이상 입력
	var pwPattern=/(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,50}$/;

	if(!pwPattern.test(pw1))
	{
		$("#pw1 ~ p").remove();
		$("#pw1").after("<p style = 'color : red; '> 숫자, 특수문자 1회이상 , 영문 2개 이상 8자리 이상 입력 </p>");
	}
	else
	{
		$("#pw1 ~ p").remove();
		$("#pw1").after("<p style = 'color : green; '> 사용가능 </p>");
	}
}

function pwdEqualChk(){
	var pw1 = $("#pw1").val();
	var pw2 = $("#pw2").val();
	
	if(pw1 == pw2)
	{
		$("#pw2 ~ p").remove();
		$("#pw2").after("<p style = 'color : green; '> 일치함 </p>");
	}
	else
	{
		$("#pw2 ~ p").remove();
		$("#pw2").after("<p style = 'color : red; '> 일치하지 않음 </p>");
	}
}

function nameChk(){
	var name = $("#name").val();
	var namePattern = /^[가-힣]{2,4}$/;
	
	if(!namePattern.test(name))
	{
		$("#name ~ p").remove();
		$("#name").after("<p style = 'color : red;'> 이름은 2~4자까지 입니다</p>");
	}
	else
	{
		$("#name ~ p").remove();
		$("#name").after("<p style = 'color : green;'> 사용가능 </p>");
	}
}

function birthChk(){
	
}



