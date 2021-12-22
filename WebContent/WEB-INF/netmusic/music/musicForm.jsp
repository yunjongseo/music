<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>음원 등록</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.css">
<style type="text/css">
	.wrap{
		width:800px;
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
			
		// 장르
		$("#ms_genre2").change(function(){
			$("#ms_genre2 option:selected").each(function(){
				if($(this).val() == '1'){ // 직접 입력일 경우
					var aa = $("#ms_genre1").val();
					//alert("aa >>> : " + aa);
					$("#ms_genre1").val(''); // 값 초기화
					$("#ms_genre1").attr("readonly", false); // 활성화
				}else{ // 직접 입력이 아닐 경우
					$("#ms_genre1").val($(this).text()); // 선택값 입력
					$("#ms_genre1").attr("readonly", true); // 비활성화
				}
			});
		});
		
		// 국가명
		$("#ms_nation2").change(function(){
			$("#ms_nation2 option:selected").each(function(){
				if($(this).val() == '1'){ // 직접 입력일 경우
					var aa = $("#ms_nation1").val();
					//alert("aa >>> : " + aa);
					$("#ms_nation1").val(''); // 값 초기화
					$("#ms_nation1").attr("readonly", false); // 활성화
				}else{ // 직접 입력이 아닐 경우
					$("#ms_nation1").val($(this).text()); // 선택값 입력
					$("#ms_nation1").attr("readonly", true); // 비활성화
				}
			});
		});
		
		// 발매일
		$("#ms_release").on("input", function(){
			var m = $("#ms_release");
			if(m.val().length > m.maxlength){
				m.value = m.value.slice(0, m.maxlength);
			}
		});
		
		// 월
		$("#ms_release1").append("<option value==''>월--- </option>");
		for(var i=1; i <= 12; i++){
			if(i < 10){i='0'+i;}
			$("#ms_release1").append("<option value='"+ i + "'>"+ i + "</option>");
		}
		
		// 일
		$("#ms_release2").append("<option value=''>일--- </option>");
		for(var i=1; i <= 31; i++){
			if(i < 10){i = '0'+i;}
			$("#ms_release2").append("<option value='"+ i + "'>"+ i + "</option>");
		}
		
		// PlayTime
		// 분
		$("#ms_playtime1").append("<option value==''>분--- </option>");
		for(var i=1; i <= 30; i++){
			if(i < 10){i='0'+i;}
			$("#ms_playtime1").append("<option value='"+ i + "'>"+ i + "</option>");
		}
		
		// 초
		$("#ms_playtime2").append("<option value=''>초--- </option>");
		for(var i=1; i <= 60; i++){
			if(i < 10){i = '0'+i;}
			$("#ms_playtime2").append("<option value='"+ i + "'>"+ i + "</option>");
		}
		
		
		// 폼태그 데이터 JSP 보내기
		$("#msbtn").click(function(){
			// alert("btn click() 함수 진입 >>> : ");
			console.log("btn click() 함수 진입 >>> : ");
			
			$("#musicForm").attr({
				"action":"musicInsert.a",
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
<form name="musicForm" id="musicForm">
<table class="table table-hover">
	<thead>
	<div align="center" style="border-bottom:solid gray">
		<h2>음원 등록</h2>
	</div>
	</thead>
	<tbody>
	<tr>
		<td>장르</td>
		<td>
			<input type="text" name="ms_genre1" id="ms_genre1" style="width:100px"
					placeholder="직접 입력"/>
			<select name="ms_genre2" id="ms_genre2">
				<option value="1" selected>직접 입력</option>
				<option value="발라드">발라드</option>
				<option value="가요">가요</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>앨범명</td>
		<td>
			<input type="text" name="ms_album" id="ms_album">
		</td>
	</tr>
	<tr>
		<td>곡명</td>
		<td>
			<input type="text" name="ms_name" id="ms_name">
		</td>
	</tr>
	<tr>
		<td>국가명</td>
		<td>
			<input type="text" name="ms_nation1" id="ms_nation1" style="width:100px"
					placeholder="직접 입력"/>
			<select name="ms_nation2" id="ms_nation2">
				<option value="1" selected>직접 입력</option>
				<option value="한국">한국</option>
				<option value="미국">미국</option>
				<option value="일본">일본</option>
				<option value="중국">중국</option>
				<option value="러시아">러시아</option>
				<option value="터키">터키</option>
				<option value="프랑스">프랑스</option>
				<option value="이탈리아">이탈리아</option>
				<option value="브라질">브라질</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>가수</td>
		<td>
			<input type="text" name="ms_singer" id="ms_singer">
		</td>
	</tr>
	<tr>
		<td>작곡가</td>
		<td>
			<input type="text" name="ms_composer" id="ms_composer">
		</td>
	</tr>
	<tr>
		<td>발매일</td>
		<td>
			<input type="text" name="ms_release" id="ms_release" 
				placeholder="년(4자)" maxlength="4" style="width:100px"/>
			<select name="ms_release1" id="ms_release1"></select>
			<select name="ms_release2" id="ms_release2"></select>
		</td>
	</tr>
	<tr>
		<td>PlayTime</td>
		<td>
			<select name="ms_playtime1" id="ms_playtime1"></select>
			<select name="ms_playtime2" id="ms_playtime2"></select>
		</td>
	</tr>
	<tr>
		<td>앨범 사진</td>
		<td>
			<input type="file" name="ms_photo" id="ms_photo">
		</td>
	</tr>
	<tr>
		<td>음원</td>
		<td>
			<input type="file" name="ms_music" id="ms_music">
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<br>
			<input class="btn-group" type="button" value="등록하기" id="msbtn">
		</td>
	</tr>
	</tbody>
</table>
</form>
</div>
<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>