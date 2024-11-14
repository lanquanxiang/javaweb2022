package cn.edu.pzhu.service.imp;

import cn.edu.pzhu.dao.UserDAO;
import cn.edu.pzhu.dao.UserInfoDAO;
import cn.edu.pzhu.dao.imp.UserDAOImp;
import cn.edu.pzhu.dao.imp.UserInfoDAOImp;
import cn.edu.pzhu.pojo.Msg;
import cn.edu.pzhu.pojo.User;
import cn.edu.pzhu.pojo.UserInfo;
import cn.edu.pzhu.service.UserService;
import cn.edu.pzhu.util.EmailUtil;

public class UserServiceImp implements UserService {
	
	//初始化持久层
	private UserDAO userdao = new UserDAOImp();
	private UserInfoDAO userinfodao = new UserInfoDAOImp();
	
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
		if(user==null || userinfo==null) {
			return new Msg(false, "注册失败，注册信息异常!");
		}
		User dbUser = userdao.selectById(user.getUsername());
		if (dbUser!=null) {
			return new Msg(false, "此用户已经被注册!");
		}
		if(userdao.insert(user) && userinfodao.insert(userinfo)) {
			return new Msg(true, "注册成功!");
		}else {
			return new Msg(false, "数据库操作异常，注册失败!");
		}
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

	@Override
	public boolean checkusername(String username) {
		User dbuser=userdao.selectById(username);
		if(dbuser!=null) {
			return false;
		}
		return true;
	}

	@Override
	public Msg sendemail(String username, String email) {
		//完整性和合法性校验
		User user= userdao.selectById(username);
		if(user==null) {
			return new Msg(false, "用户不存在");
		}
		if(user.getStatus()==0) {
			return new Msg(false, "用户已经注销");
		}
		UserInfo userInfo= userinfodao.selectById(username);
		if(userInfo==null) {
			return new Msg(false, "用户信息异常");
		}
		if(!userInfo.getEmail().equals(email)) {
			return new Msg(false, "邮箱与注册信息不匹配");
		}
		
		return EmailUtil.sendemail(email);//调用工具类发送邮件
	}

}
