<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.netmusic.member.vo.NetMemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>셀렉트</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.css">
<style type="text/css">

	.wrap{
		width:800px;
		height:600px;
		margin:40px auto;
	}
	
	body {
		color: black;
	}
	p.logo {
		background: transparent;
		color: red; 
		text-align: left;
		font-size: 40px;
		margin-top: 0px;
		margin-left: 10px;
	}
	div.profile-aria{
		/*레이아웃 설정*/
		position:absolute;
		top:30%;
		left:50%;
		transform:translate(-50%, -50%)
	}
	p.tv {
		
	}
	li {
		/*list 가로 배열*/
		float: left; 
		/* 문장 앞에 있는 마커 설정을 없앰; */
		list-style: none; 
		/* 줄바꿈 설정 */
		display: block;
		text-align: center;
		font-size: 28px;
		margin-bottom: 10px;
		margin-left: 25px;
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
	}
	p.profile-card {
		color: gray; 
		text-align: center;
	}
</style>
</head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	Object obj = request.getAttribute("listS");
	List<NetMemberVO> list = (List)obj;
	
	int nCnt = list.size();
	System.out.println("nCnt >>> : " + nCnt);
	
	NetMemberVO mvo = new NetMemberVO();
%>
<form>
	<div class="wrap">
		<!-- 넷 뮤직 로고 -->
		<div>
			<p class="logo">NetMusic</p>
		</div>
		<div class="profile-aria">
			<!-- 프로필 카드 리스트 -->
			<div>
				<ul>
				<li>
					<div class="profile">
						<div class="profile-card">
							<img src="/jsMusic/fileupload/member/sm_<%= list.get(0).getMb_photo() %>"
							width="100" height="100" alt="image"
							style="margin:23px auto;">
						</div>
						<p class="profile-card"><%= list.get(0).getMb_name() %></p>
						<button class="btn" id="btn" type="button">
						<img class="btn-img" src="img\follow.jfif">follow</button>
						<a href="memfollowSelect.a">Follow List</a>
					</div>
				</li>
				</ul>
			</div>
		</div>
		<div style="margin-top:400px; width:100%; float:left; text-align:center;">
		<table class="table table-hover" align="center">
			<tr>
				<td>취향</td>
				<td><%= list.get(0).getMb_liking() %></td>
			</tr>
		</table>
		</div>
<!-- 		<div class="side" align="center" style="margin-top:400px; height:100%; float:left; border-top:solid gray; border-left:solid gray;">

		</div> -->
	</div>
</form>
<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>