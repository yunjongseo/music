<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.netmusic.member.vo.NetMemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Id List</title>
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
		$("#idbtn").click(function(){
			console.log("idbtn >>> : ");
			//alert("idbtn >>> : ");
			$("#idListForm").attr({
				"action":"loginForm.a",
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
	Object obj = request.getAttribute("listid");
	List<NetMemberVO> list = (List)obj;
	
	int nCnt = list.size();
	System.out.println("nCnt >>> : " + nCnt);
%>
<div class="wrap">
<form name="idListForm" id="idListForm">
<table class="table table-hover" align="center">
	<tr>
		<td align="center">========= 가입한 아이디 =========</td>
	<tr>
<%
	for(int i=0; i < nCnt; i++){
		NetMemberVO mvo = list.get(i);
%>
	<tr>
		<td align="center"><%= mvo.getMb_id() %></td>
	</tr>
<%
	}
%>
	<tr>
		<td colspan="2" align="center">
			<button class="btn-group" type="button" id="idbtn">로그인 화면으로</button>
		</td>
	</tr>
</table>
</form>
</div>
<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>