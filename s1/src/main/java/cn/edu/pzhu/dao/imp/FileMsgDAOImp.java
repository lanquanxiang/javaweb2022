package cn.edu.pzhu.dao.imp;

import java.util.List;import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.edu.pzhu.dao.FileMsgDAO;
import cn.edu.pzhu.pojo.FileMsg;
import cn.edu.pzhu.util.DruidUtil;

public class FileMsgDAOImp implements FileMsgDAO{
	
	private JdbcTemplate template = new JdbcTemplate(DruidUtil.getDataSource());
	
	@Override
	public int insert(FileMsg t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Integer key, FileMsg t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FileMsg selectById(Integer key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FileMsg> selectAll() {
		String sql = "select * from filemsg";
		try {
			return template.query(sql, new BeanPropertyRowMapper<>(FileMsg.class));
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<FileMsg> selectByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
