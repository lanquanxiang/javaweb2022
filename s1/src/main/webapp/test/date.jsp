<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>显示时间</title>
</head>
<body>
<!-- HTML注释 -->

<%
	//注释
	/* 多行注释 */
	Date today = new Date();
%>
<%=today %>
</body>
</html>