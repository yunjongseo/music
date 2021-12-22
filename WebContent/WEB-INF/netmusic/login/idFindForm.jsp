<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
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
		
		$("#idbtn").click(function(){
			console.log("idbtn >>> : ");
			//alert("idbtn >>> : ");
			$("#idForm").attr({
				"action":"idFind.a",
				"method":"GET",
				"enctype":"application/x-www-form-urlencoded"
			}).submit();
		});
	});
</script>
</head>
<body>
<div class="wrap">
<h4 align="center">아이디 찾기</h4>
<form name="idForm" id="idForm">
<table class="table table-hover" align="center">
	<tr>
		<td>이름</td>
		<td>
			<input type="text" name="mb_name" id="mb_name" 
				style="width:200px;">
		</td>
	</tr>
	<tr>
		<td>생년월일</td>
		<td>
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
		<td colspan="2" align="center">
			<button class="btn-group" type="button" id="idbtn">다음</button>
		</td>
	</tr>
</table>
</form>
</div>
<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>