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
		InputStream in = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
		Properties pro = new Properties();
		try {
			pro.load(in);
			
			driver = pro.getProperty("driver");
			url = pro.getProperty("url");
			user = pro.getProperty("user");
			password = pro.getProperty("password");
			//1.自动进行驱动注册
			Class.forName(driver);
			
		} catch (IOException e) {			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//2.为开发人员提供快捷的连接获取方法
	public static Connection getConnection() {
		Connection con  = null;
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return con;
	}
	//3.提供一个通用的资源释放方法（结果集/没有--静态命令/动态命令--连接/null）
	public static void close(Connection con,Statement sta) {
		close(con, sta, null);
	}
	public static void close(Connection con,PreparedStatement sta) {
		close(con, (Statement)sta, null);
	}
	public static void close(Connection con,Statement sta,ResultSet res) {
		if (res!=null) {
			try {
				res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (sta!=null) {
			try {
				sta.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(Connection con,PreparedStatement sta,ResultSet res) {
		close(con, (Statement)sta, res);
	}
	

}
