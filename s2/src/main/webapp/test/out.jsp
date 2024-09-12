<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" buffer="0kb"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>输出</title>
</head>
<body>
<%
	out.print("1");
	response.getWriter().print("2");
%>
</body>
</html>