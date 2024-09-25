<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>异常提示</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>

<% 
String url = (String)session.getAttribute("url");

response.setHeader("refresh",  "3;url='"+url+"'"); %>
<h1 class="title">
	${msg},3秒之后将跳转到${url}。
</h1>

</body>
</html>