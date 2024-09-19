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
	<h1 class="title">
		<%=session.getAttribute("msg") %>
	</h1>
</body>
</html>