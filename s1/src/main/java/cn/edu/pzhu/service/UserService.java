package cn.edu.pzhu.service;

import cn.edu.pzhu.pojo.Msg;
import cn.edu.pzhu.pojo.User;
import cn.edu.pzhu.pojo.UserInfo;

public interface UserService {
	//登录
	public Msg login(User user);
	//注册
	public Msg regist(User user,UserInfo userinfo);
	//注销
	public Msg destory(String username);
	//退出（销毁session，不需要持久层）

}
