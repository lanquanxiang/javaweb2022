安全和便捷（相互矛盾）
# 1. cookie
1. cookie是什么？ 信息存储片段，存储在客户端，目的：让某些数据在之后继续使用
2. cookie和session的区别？ 存储位置；使用原理
3. cookie的使用（增删改查）
	session的增删改查： 
		1. 增加 session.setAttribute("key",value);
		2. 删除/移除  session.removeAttribute("key");
		3. 修改 session.setAttribute("key",value);
		4. 查询 session.getAttribute("key");
	cookie的增删改查：
		1. 增加 Cookie cookie = new Cookie("key", value);response.addCookie(cookie);
			注意：没有无参构造方法；值不能包含中文。 如果有需要中文，提前进行编码。
		2. 删除 cookie.setMaxAg(0)
		3. 修改 Cookie cookie = new Cookie("key", 新的value);response.addCookie(cookie);
		4. 查询 ${cookie.XXX(唯一标识).value}
		
# 2. 二次验证
## 1. 发送邮件
1. 视图
2. 控制器
3. 业务层
4. 持久层
5. 发送邮件工具
## 2. 账号+邮箱+验证码（登录）