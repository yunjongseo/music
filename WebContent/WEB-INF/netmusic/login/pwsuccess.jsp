<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PW EMAIL CHECK</title>
</head>
<body>
PW EMAIL CHECK
<hr>
<%
	Object obj = request.getAttribute("temp_pw_num");
	if(obj == null) return;
	
	String temp_pw_num = obj.toString();
	String ptemppwStr = "임시 비밀번호를 메일로 전송했습니다.";
	System.out.println("ptemppwStr >>> : " + ptemppwStr);
%>
<?xml version='1.0' encoding='UTF-8'?>
<login>
	<result><%= ptemppwStr %></result>
</login>
</body>
</html>