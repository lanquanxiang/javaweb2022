package cn.edu.pzhu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.接收参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");	
		String save = request.getParameter("save");
		
		HttpSession session = request.getSession();
		//2.数据校验	
		if ("".equals(username) || "".equals(password)) {// 文本框没有输入，结果是""
			session.setAttribute("msg", "用户名或密码不能为空");
			session.setAttribute("url", "login.jsp");
			response.sendRedirect("error.jsp");
			return;
		}
		//3.数据封装
		
		String md5password = Conver2MD5.getSHA256(Conver2MD5.getSHA256(username+password)+"pzhu");
		
		User user = new User(username, md5password, 1);//注册的账号默认状态为1，表示可用；状态应该以数据库中的为准
		//4.调用业务层进行业务处理
		UserService us = new UserServiceImp();
		Msg msg = us.login(user);//执行登录
		
		if (msg.isSuccess()) {
			//登录成功
			if(save!=null) { //要保存
				Cookie usernamecookie = new Cookie("username", username);
				usernamecookie.setMaxAge(7*24*60*60);
				response.addCookie(usernamecookie);
				
				Cookie passwordcookie = new Cookie("password", password);
				passwordcookie.setMaxAge(7*24*60*60);
				response.addCookie(passwordcookie);
				
				Cookie savecookie = new Cookie("save", "yes");
				savecookie.setMaxAge(7*24*60*60);
				response.addCookie(savecookie);
				
			}else {//不保存，清除之前的cookie 
				Cookie usernamecookie = new Cookie("username", "");
				usernamecookie.setMaxAge(0);
				response.addCookie(usernamecookie);
				
				Cookie passwordcookie = new Cookie("password", "");
				passwordcookie.setMaxAge(0);
				response.addCookie(passwordcookie);
				
				Cookie savecookie = new Cookie("save", "");
				savecookie.setMaxAge(0);
				response.addCookie(savecookie);
			}
			session.setAttribute("user", user);
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print("<script>alert('登录成功!');location.href='index.jsp'</script>");
		}else {
			//失败
			session.setAttribute("msg", msg.getMessage());//将失败消息保存
			session.setAttribute("url", "login.jsp");
			response.sendRedirect("error.jsp");
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
