<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="menu.jsp"/>    

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>文件列表</title>
		<link rel="stylesheet" type="text/css" href="css/my.css"/>
	</head>
	<body>
		<c:if test="${empty list}">
			<h1 class="title">没有文件可以显示！</h1>
		</c:if>
	
	<c:if test="${not empty list}">
	
		<h1 class="title">文件列表</h1>
		
			<table>
				<tr>
					<th>序号</th>
					<th>分享用户</th>
					<th>文件名称</th>
					<th>文件类型</th>
					<th>文件下载</th>
					<th>公开时间</th>
					<th>推荐指数</th>
					<th>文件描述</th>
					<th>操作</th>
				</tr>	
				<c:forEach items="${list}" var="file" varStatus="num">
					<tr>
						<td>${num.count}</td>
						<td>${file.username}</td>
						<td>${file.filename}</td>
						<td>${file.classification}</td>
						<td>
						<form action = "download" method = "post">
						<input type = "hidden" name ="filename" value = "${file.filename}">
						<input type = "hidden" name ="filepath" value = "${file.filepath}">
						<input type = "submit" value = "下载"/>
						</form>
						</td>
						<td>${file.releasedate}</td>
						<td>${file.rating}</td>
						<td>${file.description}</td>
						<td>
							<button>编辑</button>
							<button>删除</button>
						</td>
					</tr>				
				</c:forEach>
				
				<tr>
					<td colspan="9">${bar}</td>
				</tr>
				<tr>
					<td colspan="9">
						<form action="showlist">
						   每页显示<input type = "text" name ="num" value ="${empty num?10:num }"/>
						   <input type = "submit" value = "确定"/>
						</form>
					</td>
				</tr>
							
			</table>	
			</c:if>
	</body>
</html>
    