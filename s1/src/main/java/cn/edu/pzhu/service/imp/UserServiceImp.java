package cn.edu.pzhu.service.imp;

import cn.edu.pzhu.dao.UserDAO;
import cn.edu.pzhu.dao.imp.UserDAOImp;
import cn.edu.pzhu.pojo.Msg;
import cn.edu.pzhu.pojo.User;
import cn.edu.pzhu.pojo.UserInfo;
import cn.edu.pzhu.service.UserService;

public class UserServiceImp implements UserService{
	//初始化操作user的持久层
	private UserDAO dao = new UserDAOImp();

	@Override
	public Msg login(User user) {
		//数据验证（省略）
		if(user ==null) {
			return new Msg(false, "用户信息异常！");		
		}
		//业务操作
		User dbuser = dao.selectById(user.getUsername());
		if(dbuser==null) {
			return new Msg(false, "账号不存在！");	
		}
		if(dbuser.getStatus()==0) {
			return new Msg(false, "账号已经注销！");	
		}
		if(!user.getPassword().equals(dbuser.getPassword())) {
			return new Msg(false, "密码错误！");	
		}
		return new Msg(true, "登录成功！");
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

}
