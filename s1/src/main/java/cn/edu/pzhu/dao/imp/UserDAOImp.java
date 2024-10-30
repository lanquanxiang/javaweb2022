package cn.edu.pzhu.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.edu.pzhu.dao.UserDAO;
import cn.edu.pzhu.pojo.User;
import cn.edu.pzhu.util.DruidUtil;
import cn.edu.pzhu.util.JDBCUtil;

public class UserDAOImp implements UserDAO {
	
	private JdbcTemplate template = new JdbcTemplate(DruidUtil.getDataSource());

	@Override
	public int insert(User t) {
		int n = 0;
		Connection con = JDBCUtil.getConnection();
		String sql="insert into user values(?,?,?)";
		PreparedStatement sta = null;
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1, t.getUsername());
			sta.setString(2, t.getPassword());
			sta.setInt(3, t.getStatus());
			n = sta.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, sta);
		}
		return n;
	}

	@Override
	public int update(String key, User t) {
		String sql = "update user set password=?,status=? where username=?";
		return template.update(sql, t.getPassword(),t.getStatus(),key);
	}
	
	@Test
	public void test() {
		String key = "1";
		User user = new User("1", "123456", 1);
		System.out.println(update(key, user));
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
		List<User> list = null;
		String sql = "select * from user";
		try {
			list = template.query(sql, new BeanPropertyRowMapper<>(User.class));
		} catch (Exception e) {
			//没有查到任何用户，会抛出异常
		}		
		return list;
	}

}
