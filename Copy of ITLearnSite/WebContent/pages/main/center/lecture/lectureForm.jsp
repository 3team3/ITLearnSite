<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<head>
<title></title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	function fnWrite() {
		var f = document.writeForm;
		var cnt = f.elements.length;

		//누락된 파일업로드 위치를 나타낼 변수
		var filecnt = 1;

		for (i = 0; i < cnt; i++) {
			// <input type="file">인 태그 중에서
			if (f.elements[i].type == "file") {
				// 업로드할 파일을 지정하지 않았다면?
				if (f.elements[i].value == "") {
					var msg = filecnt + "번째 파일이 누락 되었습니다. \n 업로드할 파일을 선택해 주세요";
					alert(msg);

					f.elements[i].focus();
					return; // submit하지 않고, 함수 종료 
				}

				filecnt++; // <input>태그의 type이 file일때만 1씩증가
			}
		}

		document.writeForm.submit();
	}

	var inputCnt = 1; // input태그 구분 번호
	// 첨부파일추가 버튼을 누를때 마다 file태그 하나씩 추가
	function addInput() {
		// input태그를 추가할 div태그 위치 주소 가져오기
		var div = document.getElementById("inputDiv");
		var msg1 = "<input type ='text' name='list_title" + inputCnt + "' id='list_title" + inputCnt + "' placeholder='list " + inputCnt + "'/>";
		var msg2 = "<input type='file' name='upfile" + inputCnt + "' id='upfile" + inputCnt + "'/>";
		/* var msg3 = "<input type='button' value='취소' onclick='deleteInput("
				+ inputCnt + ")' " + " name='btnCancel" + inputCnt + "' "
				+ " id='btnCancel" + inputCnt + "'/>"; */
		var msg4 = "<br id='br" + inputCnt + "' />";
		inputCnt++;

		//div태그영역 안에  위의 input태그 누적		
		div.innerHTML += msg1;
		div.innerHTML += msg2;
		/* div.innerHTML += msg3; */
		div.innerHTML += msg4;
	}

	function deleteInput(num) {
		var list_title = document.getElementById("list_title" + num);
		var input = document.getElementById("upfile" + num);
		/* var btn = document.getElementById("btnCancel" + num); */
		var br = document.getElementById("br" + num);

		list_title.outerHTML = "";
		input.outerHTML = "";
		/* btn.outerHTML = ""; */
		br.outerHTML = "";

	}

	function complete() {
		var con = confirm("동영상 업로드 갯수가 " + (inputCnt - 1) + "개가 맞습니까?");
		var div = document.getElementById("inputDiv");
		if (con) {

			div.innerHTML += "<input type='hidden' value='" + (inputCnt - 1)
					+ "' name='cnt'/>";
		} else {
			location.reload();
			/* div.innerHTML = ""; */
		}
	}

	function readURL(input) {

		//크롬 웹브라우저의 F12 개발자 모드로 가서 console 탭에 띄운로그 메시지 확인
		console.debug(input);
		console.debug(input.files);

		/* 
			<input type="file"/> 인 태그 객체의 files 메서드 호출 시
			FileList 라는 배열이 생성, FileList 배열 내부의 0번째 인덱스 위치에
			아래에서 선택한(업로드할) 파일 정보를 key:value 쌍으로 저장한 File객체에 저장
		 */
		//<input type="file"> 태그에서 업로드를 하기 위한 파일 선택 시
		//FileList라는 배열 존재하고, FileList라는 배열의 0번째 인덱스 위치 아래에 
		//파일업로드를 위해 선택한 File 객체가 저장되어 있다면?
		if (input.files && input.files[0]) {

			//동적으로 <img> 태그 만들어 추가
			$("#tdImg").html(
					"<img id = 'preview' src='#' width=200 height= 200 />");

			//파일을 읽어올 객체 생성
			var reader = new FileReader();

			//지정한 img태그에 첫번째 파일 input에 첨부한  파일에 대한 File 객체를 읽음
			reader.readAsDataURL(input.files[0]);

			//파일 내용을 모두 읽어 들였다면?
			//읽어 들인 File 객체 정보는 매개변수로 넘어오는 ProgressEvent 객체 내부의
			//target 속성에 대응되는 객체(JSON객체 데이터 형식)으로 저장
			//또한 JSON 객체 데이터 내부에는 result 속성에 읽어 들인 File 객체 정보가 저장			
			reader.onload = function(ProgressEvent) {

				console.debug(ProgressEvent);

				//id 속성값이 preview인 <img> 태그에 attr() 메서드를 이용,
				//파일 첨부 시 미리보기 이미지를 나타내기 위해
				//<img> 태그의 src 속성에 new FileReader()객체 이용, 
				//읽어들인 첨부할 File 객체 정보를 지정, 추가하여 이미지 파일의 미리보기 기능 가능
				$("#preview").attr("src", ProgressEvent.target.result);

			}
		}
	}
</script>

<div class="site-section ftco-subscribe-1 site-blocks-cover pb-4"
	style="background-image: url('../images/bg_1.jpg')">
	<div class="container">
		<div class="row align-items-end justify-content-center text-center">
			<div class="col-lg-7">
				<h2 class="mb-0">강의 등록</h2>
				<p>Lecture Register</p>
			</div>
		</div>
	</div>
</div>

<div class="custom-breadcrumns border-bottom">
	<div class="container">
		<a href="${path}/index.do">Home</a> <span
			class="mx-3 icon-keyboard_arrow_right"></span> <a
			href="${path}/lectureList.lec">강의실</a> <span
			class="mx-3 icon-keyboard_arrow_right"></span> <span class="current">강의
			목록</span>
	</div>
</div>

</head>

<body>

	<form method="post" action="lectureRegister.lec"
		enctype="multipart/form-data" name="writeForm">
		<fieldset>
			<legend>파일 업로드</legend>

			<label for="txt_title">강의명</label> <input type="text" name="lec_title"
				id="lec_title"><br>
				<label for="lec_price">금액</label><input type="text" name="lec_price" id="lec_price"><br>
				 <label for="txt_content">내용
				: </label> <br>
			<textarea name="lec_content" id="lec_content" rows="10" cols="50"></textarea>
			<br> <label>이미지 파일 추가</label> <input type="file" name="lec_imgfile"
				id="lec_imgfile" onchange="readURL(this);"><div id="tdImg"></div><br> <input type="button"
				value="동영상파일추가" onclick="addInput()"> <input type="button"
				value="업로드 영상 개수 확인" onclick="complete();" /> <br>
			<div id="inputDiv"></div>


		</fieldset>

		<div id="buttons">
			<input type="button" value="등록" class="submit" onclick="fnWrite()">
			<input type="reset" value="다시작성" class="cancel">
		</div>
	</form>



</body>
</html>