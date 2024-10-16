<%@page import="cn.edu.pzhu.pojo.UserInfo"%>
<%@page import="cn.edu.pzhu.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>

<%
if(application.getAttribute("userzhangsan")==null){
	User pre = new User("zhangsan", "123456", 1);
	UserInfo preinfo = new UserInfo("zhangsan","123456@qq.com", 1, "[\"法律规定\",\"管理办法\",\"决定条例\"]");
	application.setAttribute("userzhangsan", pre);
	application.setAttribute("userinfozhangsan", preinfo);
	System.out.print("已经内置账号zhangsan，密码是123456.");
}
%>
<h1 class="title">
	欢迎使用文件分享系统……
</h1>

</body>
</html>