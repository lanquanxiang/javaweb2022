<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="menu.jsp"/>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人信息</title>
</head>
<body>
	<h1 class="title">个人信息</h1>
	<%
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	String email=request.getParameter("email");
	String sex=request.getParameter("sex");
	String [] types=request.getParameterValues("type");
	String code=request.getParameter("captcha");
	%>
	账号:<%=username %><br>
	密码:<%=password %><br>
	email:<%=email %><br>
	性别:<%=sex %><br>
	关注类型:<%=Arrays.toString(types) %><br>
	验证码:<%=code %><br>
</body>
</html>