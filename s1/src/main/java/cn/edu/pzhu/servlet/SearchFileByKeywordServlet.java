package cn.edu.pzhu.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.pzhu.pojo.FileMsg;
import cn.edu.pzhu.util.JDBCUtil;

/**
 * Servlet implementation class SearchFileByKeywordServlet
 */
@WebServlet("/searchFileByKeyword")
public class SearchFileByKeywordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFileByKeywordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		
		request.getSession().setAttribute("keyword", keyword);
		//2.建立和数据库的链接（数据库地址、数据库的用户名和密码--安装的时候配置）
				Connection con = JDBCUtil.getConnection();
				//3.编写SQL
				String sql = "SELECT * FROM filemsg WHERE filename LIKE ?";
				
				try {
					//4.创建命令
					PreparedStatement sta = con.prepareStatement(sql);
					sta.setString(1, "%"+keyword+"%");
					//5.执行SQL
					ResultSet res = sta.executeQuery();
					//6.遍历结果集（映射为Java中的集合）	
					List<FileMsg> list = new ArrayList<>();
					while(res.next()) {
						int fileid = res.getInt(1);
						String username = res.getString(2);
						String filename = res.getString(3);
						String classification = res.getString(4);
						String filepath = res.getString(5);
						Date relesaedate = res.getDate(6);
						Double rating = res.getDouble("rating");
						String description = res.getString(8);
						FileMsg file = new FileMsg(fileid, username, filename, classification, filepath, relesaedate, rating, description);
						list.add(file);						
					}
					//7.释放资源 结果集--命令对象--连接
					JDBCUtil.close(con, sta, res);
					request.getSession().setAttribute("list", list);
					response.sendRedirect("show.jsp");	
				} catch (SQLException e) {
					e.printStackTrace();
				}	

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
