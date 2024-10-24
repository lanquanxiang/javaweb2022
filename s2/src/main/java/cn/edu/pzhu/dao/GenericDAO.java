package cn.edu.pzhu.dao;

public interface GenericDAO<T,K> {
	//定义所有表的通用操作
	//增加:泛型 List<E>  T表示的是任意类型 User、Stu、... K表示的是主键的类型String Integer
	public boolean insert(T obj);
	//删除
	public boolean delete(K id);
	//修改
	public boolean update(T obj);
	//查询
	public T selectById(K id);
	//其他的查询方法可以在子接口中自行扩展

}
