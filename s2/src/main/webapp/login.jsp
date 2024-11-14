<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="menu.jsp"/>    

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>用户登录</title>
		<link rel="stylesheet" type="text/css" href="css/my.css"/>
	</head>
	<body>
		<h1 class="title">用户登录</h1>
		<form action="login" method="post">
			<table>
				<tr>
					<td>账号</td>
					<td colspan="2"><input type="text" name="username" value="${cookie.username.value }"/></td>
				</tr>
				<tr>
					<td>密码</td>
					<td colspan="2"><input type="password" name="password" value="${cookie.password.value }"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="checkbox" name="save" value="yes" ${empty cookie.save.value ? '':'checked' }/>密码保存七天</td>
					<td><a href="loginemail.jsp">忘记密码</a></td>
				</tr>
				<tr>
					
					<td></td>
					<td colspan="2">
						<input type="submit" value="登录">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
    