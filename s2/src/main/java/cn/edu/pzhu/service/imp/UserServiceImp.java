package cn.edu.pzhu.service.imp;

import cn.edu.pzhu.dao.UserDAO;
import cn.edu.pzhu.dao.imp.UserDAOImp;
import cn.edu.pzhu.pojo.Msg;
import cn.edu.pzhu.pojo.User;
import cn.edu.pzhu.pojo.UserInfo;
import cn.edu.pzhu.service.UserService;

public class UserServiceImp implements UserService {
	
	//初始化持久层
	private UserDAO userdao = new UserDAOImp();
	
	@Override
	public Msg login(User user) {
		if(user==null) {
			return new Msg(false, "用户信息异常!");
		}
		User dbUser = userdao.selectById(user.getUsername());
		if (dbUser==null) {
			return new Msg(false, "此用户不存在!");
		}
		if(dbUser.getStatus()==0) {
			return new Msg(false, "此用户账户已经被注销!");
		}
		if(!dbUser.getPassword().equals(user.getPassword())) {
			return new Msg(false, "用户密码错误!");
		}
		return new Msg(true, "登录成功!");
	}

	@Override
	public Msg regist(User user, UserInfo userinfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Msg destory(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo showUserInfo(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
