<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.netmusic.member.vo.NetMemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색 테스트</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
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
    	float:right;
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
		
		// 검색버튼
		$(document).on("click", "#searchBtn", function(){
			alert("searchBtn >>> : ");
			$("#searchForm").attr({
				"method":"GET",
				"action":"memberSelectAll.a"
			}).submit();
		});
	});
</script>
</head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	Object obj = request.getAttribute("listAll");
	List<NetMemberVO> list = (List)obj;
	
	int nCnt = list.size();
	System.out.println("nCnt >>> : " + nCnt);
%>
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
			<select id="keyfilter" name="keyfilter">
				<option value="key1">id</option>
				<option value="key2">이름</option>
			</select>&nbsp;&nbsp;
			<input type="text" id="keyword" name="keyword" placeholder="검색어 입력">&nbsp;&nbsp;
			<button type="button" class="btn-group" id="searchBtn">검색</button>
		</td>
	</tr>
</thead>
</table>
<%
	for(int i=0; i < nCnt; i++){
		NetMemberVO mvo = list.get(i);
%>
<div class="profile-1">
	<ul>
	<li>
		<div class="profile">
			<div class="profile-card">
				<%-- <img src="netmusic/fileupload/member/sm_<%= mvo.getMb_photo() %>"> --%>
			</div>
			<a href="memberSelect.a?mb_num=<%=mvo.getMb_num() %>"><%=mvo.getMb_name() %></a>
		</div>
	</li>
	</ul>
</div>
<%
	} // end of for
%>
</div>
</form>
<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>