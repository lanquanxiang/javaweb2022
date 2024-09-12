<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>显示当前日期</title>
</head>
<body>
<%
	Date today = new Date();
%>
当前日期是：<%=today %>
</body>
</html>