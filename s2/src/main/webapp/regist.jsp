<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="menu.jsp"/>    

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>用户注册</title>
		<link rel="stylesheet" type="text/css" href="css/my.css"/>
	</head>
	<body>
		<h1 class="title">用户注册</h1>
		<form action="regist" method="post">
			<table>
				<tr>
					<td>账号</td>
					<td ><input type="text" name="username" /></td>
					<td>用户名不能为空！</td>
				</tr>
				<tr>
					<td>密码</td>
					<td ><input type="password" name="password" /></td>
					<td>密码不能为空！</td>
				</tr>
				<tr>
					<td>email</td>
					<td ><input type="text" name="email" /></td>
					<td>邮箱格式不正确！</td>
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
					<td ><input type="text" name="captcha"  value="gbcw"/></td>
					<td><img src="img/captcha.jpg"/></td>
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
    