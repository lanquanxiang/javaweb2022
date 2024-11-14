package cn.edu.pzhu.service;

import cn.edu.pzhu.pojo.Msg;
import cn.edu.pzhu.pojo.User;
import cn.edu.pzhu.pojo.UserInfo;

public interface UserService {
	//定义用户服务的业务层接口
	//登录
	public Msg login(User user);
	//注册
	public Msg regist(User user,UserInfo userinfo);
	//注销
	public Msg destory(String username);
	//查看个人信息
	public UserInfo showUserInfo(String username);
	//修改个人信息
	//......
	//修改密码
	//......
	public boolean checkusername(String username);
	//发送邮件
	/**
	 * 发送邮件
	 * @param username 给username发邮件
	 * @param email
	 * @return 如果成功返回true和正确验证码，如果失败返回false和原因。
	 */
	public Msg sendemail(String username,String email);
	
	
}
