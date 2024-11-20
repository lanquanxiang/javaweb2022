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
import cn.edu.pzhu.util.PageUtil;

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
			String page = request.getParameter("page");
			String num = request.getParameter("num");
			int p = 1, n = 10;
			if(page!=null) { //"-1"
				try {
					p = Integer.parseInt(page);
				} catch (Exception e) {
					p = 1;
				}
			}
			if(num!=null) {
				try {
					n = Integer.parseInt(num);
				} catch (Exception e) {
					n = 10;
				}
			}
			FileMsgService fms=new FileMsgServiceImp();
			List<FileMsg> list = fms.showfilelist();//调用接口查询所有文件
			List<FileMsg> pageList=PageUtil.splitList(list, p, n);//调用工具类切分列表
			request.getSession().setAttribute("list", pageList);
			
			//导航栏
			StringBuffer bar = PageUtil.createBar(list, p, n);;
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
