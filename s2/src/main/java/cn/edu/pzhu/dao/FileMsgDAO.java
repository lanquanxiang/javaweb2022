package cn.edu.pzhu.dao;

import java.util.List;

import cn.edu.pzhu.pojo.FileMsg;

public interface FileMsgDAO extends GenericDAO<FileMsg, Integer>{
	//查询所有
	public List<FileMsg> selectAll();
	//分类查看
	public List<FileMsg> selectByType(String type);
	//模糊查询
	public List<FileMsg> selectByKeyword(String keyword);
	//按照分享人进行查询
	public List<FileMsg> selectByUsername(String username); 
}