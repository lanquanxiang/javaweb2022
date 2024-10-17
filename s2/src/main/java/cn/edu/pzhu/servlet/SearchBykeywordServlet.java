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
 * Servlet implementation class SearchBykeywordServlet
 */
@WebServlet("/searchBykeyword")
public class SearchBykeywordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBykeywordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		if("".equals(keyword)) {
			request.getSession().setAttribute("msg", "关键词不能为空");
			request.getSession().setAttribute("url", "index.jsp");
			request.getSession().setAttribute("list", "");
			response.sendRedirect("error.jsp");
			return;
		}
		request.getSession().setAttribute("keyword", keyword);//让前端的搜索框中显示搜索的关键词
		
		Connection con = null;
		PreparedStatement sta = null;
		ResultSet res = null;
		try {
			
			con = JDBCUtil.getConnection();
			System.out.println(con);
			
			//3.编写SQL语句
			String sql = "SELECT * FROM filemsg WHERE filename LIKE ?";
			
			//4.创建命令
			sta = con.prepareStatement(sql);
			sta.setString(1, "%"+keyword+"%");
			//5.执行查询
			res = sta.executeQuery();
			//6.处理结果（将结果集res映射为集合list）
			List<FileMsg> list = new ArrayList<FileMsg>();
			while(res.next()) {
				int fileid = res.getInt(1);
				String username = res.getString(2);
				String filename = res.getString(3);
				String classification = res.getString(4);
				String filepath = res.getString(5);
				Date releasedate = res.getDate(6);
				Double rating = res.getDouble("rating");
				String description = res.getString(8);				
			
				FileMsg filemsg = new FileMsg(fileid, username, filename, classification, filepath, releasedate, rating, description);
				
				list.add(filemsg);
				
				request.getSession().setAttribute("list", list);
				
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//7.释放资源
			JDBCUtil.close(con, sta, res);
		}

		response.sendRedirect("show.jsp");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
