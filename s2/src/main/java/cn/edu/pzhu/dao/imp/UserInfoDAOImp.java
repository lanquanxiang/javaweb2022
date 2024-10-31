package cn.edu.pzhu.dao.imp;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.edu.pzhu.dao.UserInfoDAO;
import cn.edu.pzhu.pojo.UserInfo;
import cn.edu.pzhu.util.DruidUtil;

public class UserInfoDAOImp implements UserInfoDAO{

	private JdbcTemplate temp = new JdbcTemplate(DruidUtil.getDataSource());
	
	@Override
	public boolean insert(UserInfo obj) {
		boolean flag = false;
		String sql="insert into userinfo values(?,?,?,?)";
		int n = temp.update(sql,obj.getUsername(),obj.getEmail(),obj.getGender(),obj.getType());
		if (n==1) {
			flag=true;   //return true;
		}
		return flag;  //return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(UserInfo obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserInfo selectById(String id) {
		String sql = "select * from userinfo where username=?";
		try {
			return temp.queryForObject(sql, new BeanPropertyRowMapper<>(UserInfo.class), id);
		} catch (Exception e) {
			e.printStackTrace();
			return null; //查不到数据
		}		
	}

}
