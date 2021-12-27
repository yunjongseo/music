<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.netmusic.follow.vo.NetFollowVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Follow List</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.css">
<style type="text/css">
	.wrap{
		width:800px;
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
		
		// 폼태그 데이터 JSP 보내기
		$("#fbbtn").click(function(){
			// alert("btn click() 함수 진입 >>> : ");
			console.log("btn click() 함수 진입 >>> : ");
			
			$("#followForm").attr({
				"action":"mainpage.a",
				"method":"GET",
				"enctype":"application/x-www-form-urlencoded"
			}).submit();
		});
	});
</script>
</head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	Object obj = request.getAttribute("listS");
	List<NetFollowVO> list = (List)obj;
	Object obj1 = request.getAttribute("mb_name");
	String mb_name = String.valueOf(obj1);
	
	int nCnt = list.size();
	System.out.println("nCnt >>> : " + nCnt);
%>
<form name="followForm" id="followForm">
<table class="table table-hover" align="center">
	<tr>
		<td><%= mb_name %> 님의 Follow List</td>
	</tr>
<%
	for(int i=0; i < nCnt; i++){
		NetFollowVO fvo = list.get(i);
%>
	<tr>
		<td><img src="/jsMusic/fileupload/member/sm_<%= fvo.getFollow_photo() %>"></td>
		<td><%= fvo.getMb_follow() %></td>
	</tr>
<%
	}
%>
	<tr>
		<td align="center">
			<br>
			<input class="btn-group" type="button" value="메인으로" id="fbbtn">
		</td>
	</tr>
</table>
</form>
<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>