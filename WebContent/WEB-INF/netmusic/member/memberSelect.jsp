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
	
	#fbtn{
		background-color:#FF7878;
		width:130px;
	}
</style>
<script type="text/javascript">

	$(document).ready(function(){
		
		// mouseover, mouseout 이벤트
		$("#fbtn").mouseover(function(){
				
			var follow_id = $("#follow_id").val();
			console.log("follow_id >>> : " + follow_id);
			//alert("데이터 전달 >>> : " + follow_id);
			// callAjaxLogin()함수 호출
			callAjaxLogin(follow_id);
			
			// callAjaxLogin() 함수
			function callAjaxLogin(follow_id){
				
				//alert(follow_id);

				let fcheckURL = "followcheck.a";
				let reqType = "GET";
				let dataParam = { 
						follow_id : follow_id
				};
				
				$.ajax({
					url : fcheckURL,
					type : reqType,
					data : dataParam,
					contentType : "application/x-www-form-urlencoded; charset=UTF-8",
					success : whenSuccess,
					error : whenError
				});
					
				function whenSuccess(resData){
					//alert("회원 데이터 확인 결과 >>> : " + resData);
					
					// 이미 팔로우 중일 때
					 if (resData == "fail" || resData == null ) {

						 $("#fbtn").text("unfollow");
						 
						// 폼태그 데이터 JSP 보내기
						$("#fbtn").click(function(){
							// alert("btn click() 함수 진입 >>> : ");
							console.log("fbtn click() 함수 진입 >>> : ");
							
							$("#followForm").attr({
								"action":"delFollow.a",
								"method":"GET",
								"enctype":"application/x-www-form-urlencoded"
							}).submit();
						});
						
					// 팔로우 중이지 않을 때
					} else if (resData == "success") {
						
						// 폼태그 데이터 JSP 보내기
						$("#fbtn").click(function(){
							// alert("btn click() 함수 진입 >>> : ");
							console.log("fbtn click() 함수 진입 >>> : ");
							
							$("#followForm").attr({
								"action":"addFollow.a",
								"method":"GET",
								"enctype":"application/x-www-form-urlencoded"
							}).submit();
						}); 
					}	
				}
					
				function whenError(e){
					alert("에러가 발생했습니다. >>> : " + e.responseText);
				}
			}
		});
		
		$("#fbtn").mouseout(function(){
			history.go(0);
		});

		//##########################################
	});
</script>
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
<form name="followForm" id="followForm">
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
						<button class="fbtn" id="fbtn" type="button">follow</button>
						<a href="followlist.a">Follow List</a>
						<input type="hidden" name="follow_id" id="follow_id" 
							value="<%= list.get(0).getMb_id() %>">
						<input type="hidden" name="follow_photo" id="follow_photo" 
							value="<%= list.get(0).getMb_photo() %>">
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