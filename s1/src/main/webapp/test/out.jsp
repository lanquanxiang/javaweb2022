<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>输出</title>
</head>
<body>
<%
	out.print("1"); //通过JSPWriter进行输出

	response.getWriter().print("2"); //通过响应对象获得输出流【重点方法】
	
%>
</body>
</html>