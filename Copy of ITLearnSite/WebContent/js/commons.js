var ctx = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
var //status
chkEmail = false
, chkPw1 = false
, chkPw2 = false
, chkName = false 
, chkPhone = false
, chkGender = false
, chkAddr = false;
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
		chkEmail = false;
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
					chkEmail = false;
				}
				if(getData == 0)
				{
					$("#email ~ p").remove();
					$("#email").after("<p style = 'color : green; '> 사용가능 </p>");
					console.log("사용가능");
					chkEmail = true;
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
		chkPw1 = false;
	}
	else
	{
		$("#pw1 ~ p").remove();
		$("#pw1").after("<p style = 'color : green; '> 사용가능 </p>");
		chkPw1 = true;
	}
}

function pwdEqualChk(){
	var pw1 = $("#pw1").val();
	var pw2 = $("#pw2").val();
	
	if(pw1 == pw2)
	{
		$("#pw2 ~ p").remove();
		$("#pw2").after("<p style = 'color : green; '> 일치함 </p>");
		chkPw2 = true;
	}
	else
	{
		$("#pw2 ~ p").remove();
		$("#pw2").after("<p style = 'color : red; '> 일치하지 않음 </p>");
		chkPw2 = false;
	}
}

function nameChk(){
	var name = $("#name").val();
	var namePattern = /^[가-힣]{2,4}$/;
	
	if(!namePattern.test(name))
	{
		$("#name ~ p").remove();
		$("#name").after("<p style = 'color : red;'> 이름은 2~4자까지 입니다</p>");
		chkName = false;
	}
	else
	{
		$("#name ~ p").remove();
		$("#name").after("<p style = 'color : green;'> 사용가능 </p>");
		chkName = true;
	}
}

function selectGenderChk(){
	var genChk = $("#gender").val();
	
	if(genChk == 1)
	{
		chkGender = true;
	}
	else if(genChk == 2)
	{
		chkGender = true;
	}
	else
	{
		chkGender = false;
	}
	
}

function phoneChk(){
	var phonenumber = $("#phonenumber").val();
	var phonePattern = /^[0-9]*$/;
	
	if(!phonePattern.test(phonenumber))
	{
		alert("유효하지 않은 휴대폰번호입니다.");
		$("#phonenumber").val("");
		chkPhone = false;
	}
	else
	{
		chkPhone = true;
	}
}

function addressChk(){
	var addr = $("#address").val();
	var addr1 = $("#address1").val();
	var addr2 = $("#address2").val();
	
	if(addr == null)
	{
		chkAddr = false;
	}
	else if(addr1 == null)
	{
		chkAddr = false;
	}
	else if(addr2 == null)
	{
		chkAddr = false;
	}
	else
	{
		chkAddr = true;
	}
}


function submitter(){
	if(chkEmail != true)
	{
		$("#email").focus();
		return false;
	}
	else if(chkPw1 != true)
	{
		$("#email").focus();
		return false;
	}
	else if(chkPw2 != true)
	{
		return false;
	}
	else if(chkName != true)
	{
		return false;
	}
	else if(chkGender != true)
	{
		return false;
	}
	else if(chkAddr != true)
	{
		return false;
	}
	else
	{
		return true;
	}
}





