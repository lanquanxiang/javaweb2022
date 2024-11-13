package cn.edu.pzhu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.pzhu.service.UserService;
import cn.edu.pzhu.service.imp.UserServiceImp;

/**
 * Servlet implementation class CheckUsernameServlet
 */
@WebServlet("/checkusername")
public class CheckUsernameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUsernameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("name");
		//合法性和完整性校验 null  ""
		//M处理数据
		UserService us = new UserServiceImp();//初始化业务层接口（实现类来new）
		response.setContentType("text/html; charset=UTF-8");	
		PrintWriter out = response.getWriter(); //得到输出流
		if(us.checkusername(username)) {
			out.print("恭喜此用户名可用！");
		}else {
			out.print("此用户名已经被占用！");
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
