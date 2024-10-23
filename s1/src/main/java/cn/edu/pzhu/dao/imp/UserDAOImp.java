package cn.edu.pzhu.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.edu.pzhu.dao.UserDAO;
import cn.edu.pzhu.pojo.User;
import cn.edu.pzhu.util.JDBCUtil;

public class UserDAOImp implements UserDAO {

	@Override
	public int insert(User t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String key, User t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User selectById(String key) {
		User user = null;		
		//1.注册驱动（JDBCUtil提供）
		//2.创建连接
		Connection con = JDBCUtil.getConnection();
		//3.编写SQL语句
		String sql = "select * from user where username=?";
		//4.创建预编译的命令对象
		PreparedStatement sta = null;
		ResultSet res = null;
		try {
			sta = con.prepareStatement(sql);
			//为问号赋值
			sta.setString(1, key);//为1这个问号赋值一个字符串key
			//5.执行
			res = sta.executeQuery();
			//6.处理结果集
			if(res.next()) {
				//找到了一条数据
				user = new User(res.getString(1), res.getString(2), res.getInt(3));				
			}			
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {
			//7.释放资源
			JDBCUtil.close(con, sta, res);
		}
		return user;
	}

	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
