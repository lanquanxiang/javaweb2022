package cn.edu.pzhu.service.imp;

import java.util.List;

import cn.edu.pzhu.dao.FileMsgDAO;
import cn.edu.pzhu.dao.imp.FileMsgDAOImp;
import cn.edu.pzhu.pojo.FileMsg;
import cn.edu.pzhu.service.FileMsgService;

public class FileMsgServiceImp implements FileMsgService{
	
	private FileMsgDAO dao = new FileMsgDAOImp();

	@Override
	public List<FileMsg> showFileList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FileMsg> showFileList(int page, int num) {
		if(page < 1) {
			page = 1;
		}
		if(num < 1) {
			num = 10;
		}
		
		int pages = (dao.countFiles()-1)/num + 1;		
		if(page > pages) {
			page = pages;
		}
		int start = (page-1)*num;
		return dao.select(start, num);
	}

	@Override
	public StringBuffer createBar(int page, int num) {
		if(page < 1) {
			page = 1;
		}
		if(num < 1) {
			num = 10;
		}
		
		int pages = (dao.countFiles()-1)/num + 1;		
		if(page > pages) {
			page = pages;
		}
		
		StringBuffer bar = new StringBuffer();
		if(page > 1) {
			bar.append("<a href='showlist?page="+(page-1)+"&num="+num+"'>上一页</a>&nbsp;&nbsp;");
		}
		for (int i = 1; i <= pages; i++) {
			if(i==page) {
				bar.append("["+i+"]&nbsp;&nbsp;");
			}else {
				bar.append("<a href='showlist?page="+i+"&num="+num+"'>"+i+"</a>&nbsp;&nbsp;");
			}
		}
		if(page < pages) {
			bar.append("<a href='showlist?page="+(page+1)+"&num="+num+"'>下一页</a>");
		}
		return bar;
	}

}
