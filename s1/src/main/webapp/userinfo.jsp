<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人信息</title>
<script type="text/javascript" src="js/jquery-3.2.0.min.js"></script>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>


	<h1 class="title">个人信息</h1>

	<form action="regist" method="get">
		<table>
			<tr>
				<td>账号</td>
				<td>
					<input type="text" value="${user.username}" disabled="disabled"/>
					<input type="hidden" name="username" value="${user.username}" />
				</td>
				<td></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password"  value="${user.password}" /></td>
				<td></td>
			</tr>
			<tr>
				<td>email</td>
				<td><input type="text" name="email"  value="${userinfo.email}"/></td>
				<td></td>
			</tr>
			<tr>
				<td>性别</td>
				<td colspan="2" align="left"><input type="radio" value="1"	name="sex" ${userinfo.gender==1?"checked":""}/>男 
					<input type="radio" value="0" name="sex" ${userinfo.gender==0?"checked":""}/>女</td>
			</tr>
			<tr>
				<td>关注类型</td>
				<td colspan="2">
					<input type="checkbox" value="法律规定" name="type"/>法律规定
					<input type="checkbox" value="管理办法" name="type" />管理办法
					<input type="checkbox" value="决定条例" name="type" />决定条例
					<input type="checkbox" value="细则解释" name="type" />细则解释
					<input type="checkbox" value="规范指南" name="type" />规范指南</td>
			</tr>			
			
			<tr>
				<td></td>
				<td colspan="2"><input type="submit" value="修改" /></td>
			</tr>
		</table>
		<c:forEach items="${types}" var="type">
			<script type="text/javascript">
				$(":checkbox[value='${type }']").attr('checked','checked')
			</script>
			
		</c:forEach>
		
	</form>
</body>
</html>