<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="css/my.css"/>
	</head>
	<body>
		<div class="header">
			<a href="index.jsp" style="float: left;"><img src="img/logo.png" height="50px" alt=""></a>
			<ul style="float: left;">
				<li><a href="">文件列表</a></li>
				<li class="menu">分类查看
					<ul>
						<li><a href="">法律规定</a></li>
						<li><a href="">管理办法</a></li>
						<li><a href="">决定条例</a></li>
						<li><a href="">细则解释</a></li>
						<li><a href="">规范指南</a></li>
						<li><a href="">其他文件</a></li>
					</ul>
				</li>
				<li class="menu">文件分享
				<ul>
					<li><a href="">分享文件</a></li>
					<li><a href="">我的分享</a></li>
		
				</ul>
				</li>
				<li>文件检索
				<form action="" method="get" style="display: inline-block;">
					<input type="text" name="" id="" value=""  style="line-height: 25px; width: 150px;"/>
				<input type="image" src="img/search.png" height="20px" style="vertical-align: middle;"/>
				</form>
				</li>
			</ul>
			<ul style="float: right;">
			
				<c:if test="${not empty user}">
					<li class="menu">${user.username}
						<ul>
							<li><a href="userinfo.jsp">个人信息</a></li>
							<li><a href="">修改密码</a></li>
							<li><a href="">注销账户</a></li>
						</ul>
					</li>
					<li><a href="logout">退出</a></li>
				</c:if>
			
				
				
				<c:if test="${empty user}">				
					<li><a href="login.jsp">登录</a></li>
					<li><a href="regist.jsp">注册</a></li>
				</c:if>
			</ul>
		</div>
		
		<div class="footer">
			<span>攀枝花学院&copy;软件二班</span>
			<span>网站访问量：5</span>
			<span>当前登录人数：1</span>
		</div>
		
	</body>
</html>
    