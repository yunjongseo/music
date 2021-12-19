<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.netmusic.member.vo.NetMemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>셀렉트</title>
<style type="text/css">

	body {
			color: white;
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
			top:50%;
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
			background: white;
		}
		p.profile-card {
			color: white; 
			text-align: center;
		}
		div.button {
			width: 120px;
			height: 30px;
			margin-left: 45%; 
			margin-top: 30%;
			text-align: center;
			padding: 5px;
			border: 1px solid white;
		}
</style>
</head>
<body bgcolor="black">
<% request.setCharacterEncoding("UTF-8"); %>
<%
	Object obj = request.getAttribute("listS");
	List<NetMemberVO> list = (List)obj;
	
	int nCnt = list.size();
	System.out.println("nCnt >>> : " + nCnt);
	
	NetMemberVO mvo = new NetMemberVO();
%>
<form>
	<div>
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
							<%-- <img src="netmusic/fileupload/member/sm_<%= mvo.getMb_photo() %>"> --%>
						</div>
						<p class="profile-card"><%= list.get(0).getMb_name() %></p>
					</div>
				</li>
				</ul>
			</div>
		</div>
	</div>
</form>
</body>
</html>