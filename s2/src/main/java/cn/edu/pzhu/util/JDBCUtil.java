package cn.edu.pzhu.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
	private static String driver = null;
	private static String url = null;
	private static String user = null;
	private static String password = null;
	
	static {
		//加载配置文件
		InputStream io = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
		//使用配置文件中的值来初始化四个变量
		Properties pro = new Properties();
		try {
			pro.load(io);
			
			driver = pro.getProperty("driver");
			url = pro.getProperty("url");			
			user = pro.getProperty("user");
			password = pro.getProperty("password");
			
			//注册驱动			
			Class.forName(driver);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void close(Connection con,Statement sta,ResultSet res) {
		if(res!=null) {
			try {
				res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(sta!=null) {
			try {
				sta.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(Connection con,Statement sta) {
		close(con, sta, null);
	}
	public static void close(Connection con,PreparedStatement sta,ResultSet res) {
		close(con, (Statement)sta, res);
	}
	public static void close(Connection con,PreparedStatement sta) {
		close(con, (Statement)sta, null);
	}
	

}
