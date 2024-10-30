package cn.edu.pzhu.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DruidUtil {
private static DataSource ds = null;
	
	static {
		InputStream in = DruidUtil.class.getClassLoader().getResourceAsStream("druid.properties");
		Properties pro = new Properties();
		try {
			pro.load(in);
			ds = DruidDataSourceFactory.createDataSource(pro);
		} catch (IOException e) {			
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
