<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.css">
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
		/* $("#mb_id").attr("placeholder", "아이디 ");
		$("#mb_pw").attr("placeholder", "비밀번호 ");
		
		$("#btn").click(function(){
			console.log("btn >>> : ");
			
			$("#loginForm").attr({
				"action":"login.a",
				"method":"POST",
				"enctype":"application/x-www-form-urlencoded"
			}).submit();
		}); */
	
	
		$("#btn").click(function(){
	
			/////////////////////////////////////////////////////////////////////////
			// null check
			if ('' == $("#mb_id").val() || 
				'' == $("#mb_pw").val()){
				$("#mb_id").val('');
				$("#mb_pw").val('');
				
				alert("아이디 / 비밀번호를 입력해주세요.");
				return
			}
			
			var mb_id = $("#mb_id").val();
			console.log("mb_id >>> : " + mb_id);
			var mb_pw = $("#mb_pw").val();
			console.log("mb_pw >>> : " + mb_pw);
			alert("데이터 전달 >>> : " + mb_id +" : "+ mb_pw);
			// callAjaxLogin()함수 호출
			callAjaxLogin(mb_id, mb_pw);
			
		});
		
		// callAjaxLogin() 함수
		function callAjaxLogin(mb_id, mb_pw){
			
			alert(mb_id +" : "+ mb_pw);

			let loginURL = "loginMsg.a";
			let reqType = "POST";
			let dataParam = { 
					mb_id : mb_id,
					mb_pw : mb_pw
			};
			
			$.ajax({
				url : loginURL,
				type : reqType,
				data : dataParam,
				contentType : "application/x-www-form-urlencoded; charset=UTF-8",
				success : whenSuccess,
				error : whenError
			});
				
			function whenSuccess(resData){
				alert("회원 데이터 확인 결과 >>> : " + resData);
					
				 if (resData == "success") {
					
					alert("로그인 성공!")
					location.href="good.a";
					return dataParam 
					
				} else if (resData == "fail" || resData == null) {
					
					alert("로그인 실패 : 아이디 / 비밀번호를 다시 확인해주세요.");
				}	
			}
				
			function whenError(e){
				$("#mb_id").val("");
				$("#mb_pw").val("");
				alert("에러가 발생했습니다. >>> : " + e.responseText);
			}
				
		}
	});
</script>
</head>
<body>
<div class="wrap">
<form name="loginForm" id="loginForm">
<table border="1" align="center">
	<tr>
		<td>아이디&nbsp;&nbsp;</td>
		<td>
			<input type="text" name="mb_id" id="mb_id" style="width:200px;">
		</td>
	</tr>
	<tr>
		<td>비밀번호&nbsp;&nbsp;</td>
		<td>
			<input type="password" name="mb_pw" id="mb_pw" style="width:200px;">
		</td>
	</tr>
	<tr>
		<td align="center" colspan="2">
			<button type="button" class="btn-group" id="btn">로그인</button>
		</td>
	</tr>
	<tr>
		<td align="right" colspan="2">
			<a href="memForm.a">
				<font size="2">회원가입</font>
			</a> | 
			<a href="idFindForm.a">
				<font size="2">아이디 찾기</font>
			</a> | 
			<a href="pwFindForm.a">
				<font size="2">비밀번호 찾기</font>
			</a>
		</td>
	</tr>
</table>
</form>
</div>
<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>