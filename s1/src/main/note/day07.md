# 1. JDBC
1. 是什么？JDBC----- Java数据库连接（本质上是一些类、接口）--标准
		JDBC驱动---接口的实现
	注意：位于java.sql.*中
2. JDBC的开发步骤（重点--详细实现（框架））

# 2. JSTL格式化库
	<fmt:formatNumber value="${file.rating}" pattern=".00"></fmt:formatNumber>
	
# 3. JDBC优化
1. 解决驱动重复注册（只注册一次，项目一启动就开始注册）
2. 解决快捷的获取连接（不需要重复提供连接参数）
3. 提供通用的释放资源的方法