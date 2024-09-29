# 1. EL表达式语言
1. 目的：简化显示
2. 语法：${表达式}
3. 用法（表达式是什么）
	1. 运算（算术、逻辑、关系、条件）
	2. 显示对象的属性 ${对象.属性名}
	3. 显示数组的元素 ${数组[索引]}
	4. 显示域对象（page、request、session、application）的内容
		${pageScope.X}
		${requestScope.X}
		${sessionScope.X}
		${applicationScope.X}
		全面的域可以省略，读取顺序从小到大
	5. ${pageContext.request.contextPath} 获得项目的根路径-->将相对路径转为相对服务器路径
	6. ${cookie.X.value}

# 2. JSTL JSP标准标签库
1. 目的：标签-->显示、分支、循环：减少在JSP页面中写Java代码
2. 有什么?
	1. 核心库
		1. 显示：可以使用EL代替
		2. 分支
		3. 循环
	2. 格式化库（数字、日期、....）
	










