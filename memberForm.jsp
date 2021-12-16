<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.css">
<style type="text/css">
	.wrap{
		width:600px;
		height:600px;
		margin:40px auto;
	}
	
	#video {
	  	/* position: absolute; */
	    top: 0px;
	    left: 0px;
	    min-width: 100%;
	    min-height: 100%;
	    height:400px;
	    width: 1px;
	    z-index: -1;
	    overflow: hidden;
	    background-size:30px 30px;
    }
    
    .btn-group{
    	boredr:1px solid;
    	background-color:rgba(0,0,0,0);
    	color:black;
    }
</style>
<script type="text/javascript">

	$(document).ready(function(){
		
		// 아이디 중복 체크 시작===============================
		$("#mb_idbtn").click(function(){
			console.log("idCheck >>> : ");
			
			let midVal = $("#mb_id").val();
			alert("midVal >>> : " + midVal);
			if(midVal == ''){
				alert("중복 체크할 아이디를 입력하세요 >>> : ");
				$("#mb_id").focus();
				return false;
			}
		});
		
		// 아이디 중복 체크 Ajax 동기 방식
		$(document).on("click", "#mb_idbtn", function(){
			alert("mb_idbtn >>> : ");
			syncIdCheckData();
		});
		
		async function syncIdCheckData(){
			
			let idCheckData = "";
			console.log("start >>> : ");
			
			var vv = $("#mb_id").val();
			alert("vv >>> : " + vv);
			
			idCheckData = await ajaxIdCheckData(vv);
			alert("리턴된 데이터 >>> : " + idCheckData);
			
			if("ID_YES" == idCheckData){
				alert("아이디 사용 가능 : ID_YES.");
				
				$("#mb_id").attr("readonly", true);
				$("#mb_id").css("background-color", "lightgray");
				$("#mb_pw").focus();
			}else if("ID_NO" == idCheckData){
				alert("이미 사용 중인 아이디 : ID_NO.");
				
				$("#mb_id").val("");
				$("#mb_id").focus();
			};
		}
		
		function ajaxIdCheckData(myval){
			alert("myval >>> : " + myval);
			
			let idCheckURL = "memIdCheck.a";
			let reqType = "POST";
			let dataParam = {mb_id:myval, };
			
			return $.ajax({
				url:idCheckURL,
				type:reqType,
				data:dataParam
			});
		}
		// 아이디 중복 체크 끝 =====================================
			
		// 비밀번호 체크
		$("#pwCheck").click(function(){
			console.log("pwCheck 함수 진입 >>> : ");
			
			var pw = $("#mb_pw").val();
			var pw_r = $("#mb_pw_r").val();
			
			if(pw == ''){
				alert("비밀번호를 입력하세요 >>> :");
				$("#mb_pw").focus();
				return false;
			}
			
			if(pw_r == ''){
				alert("비밀번호 확인을 입력하세요 >>> :");
				$("#mb_pw_r").focus();
				return false;
			}
			
			if(pw == pw_r){
				alert("비밀번호가 같습니다");
				pw_r.val('');

				$("#mb_gender").focus();
				return true;
			}else{
				alert("비밀번호가 다릅니다");
				pw.val('');
				pw_r.val('');
				pw.focus();
				
				return false;
			}
		}); // 비밀번호 체크 끝 =====================================
			
		// 생년월일
		$("#mb_birth").on("input", function(){
			var m = $("#mb_birth");
			if(m.val().length > m.maxlength){
				m.value = m.value.slice(0, m.maxlength);
			}
		});
		
		// 월
		$("#mb_birth1").append("<option value==''>월--- </option>");
		for(var i=1; i <= 12; i++){
			if(i < 10){i='0'+i;}
			$("#mb_birth1").append("<option value='"+ i + "'>"+ i + "</option>");
		}
		
		// 일
		$("#mb_birth2").append("<option value=''>일--- </option>");
		for(var i=1; i <= 31; i++){
			if(i < 10){i = '0'+i;}
			$("#mb_birth2").append("<option value='"+ i + "'>"+ i + "</option>");
		}
		
		// 이메일
		$("#mb_email2").change(function(){
			$("#mb_email2 option:selected").each(function(){
				if($(this).val() == '1'){ // 직접 입력일 경우
					var aa = $("#mb_email1").val();
					//alert("aa >>> : " + aa);
					$("#mb_email1").val(''); // 값 초기화
					$("#mb_email1").attr("readonly", false); // 활성화
				}else{ // 직접 입력이 아닐 경우
					$("#mb_email1").val($(this).text()); // 선택값 입력
					$("#mb_email1").attr("readonly", true); // 비활성화
				}
			});
		});
		// 폼태그 데이터 JSP 보내기
		$("#mbbtn").click(function(){
			// alert("btn click() 함수 진입 >>> : ");
			console.log("btn click() 함수 진입 >>> : ");
			
			$("#memForm").attr({
				"action":"memInsert.a",
				"method":"POST",
				"enctype":"multipart/form-data"
			}).submit();
		});
	});
