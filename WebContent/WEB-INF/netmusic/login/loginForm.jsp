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