package cn.edu.pzhu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.pzhu.pojo.FileMsg;
import cn.edu.pzhu.service.FileMsgService;
import cn.edu.pzhu.service.imp.FileMsgServiceImp;

/**
 * Servlet implementation class ShowFileListServlet
 */
@WebServlet("/showlist")
public class ShowFileListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowFileListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String spage = request.getParameter("page");
		String snum = request.getParameter("num");
		int page = 1, num = 10;
		try {
			page = Integer.parseInt(spage);
		} catch (Exception e) {
			 page = 1;
		}
		try {
			num = Integer.parseInt(snum);
		} catch (Exception e) {
			 num = 10;
		}	
		
		FileMsgService fms = new FileMsgServiceImp();
		List<FileMsg> list=fms.showFileList(page, num); //调用业务层结构实现数据查询
		request.getSession().setAttribute("list", list);
		
		//导航栏
		StringBuffer bar = fms.createBar(page, num);
		request.getSession().setAttribute("bar", bar);
		
		request.getSession().setAttribute("num", num);
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