</script>
</head>
<body>
<video id="video" preload="auto" autoplay="true" loop="loop" muted="muted" volume="0">
      <source src="img/Dj.mp4">
</video>
<div class="wrap">
<form name="memForm" id="memForm">
<table class="table table-hover">
	<thead>
	<div align="center" style="border-bottom:solid gray">
		<h2>Net Music 회원가입</h2>
	</div>
	</thead>
	<tbody>
	<tr>
		<td>아이디</td>
		<td>
			<input type="text" name="mb_id" id="mb_id"/>
			<input class="btn-group" type="button" name="mb_idbtn" id="mb_idbtn" 
				value="아이디 중복 확인"/>
		</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td>
			<input type="password" name="mb_pw" id="mb_pw"/><br>
			<input type="password" name="mb_pw_r" id="mb_pw_r" placeholder="비밀번호 확인"/>
		 	<input class="btn-group" type="button" value="비밀번호 확인" id="pwCheck"/><br>
		</td>
	</tr>
	<tr>
		<td>이름</td>
		<td>
			<input type="text" name="mb_name" id="mb_name"/>
		</td>
	</tr>
	<tr>
		<td>성별</td>
		<td>
			<input type="radio" name="mb_gen" value="남자" checked />남자&nbsp;&nbsp;
			<input type="radio" name="mb_gen" value="여자"/>여자
		</td>
	</tr>
	<tr>
		<td>생년월일</td>
		<td>
			<!-- <input type="text" name="mb_birth" id="mb_birth" 
				placeholder="ex)20200101" minlength="8 "maxlength="8" 
				onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" /> -->
			<input type="text" name="mb_birth" id="mb_birth" placeholder="년(4자)"
					maxlength="4" style="width:100px"/>
			<select name="mb_birth1" id="mb_birth1"></select>
			<select name="mb_birth2" id="mb_birth2"></select>
		</td>
	</tr>
	<tr>
		<td>핸드폰 번호</td>
		<td>
			<input type="text" name="mb_hp" id="mb_hp" placeholder="- 빼고 번호만 입력" />
		</td>
	</tr>
	<tr>
		<td>이메일 주소</td>
		<td>
			<input type="text" name="mb_email" id="mb_email" style="width:100px"/>
			@ <input type="text" name="mb_email1" id="mb_email1" style="width:100px"
					placeholder="직접 입력"/>
			<select name="mb_email2" id="mb_email2">
				<option value="1" selected>직접 입력</option>
				<option value="naver.com">naver.com</option>
				<option value="gmail.com">gmail.com</option>
				<option value="daum.net">daum.net</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>사진</td>
		<td>
			<input class="btn-group" type="file" name="mb_photo" id="mb_photo">
		</td>
	</tr>
	<tr>
		<td>음악 취향</td>
		<td>
			<input type="checkbox" name="mb_liking" value="발라드">&nbsp;발라드&nbsp;
			<input type="checkbox" name="mb_liking" value="EDM">&nbsp;EDM&nbsp;
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<br>
			<input class="btn-group" type="button" value="가입하기" id="mbbtn">
		</td>
	</tr>
	</tbody>
</table>
</form>
</div>
<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>