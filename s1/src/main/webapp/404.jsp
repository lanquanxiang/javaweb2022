<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文件未找到</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<% response.setStatus(200); %>
<h1 class="title">你访问的文件离家出走了……</h1>
</body>
</html>