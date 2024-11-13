package cn.edu.pzhu.service.imp;

import java.util.List;

import cn.edu.pzhu.dao.FileMsgDAO;
import cn.edu.pzhu.dao.imp.FileMsgDAOImp;
import cn.edu.pzhu.pojo.FileMsg;
import cn.edu.pzhu.service.FileMsgService;

public class FileMsgServiceImp implements FileMsgService{
	
	private FileMsgDAO dao = new FileMsgDAOImp();
	
	@Override
	public List<FileMsg> showfilelist() {		
		return dao.selectAll();
	}
	
}
