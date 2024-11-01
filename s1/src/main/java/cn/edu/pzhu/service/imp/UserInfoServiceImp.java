package cn.edu.pzhu.service.imp;

import cn.edu.pzhu.dao.UserInfoDAO;
import cn.edu.pzhu.dao.imp.UserInfoDAOImp;
import cn.edu.pzhu.pojo.Msg;
import cn.edu.pzhu.pojo.UserInfo;
import cn.edu.pzhu.service.UserInfoService;

public class UserInfoServiceImp implements UserInfoService{

	private UserInfoDAO dao=new UserInfoDAOImp();
	@Override
	public Msg registInfo(UserInfo userinfo) {
		int n=dao.insert(userinfo);
		if(n>0) {
			return new Msg(true, "注册成功!");
		}
		return new Msg(false,"个人信息写入失败!");
	}

	@Override
	public UserInfo showUserInfo(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Msg modUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
