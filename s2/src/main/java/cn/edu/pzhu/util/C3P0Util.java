package cn.edu.pzhu.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	private static DataSource ds = null;//定义一个数据库连接池
	static {
		ds = new ComboPooledDataSource();//初始化
	}
	/**
	 * 向外部提供连接池
	 * @return C3P0连接池
	 */
	public static DataSource getDataSource() {
		return ds;
	}
	
	/**
	 * 向外部提供连接
	 * @return 如果有连接返回连接，如果没有连接返回null
	 */
	public static Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@Test
	public void test() {
		for (int i = 1; i <= 11; i++) {
			Connection con = getConnection();
			System.out.println(i+":"+con);
			
			if(i==5) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	

}
