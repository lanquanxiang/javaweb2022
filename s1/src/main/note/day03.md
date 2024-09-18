# 1. 数据校验(后端)
1. 文本框、密码（输入） 没有值 得到  "".equals(x)
2. 复选框没有选择 得到null   x==null


# 2. Servlet
1. Servlet的概念
	能够处理请求和响应的java 继承HttpServlet
2. Servlet体系结构
	了解接口的作用
3. Servlet的生命周期
	1. 构造（访问Servlet的时候--默认）可以用过配置或者注解修改 --- 容器自动完成
	2. 初始化（访问Servlet的时候--默认）可以用过配置或者注解修改 --- 容器自动完成
	3. 激活（doPost--doGet）反复调用
	4. 销毁（关闭服务器时）--- 容器自动完成
4. Servlet的配置
	1. 配置地址 @WebServlet("/regist")
	
# 3. JavaBean
1. 分类 值+工具









