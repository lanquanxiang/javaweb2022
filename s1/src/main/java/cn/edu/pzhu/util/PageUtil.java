package cn.edu.pzhu.util;

import java.util.List;

import cn.edu.pzhu.pojo.FileMsg;

public class PageUtil {
	/**
	 * 将一个大的集合分割为小的集合
	 * @param list 大集合
	 * @param page 第page页
	 * @param num 每页显示num条
	 * @return 第page页的n条数据构成的小集合
	 */
	public static List<FileMsg> splitList(List<FileMsg> list,int page,int num){
		//数据的合法性和完整性校验
		if(list==null || list.size()==0) {
			return null;
		}
		//限制显示条数的下限
		if(num<=0) {
			num = 10;
		}
		//显示第几页的下限
		if(page<1) {
			page = 1;
		}
		int pages = (list.size()-1)/num + 1;
		if(page > pages) {
			page = pages;
		}
		
		List<FileMsg> pageList = list.subList((page-1)*num, Math.min(page*num, list.size()));
		return pageList;
	}

	public static StringBuffer createBar(List<FileMsg> list, int page, int num) {
		// 数据的合法性和完整性校验
		if (list == null || list.size() == 0) {
			return null;
		}
		// 限制显示条数的下限
		if (num <= 0) {
			num = 10;
		}
		// 显示第几页的下限
		if (page < 1) {
			page = 1;
		}
		int pages = (list.size() - 1) / num + 1;
		if (page > pages) {
			page = pages;
		}
		// 生成导航栏
		StringBuffer bar = new StringBuffer();
		if(page>1) {
			bar.append("<a href='showlist?page="+(page-1)+"&num="+num+"'>上一页</a>&nbsp;&nbsp;");
		}
		for (int i = 1; i <= pages; i++) {
			if(i==page) {
				bar.append("["+i+"]&nbsp;&nbsp;");
			}else {
				bar.append("<a href='showlist?page="+i+"&num="+num+"'>"+i+"</a>&nbsp;&nbsp;");
			}
		}
		if(page<pages) {
			bar.append("<a href='showlist?page="+(page+1)+"&num="+num+"'>下一页</a> ");
		}
		return bar;
	}
}
