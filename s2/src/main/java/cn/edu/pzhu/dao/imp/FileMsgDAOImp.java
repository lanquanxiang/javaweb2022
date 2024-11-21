package cn.edu.pzhu.dao.imp;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.edu.pzhu.dao.FileMsgDAO;
import cn.edu.pzhu.pojo.FileMsg;
import cn.edu.pzhu.util.DruidUtil;

public class FileMsgDAOImp implements FileMsgDAO{

	private JdbcTemplate temp = new JdbcTemplate(DruidUtil.getDataSource());
	@Override
	public boolean insert(FileMsg obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(FileMsg obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FileMsg selectById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FileMsg> selectAll() {
		String sql = "select * from filemsg";
		try {
			return temp.query(sql, new BeanPropertyRowMapper<>(FileMsg.class));
		} catch (Exception e) {
			e.printStackTrace();
			return null; //查不到数据
		}	
	}

	@Override
	public List<FileMsg> selectByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FileMsg> selectByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FileMsg> selectByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countFiles() {
		String sql = "select count(*) from filemsg";
		return temp.queryForObject(sql, Integer.class);
	}
	@Test
	public void test() {
		System.out.println(countFiles());
	}

	@Override
	public List<FileMsg> select(int start, int length) {
		String sql = "select * from filemsg limit ?,?";
		try {
			return temp.query(sql, new BeanPropertyRowMapper<>(FileMsg.class),start,length);
		} catch (Exception e) {
			e.printStackTrace();
			return null; //查不到数据
		}	
	}

}
