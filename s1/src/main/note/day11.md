系统安全和提高用户体验
# 1. 账号和密码保存
1. cookie是什么？ 信息存储（Session）
2. 与Session区别：cookie存在客户端；cookie（JS、服务器）；不能保存中文（编码解码）
3. 怎么使用？（增删改查）   session的增删改查-setAttribute removeAttribute setAttribute getAttribute
	1. 增加 response.addCookie(cookie);
	2. 删除 cookie.setMaxAge(0) 单位是秒
	3. 修改  response.addCookie(cookie);  key相同就可以直接覆盖
	4. 获取 ${cookie.xxx.value }