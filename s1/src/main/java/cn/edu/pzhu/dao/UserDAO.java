package cn.edu.pzhu.dao;

import cn.edu.pzhu.pojo.User;

public interface UserDAO extends GenericDAO<User, String>{
	//公共接口的方法已经能够满足用户模块的需求，所以不需要扩展接口方法
	//扩展删除方法，防止注册失败的时候产生脏数据

}
