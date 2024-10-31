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
	private static DataSource ds = null;//定义一个数据库连接池
	static {
		//加载配置文件
				InputStream io = DruidUtil.class.getClassLoader().getResourceAsStream("druid.properties");
				//使用配置文件中的值来初始化四个变量
				Properties pro = new Properties();
				try {
					pro.load(io);
					
					ds = DruidDataSourceFactory.createDataSource(pro);
					
				} catch (IOException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}		
		
	}
	/**
	 * 向外部提供连接池
	 * @return Druid连接池
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
