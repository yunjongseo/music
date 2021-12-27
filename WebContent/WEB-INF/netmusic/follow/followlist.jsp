<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.netmusic.member.vo.NetFollowVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.css">
<style type="text/css">
	.wrap{
		width:800px;
		height:600px;
		margin:40px auto;
	}
</style>
</head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	Object obj = request.getAttribute("listS");
	List<NetFollowVO> list = (List)obj;
	
	int nCnt = list.size();
	System.out.println("nCnt >>> : " + nCnt);
%>
<form>
<table class="table table-hover" align="center">
	<tr>
		<td>Follow List</td>
	</tr>
<%
	for(int i=0; i < nCnt; i++){
		NetFollowVO fvo = list.get(i);
%>
	<tr>
		<td><%= fvo.getMb_follow() %></td>
	</tr>
<%
	}
%>
</table>
</form>
<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>