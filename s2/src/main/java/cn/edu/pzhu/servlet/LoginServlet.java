package cn.edu.pzhu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import cn.edu.pzhu.pojo.User;

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

		//0.处理编码
		request.setCharacterEncoding("utf-8");//防止POST乱码
		
		//1.接受数据
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
				
		//检测账号是否已经被注册
		ServletContext application = request.getServletContext();
		
		Object object = application.getAttribute("user"+username);
		if(object==null) {
			session.setAttribute("msg", "此用户还没有被注册，请先注册！");
			session.setAttribute("url", "regist.jsp");
			response.sendRedirect("error.jsp");
			return;
		}
		
		if(object instanceof User dbUser) {
			if(!dbUser.getPassword().equals(password)) {
				session.setAttribute("msg", "密码输入错误！");
				session.setAttribute("url", "login.jsp");
				response.sendRedirect("error.jsp");
				return;
			}
			//6.将信息存入session，表示登录成功；方面后续读取用户信息
			session.setAttribute("user", dbUser);
			session.setAttribute("userinfo", application.getAttribute("userinfo"+username));
		}
				
		out.print("<script>alert('登录成功!');window.location.href='userinfo.jsp';</script>");
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
