package cn.edu.pzhu.dao;

import java.util.List;

import cn.edu.pzhu.pojo.FileMsg;

public interface FileMsgDAO extends GenericDAO<FileMsg, Integer> {
	//按照类别查询
	
	//按照分享人查询
	
	//按照关键词查询
	public List<FileMsg> selectByKeyword(String keyword);

}
