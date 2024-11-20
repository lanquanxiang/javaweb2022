<%@page import="cn.edu.pzhu.pojo.UserInfo"%>
<%@page import="cn.edu.pzhu.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>分享文件</title>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<h1 class="title">分享文件</h1>
	<form action="upload" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>文件</td>
				<td><input type="file" name="file" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="上传" /></td>
			</tr>
		</table>
	</form>
</body>
</html>