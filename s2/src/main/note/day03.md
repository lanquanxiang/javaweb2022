# 1. MVC
1. MVC是什么
2. 每个模块的作用

# 2. M（JavaBean）
1. 如何将数据表映射为POJO（考试）
2. 映射过程中需要注意的事项：
	1. 变量名首字母不能大写
	2. 基础数据类型需要进行转换
	
# 3. Servlet
1. Servlet是什么？
	能够处理请求和响应的Java
2. Servlet的特点？
3. Servlet的创建与配置
4. Servlet的生命周期（如何运行）

# 4. MVC实践
1. 数据接收
2. 数据校验  1. 文本框没有输入是空串
3. 数据存储
	1. request、session、application
	2. 增加：setAttribute(key，value)
	3. 删除：removeAttribute(key)
	4. 修改：setAttribute(key，value) 如果存在key同名，覆盖之前的值
	5. 查询：getAttribute(key)
4. 视图跳转
	1. 请求转发 request.getRequestDispatcher("URL").forward(request, response);
	2. 重定向response.sendRedirect("URL");
	3. 请求转发（不想丢失request中的参数；转到到不可直接访问的页面）





















	

