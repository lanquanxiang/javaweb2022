<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="menu.jsp"/>    

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>用户注册</title>
		<link rel="stylesheet" type="text/css" href="css/my.css"/>
		
		<script type="text/javascript" src="js/jquery-3.2.0.min.js"></script>
		<script type="text/javascript">
			function check(){
				let username = $("#username").val();
				if(username!=""){
					$.post("checkusername",{"name":username},function(res){
						$(".note").html(res); //$(".note").text(res);
					})
				}
			}
			
			
			function reload(cn){
				if(cn=='cn'){
					$("#captcha").attr("src","captcha?cn=yes&time="+new Date().getTime());
				}else{
					$("#captcha").attr("src","captcha?time="+new Date().getTime());
				}
				
			}
			
		</script>
		
		
	</head>
	<body>
		<h1 class="title">用户注册</h1>
		<form action="regist" method="post">
			<table>
				<tr>
					<td>账号</td>
					<td ><input type="text" name="username" onchange="check()" id="username"/></td>
					<td><span class="note" style="position: absolute;"></span> </td>
				</tr>
				<tr>
					<td>密码</td>
					<td ><input type="password" name="password" /></td>
					<td></td>
				</tr>
				<tr>
					<td>email</td>
					<td ><input type="text" name="email" /></td>
					<td></td>
				</tr>
				<tr>
					<td>性别</td>
					<td><input type="radio" value="1" name="sex" checked/>男
					<input type="radio" value="0" name="sex" />女</td>
					<td></td>
				</tr>
				<tr>
					
					<td>关注类型</td>
					<td colspan="2">
						<input type="checkbox" value="法律规定" name="type" checked>法律规定
						<input type="checkbox" value="管理办法" name="type">管理办法
						<input type="checkbox" value="决定条例" name="type">决定条例
						<input type="checkbox" value="细则解释" name="type">细则解释
						<input type="checkbox" value="规范指南" name="type">规范指南
					</td>
					
				</tr>
				<tr>
					<td>验证码</td>
					<td ><input type="text" name="captcha"/></td>
					<td><img id="captcha" src="captcha" alt="验证码加载失败" title="点击刷新" onclick="reload()"/>
						<a href="#" onclick="reload('cn')">中文验证码</a>
					</td>
				</tr>
				<tr>
					
					<td></td>
					<td colspan="2">
						<input type="submit" value="注册">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
    