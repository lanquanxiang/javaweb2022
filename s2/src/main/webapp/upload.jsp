<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="menu.jsp"/>    

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>分享文件</title>
		<link rel="stylesheet" type="text/css" href="css/my.css"/>
	</head>
	<body>
		<h1 class="title">分享文件</h1>
		<form action="upload" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>选择文件</td>
					<td><input type="file" name="file"/></td>
				</tr>
				
				<tr>
					<td colspan="2">
						<input type="submit" value="上传">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
    