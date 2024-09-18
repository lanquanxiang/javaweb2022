# 1. JSP概述
1. JSP是什么？
	Java Server Page Java服务器页面
2. JSP的特点？
3. Java、Servlet、JSP、HTML的区别？

# 2. JSP执行过程（了解）
 JSP---Servlet（本质上是Java）
 
# 3. JSP组成
1. JSP代码块 <%  Java代码   %>
2. JSP表达式 <%=表达式(不要加分号) %>
3. JSP全局（静态）代码或变量  <%!   %>
4. JSP指令
	1. <%@page %> 配置页面相关内容
	2. <%@include %> 包含其他页面
	3. <%@taglib %> 配置第三方库（标签）
## 3.1 page指令
1. contentType(页面乱码 MIME)
2. isErrorPage和errorPage
3. buffer（解决输出不及时）
4. 配置错误页面（显示自定义错误消息）和全局错误
扩展：列举常见的运行时异常？
面试：请问exception和error的区别？ 运行时异常和编译时异常的区别？ 常见的运行时异常有哪些？

## 3.2 include指令（了解）
1. 语法 <%@include file="URI" %>  
2. 元素 <jsp:include page="URI">【重点】
3. 区别：前者（源代码）  后者（结果）

## 3.3 taglib标签库

# 4. JSP内置对象(不需要new 直接使用的对象)（重要：对象的方法）
## 4.1 输出对象out
1. out.print()
2. response.getWriter().print(""); 【重点方法】
3. out.close()

## 4.2 请求和响应【重点，处理HTTP请求和响应】
1. 了解HTTP请求和响应消息构成
2. 对象的重要方法
### request的作用
1. 获取用户的请求方式 get/post（SpringMVC可以区分）   request.getMethod()
2. 获取用户的主机/IP地址（黑名单/白名单）
3. 获取访问来源（防盗链 实现：读取referer 匹配内容 ） 破解：修改请求头
4. 获取用户提交数据【重要重要】
	request.getParameter("表单中控件的名字")
	request.getParameterValues("表单中控件的名字")
5. 获得请求转发器执行转发 request.getRequestDispatcher("URL").forward(request, response);

### response的作用
1. 重定向 response.sendRedirect("URL");

## 4.3 存储对象
1. 对象
	1. request
	2. session
	3. application
2. 区别
	1. 范围不同 request 一次请求  session一次回话  application服务器（所有用户共享）
	2. 获取其他对象
		session = request.getSession();  重要
		application = request.getServletContext()	
3. 增删改查方法
	1. setAttribute("key",value)












