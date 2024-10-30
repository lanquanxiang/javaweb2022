package cn.edu.pzhu.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	private static DataSource ds = null;
	static {
		ds = new ComboPooledDataSource();
	}
	//提供连接池
	public DataSource getDataSource() {
		return ds;
	}
	//提供链接
	public Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;//没有获得链接
		}
	}
	
	@Test
	public void test() {
		for (int i = 0; i < 11; i++) {
			Connection con = getConnection();
			System.out.println(i+":"+con);
			if(i==5) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
