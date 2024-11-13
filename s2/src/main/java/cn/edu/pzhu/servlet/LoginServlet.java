package cn.edu.pzhu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import cn.edu.pzhu.pojo.Msg;
import cn.edu.pzhu.pojo.User;
import cn.edu.pzhu.service.UserService;
import cn.edu.pzhu.service.imp.UserServiceImp;
import cn.edu.pzhu.util.Conver2MD5;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.接收数据
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		HttpSession session = request.getSession();//通过request得到session存储对象		
		response.setContentType("text/html;charset=utf-8");		
		PrintWriter out = response.getWriter(); //得到输出流
		//2.数据校验
		if("".equals(username)||"".equals(password)) { //文本框没有输入得到的是空串；Java中字符串不能用==比较
			//保存信息，回到视图
			session.setAttribute("msg", "用户名或密码不能为空！");
			session.setAttribute("url", "login.jsp");
			response.sendRedirect("error.jsp");
			return;
		}
		//3.数据封装
		String maskpassword = Conver2MD5.getSHA256(Conver2MD5.getSHA256(username+password)+"pzhu");
		
		User user = new User(username, maskpassword, null);//第三个值表示账号的状态，状态以数据库中的为准，这个值是什么没有影响
		//4.调用业务层进行数据处理
		UserService us = new UserServiceImp();//初始化业务层接口（实现类来new）
		Msg msg = us.login(user);
		//5.结果处理
		if(msg.isSuccess()) {
			//成功
			session.setAttribute("user", user);//6.将信息存入session，表示登录成功；方面后续读取用户信息
			out.print("<script>alert('登录成功!');window.location.href='index.jsp';</script>");
		}else {
		    //失败
			session.setAttribute("msg", msg.getMessage());
			session.setAttribute("url", "login.jsp");
			response.sendRedirect("error.jsp");
			return;
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
