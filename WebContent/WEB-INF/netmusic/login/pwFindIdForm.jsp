<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<link rel="stylesheet" href="css/bootstrap.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style type="text/css">
	
	.wrap{
		width:600px;
		height:600px;
		margin:40px auto;
	}
	
	.btn-group{
    	boredr:1px solid;
    	background-color:rgba(0,0,0,0);
    	color:black;
    }
</style>
<script type="text/javascript">

	$(document).ready(function(){
		
		// 임시 비밀번호
		$("#pwFindbtn").click(function(){
			alert("springPwTemp emailbtn >>> : ");
			
			let url = "pwTempCheck.a";
			let midVal = $("#mb_id").val();
			let memailVal = $("#mb_email").val();
			
			console.log("midVal >>> : " + midVal);
			console.log("memailVal >>> : " + memailVal);
			
			$.get(	url,
					{"mb_id":midVal, "mb_email":memailVal},
					function(data){
						var sVal = $(data).find("result").text();
						alert(sVal);
					}
			)
			
			/* $("#pwFindForm").attr({
				"action":"loginForm.a",
				"method":"GET",
				"enctype":"application/x-www-form-urlencoded"
			}).submit(); */
		});
	});
</script>
</head>
<body>
<h4 align="center">아이디를 입력해주세요</h4>
<div class="wrap">
<form name="pwFindForm" id="pwFindForm">
<table class="table table-hover" align="center">
	<tr>
		<td>아이디</td>
		<td>
			<input type="text" name="mb_id" id="mb_id" placeholder="아이디" style="width:200px;">
		</td>
	</tr>
	<tr>
		<td>이메일 주소</td>
		<td>
			<input type="text" name="mb_email" id="mb_email" style="width:200px;">
			<button class="btn-group" type="button" id="pwFindbtn">임시 비밀번호 받기</button>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">임시 비밀번호가 오지 않나요<img src="/jsMusic/img/question.png" 
		width="20" height="20"
		title="발송한 메일이 스팸메일로 분류되는 것은 아닌지 &#13;확인하세요, 스팸메일함에도 메일이 없으면 &#13;다시 한번 '임시 비밀번호 받기'를 눌러주세요">
		</td>
	</tr>
	<tr>
		<td align="right" colspan="2">
			<a href="loginForm.a">
				<font size="2">로그인</font>
			</a> | 
			<a href="idFindForm.a">
				<font size="2">아이디 찾기</font>
			</a>
		</td>
	</tr>
</table>
</form>
</div>
<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>