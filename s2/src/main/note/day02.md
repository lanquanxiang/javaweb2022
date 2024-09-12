# 1. JSP语法
1. JSP是什么？   Java服务器页面
2. JSP有什么特点？
	· Java编写（Java类）/ Servlet API实现对请求和响应的处理
	· Java（*.java）--->Servlet（处理请求和响应 *.java）--->JSP(允许你直接编写网页内容 *.jsp 本质上还是Java)
3. Java、Servlet、JSP、HTML的区别
4. JSP的执行过程
5. JSP的组成部分
	1. Java代码 <%  Java句子（分号）   %>
	2. 表达式（显示变量） <%=  变量（没有分号）  %>(考试)
	3. 全局变量
# 2. JSP指令
1. page 页面（配置页面信息）<%@page 属性="" %>
	1. contentType 如果页面发生乱码，考虑设置此属性
	2. 配置全局错误处理页面(重点)
2. include包含（包含其他页面--导入导航栏和页脚）
	1. 语法 <%@include file="" %> (导入的是源代码)因为可能存在代码冲突，不建议使用
	2. <jsp:include page="menu.jsp"/> 动作元素 （导入的是页面编辑运行的结果）
	3. 动作元素扩展（了解）
3. taglib 标签库（导入第三方标签 JSTL）

# 3. JSP内置对象【重点（新）】
1. 内置对象：已经创建好的对象，不需要开发人员new，可以直接使用
2. 目标：学对象的重要方法，处理数据
## 3.1 out【JspWriter】
1. out.print()输出内容
2. 建议使用response.getWriter()来进行输出【重点】
3. out.close() 关闭输出流（文件下载） 
## 3.2 请求和响应【重点中的重点】
### 1. 请求request【HttpServletRequest】
1. request.getMethod() 获得请求方式：可以根据不同的方式进行不同的处理  /login  SpringMVC
2. request.getRemoteAddr() 获取用户IP地址：设置黑名单/白名单
3. request.getHeader("referer")获取访问来源：防盗链
	扩展：怎么实现？怎么破解？
4. 获得用户发送的数据【重要，考试】






















	

