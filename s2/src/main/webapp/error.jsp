<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="menu.jsp"/>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文件分享系统</title>
</head>
<body>	
<%
	String url = (String)session.getAttribute("url");
	response.setHeader("refresh", "3;url='"+url+"'");
%>
	<h1 class="title">
		${msg}3秒之后跳转到${url}。
	</h1>
</body>
</html>