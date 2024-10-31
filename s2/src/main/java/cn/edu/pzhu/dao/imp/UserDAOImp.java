package cn.edu.pzhu.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;

import cn.edu.pzhu.dao.UserDAO;
import cn.edu.pzhu.pojo.User;
import cn.edu.pzhu.util.DruidUtil;
import cn.edu.pzhu.util.JDBCUtil;

public class UserDAOImp implements UserDAO{
	
	private JdbcTemplate temp = new JdbcTemplate(DruidUtil.getDataSource());

	@Override
	public boolean insert(User obj) {
		boolean flag = false;
		String sql="insert into user values(?,?,?)";
		int n = temp.update(sql,obj.getUsername(),obj.getPassword(),obj.getStatus());
		if (n==1) {
			flag=true;   //return true;
		}
		return flag;  //return false;
	}

	@Override
	public boolean delete(String id) {
		String sql="delete from user where username=?";
		int n = temp.update(sql,id);
		if (n==1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(User obj) {
		String sql="update user set password=?,status=? where username=?";
		int n = temp.update(sql,obj.getPassword(),obj.getStatus(),obj.getUsername());
		if (n==1) {
			return true;
		}
		return false;
	}

	@Override
	public User selectById(String id) {
		User user = null;
		//1.注册驱动
		//2.创建连接
		Connection con = JDBCUtil.getConnection();//产生新链接
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
