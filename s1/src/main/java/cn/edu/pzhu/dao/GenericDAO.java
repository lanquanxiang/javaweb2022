package cn.edu.pzhu.dao;

import java.io.Serializable;
import java.util.List;

//公共的持久层接口：约束所有的持久层接口行为
public interface GenericDAO<T, K extends Serializable> {
	//增加
	public int insert(T t); 
	//删除（可以有也可以没有）有：所有子接口都会有，user中空白方法；没有：filemsg在子接口中单独增加
	//修改
	public int update(K key,T t);
	//查询
	public T selectById(K key);
	//查询所有信息
	public List<T> selectAll();
	
}
