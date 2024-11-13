<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="menu.jsp"></jsp:include>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>邮箱登录</title>
		<link rel="stylesheet" type="text/css" href="css/my.css" />
		<script type="text/javascript" src="js/jquery-3.2.0.min.js"></script>
		<script type="text/javascript">
			function send(){
				let username = $("#username").val();
				let email = $("#email").val();
				if(username!="" && email!=""){
					$.post(
						"sendemail",
						{
							"name":username,
							"email":email
						},
						function(res){
							$(".res").html(res);
						}
					)
				}
			}
		</script>
	</head>
	<body>
		<h1 class="title">邮箱登录</h1>
		<form action="loginemail" method="post">
			<table>
				<tr>
					<td>账号</td>
					<td colspan="2">
						<input type="text" name="username" id="username"/>
					</td>
				</tr>
				<tr>
					<td>邮箱</td>
					<td colspan="2">
						<input type="text" name="email" id="email"/>
						<input type="button" value="发送邮件" onclick="send()" style="position: absolute;">
					</td>
				</tr>
				<tr>
					<td>验证码</td>
					<td colspan="2">
						<input type="text" name="code" />
						<span class="res" style="position: absolute;"></span>
					</td>
				</tr>
				
				<tr>
					<td></td>
					<td colspan="2">
						<input type="submit"  value="登录" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
