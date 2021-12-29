<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.netmusic.member.vo.NetMemberVO" %>
<%@ page import="com.netmusic.music.vo.NetMusicVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NetMusic에 오신 것을 환영합니다</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.css">
<style type="text/css">
	
	.wrap{
		width:1000px;
		height:600px;
		margin:40px auto;
	}
	
	.btn-group{
    	boredr:1px solid;
    	background-color:rgba(0,0,0,0);
    	color:black;
		height:27px;
    }

    li {
		/*list 가로 배열*/
		float: left; 
		/* 문장 앞에 있는 마커 설정을 없앰; */
		list-style: none; 
		margin: 10px; 
		/* 줄바꿈 설정 */
		display: block;
	}
	div.profile {
		width: 150px; 
		height: 200px; 
		background: transparent;
	}
	div.profile-card{
		width: 150px; 
		height: 150px;
		background: black;
		float:center;
	}
	p.profile-card {
		color: gray; 
	}
	
	.profile-1{
		
	}
	
	a{
		float:right;
	}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		
		// 카카오 결제
		$("#cash").click(function(){
			$.ajax({
				url:"kakao.a",
				dataType:"json",
				success:function(data){
					let box = data.next_redirect_pc_url;
					window.open(box);
				},
				error:function(error){
					alert(error);
				}
			});
		});
		
		// 검색버튼
		$(document).on("click", "#searchBtn", function(){
			alert("searchBtn >>> : ");
			$("#searchForm").attr({
				"method":"GET",
				"action":"mainpage.a"
			}).submit();
		});
	});

	function firstChange() {// 대분류 변한 경우

		var x = document.searchForm.first.options.selectedIndex;//선택한 인덱스
		var groups = document.searchForm.first.options.length;//대분류 갯수
		var group = new Array(groups);//배열 생성

		for (i=0; i < groups; i++) {
			group[i] = new Array();
		}//for

		// 옵션(<option>) 생성
		group[0][0] = new Option("아이디","key1"); //결과 <option value="key1">아이디</option>
		group[0][1] = new Option("이름","key2");
		group[1][0] = new Option("곡명","key3");
		group[1][1] = new Option("가수명","key4");
		group[1][2] = new Option("작곡가명","key5");
		group[1][3] = new Option("가사","key6");

		temp = document.searchForm.second; //두 번째 셀렉트 얻기(<select name=second>)

		for (m = temp.options.length-1 ; m > 0; m--) { //현재 값 지우기
			temp.options[m] = null;
		}

		for (i=0; i < group[x].length; i++){ //값 셋팅
			//예) <option value="key1">아이디</option>
			temp.options[i] = new Option(group[x][i].text, group[x][i].value);
		}

		temp.options[0].selected = true; //인덱스 0번째, 즉, 첫 번째 선택
	} //firstChange
</script>
</head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>	
<form name="searchForm" id="searchForm">
<div class="wrap">
<table class="table table-hover" align="center">
<thead>
	<tr>
		<td colspan="10" align="center">
			<h2>회원 검색</h2>
	</tr>
	<tr>
		<td colspan="10" align="left">
			<select name=first onchange="firstChange();" size=1 style="width:80px; height:25px;">
				<option value=''>회원</option>
				<option value=''>음원</option>
			</select>&nbsp;
			<select name=second onchange="secondChange();" size=1 style="width:80px; height:25px;">
				<option value='key1'>아이디</option>
				<option value='key2'>이름</option>
			</select>&nbsp;
			<input type="text" id="keyword" name="keyword" placeholder="검색어 입력">&nbsp;&nbsp;
			<button type="button" class="btn-group" id="searchBtn">검색</button>
		</td>
	</tr>
</thead>
</table>
<%
	try{
		Object obj = request.getAttribute("listAll");
		List<NetMemberVO> list = (List)obj;
		
		int nCnt = list.size();
		System.out.println("nCnt >>> : " + nCnt);
		
		for(int i=0; i < nCnt; i++){
			NetMemberVO mvo = list.get(i);
%>
<div class="profile-1">
	<ul>
	<li>
		<div class="profile">
			<div class="profile-card">
				<img src="/jsMusic/fileupload/member/sm_<%= mvo.getMb_photo() %>"
							width="100" height="100" alt="image"
							style="margin:23px 0px 0px 25px;">
			</div>
			<a href="memberSelect.a?mb_num=<%=mvo.getMb_num() %>"><%=mvo.getMb_name() %></a>
		</div>
	</li>
	</ul>
</div>
<%
		} // end of for
%>
<%
	}catch(Exception e){
	}
	
%>
<%
	try{
		Object obj1 = request.getAttribute("mlistAll");
		List<NetMusicVO> mlist = (List)obj1;
		
		int mnCnt = mlist.size();
		System.out.println("mnCnt >>> : " + mnCnt);

		for(int i=0; i < mnCnt; i++){
			NetMusicVO mvo = mlist.get(i);
%>
<div class="profile-1">
	<ul>
	<li>
		<div class="profile">
			<div class="profile-card">
				<img src="/jsMusic/fileupload/music/<%= mvo.getMs_photo() %>"
							width="100" height="100" alt="image"
							style="margin:23px 0px 0px 25px;">
			</div>
			<a href="memberSelect.a?mb_num=<%=mvo.getMb_num() %>"><%=mvo.getMs_album() %></a><br>
			<p style="float:right;"><%= mvo.getMs_singer() %></p>
		</div>
	</li>
	</ul>
</div>
<%
		} // end of for
	}catch(Exception e){}
%>
</div>
<a href="memberSelectAll.a">홈으로</a><br>
<a href="musicForm.a">음원 등록</a><br>
<a href="followlist.a">Follow List</a><br>
<a href="followerlist.a">Follower List</a><br>
<a href="#">마이 페이지</a><br>
<a href="memberSelectAll.a">회원 검색</a><br>
<a href="followerlist.a">음원 검색</a><br>
<input type="button" style="float:right;" class="btn-group" id="cash" name="cash" value="결제">
<br><hr><hr>
<h4>발라드</h4>
</form>
<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>