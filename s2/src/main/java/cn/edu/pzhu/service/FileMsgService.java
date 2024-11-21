package cn.edu.pzhu.service;

import java.util.List;

import cn.edu.pzhu.pojo.FileMsg;

public interface FileMsgService {
	//显示文件列表
	public List<FileMsg> showFileList();
	//显示第page页，每页显示num条 的数据
	public List<FileMsg> showFileList(int page ,int num);
	//分类查看文件列表
	//模糊查询
	//分享文件
	//删除文件
	//按照用户查找
	//制作导航栏
	public StringBuffer createBar(int page,int num);
}
