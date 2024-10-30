package cn.edu.pzhu.dao.imp;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.edu.pzhu.dao.UserInfoDAO;
import cn.edu.pzhu.pojo.UserInfo;
import cn.edu.pzhu.util.DruidUtil;

public class UserInfoDAOImp implements UserInfoDAO {
	
	private JdbcTemplate template = new JdbcTemplate(DruidUtil.getDataSource());

	@Override
	public int insert(UserInfo t) {
		String sql = "insert into userinfo values(?,?,?,?)";
		return template.update(sql, t.getUsername(),t.getEmail(),t.getGender(),t.getType());
	}

	@Override
	public int update(String key, UserInfo t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserInfo selectById(String key) {
		try {
			return template.queryForObject("select * from userinfo where username=?", new BeanPropertyRowMapper<>(UserInfo.class),key);
		} catch (Exception e) {
			//没有查到任何用户，会抛出异常
			return null;
		}		
	}
	@Test
	public void test() {
		System.out.println(selectById("1"));
	}

	@Override
	public List<UserInfo> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
