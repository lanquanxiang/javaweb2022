package cn.edu.pzhu.service;

import cn.edu.pzhu.pojo.Msg;
import cn.edu.pzhu.pojo.UserInfo;

public interface UserInfoService {
	//写入个人信息
	public Msg registInfo(UserInfo userinfo);
	//显示个人信息
	public UserInfo showUserInfo(String username);
	//修改个人信息
	public Msg modUserInfo(UserInfo userInfo);
}
