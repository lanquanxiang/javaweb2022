package cn.edu.pzhu.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.pzhu.dao.UserDAO;
import cn.edu.pzhu.pojo.User;
import cn.edu.pzhu.util.JDBCUtil;

public class UserDAOImp implements UserDAO{

	@Override
	public boolean insert(User obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User selectById(String id) {
		User user = null;
		//1.注册驱动
		//2.创建连接
		Connection con = JDBCUtil.getConnection();
		PreparedStatement sta = null;
		ResultSet res = null;
		
		//3.编写SQL
		String sql = "select * from user where username=?";
		//4.初始化命令
		try {
			sta = con.prepareStatement(sql);
			//为问号赋值
			sta.setString(1, id);//为SQL中的第1个问号赋（字符串类型的）值，值是上层传来的id
			//5.执行命令
			res = sta.executeQuery();
			//6.处理结果集
			if(res.next()) {
				//查到数据
				user = new User(res.getString(1), res.getString(2), res.getInt(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, sta, res);
		}
		
		
		return user;
	}

}
