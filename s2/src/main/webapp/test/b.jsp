<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>处理错误的页面</title>
</head>
<body>
<% response.setStatus(200); %>
<%=exception %>
</body>
</html>