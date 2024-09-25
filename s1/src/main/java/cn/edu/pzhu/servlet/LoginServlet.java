package cn.edu.pzhu.servlet;

import java.io.IOException;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 0.重置编码
		request.setCharacterEncoding("utf-8");
		// 1.接收参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");		

		HttpSession session = request.getSession();
		// 2.数据校验		
		if ("".equals(username) || "".equals(password)) {// 文本框没有输入，结果是""
			session.setAttribute("msg", "用户名或密码不能为空");
			session.setAttribute("url", "login.jsp");
			response.sendRedirect("error.jsp");
			return;
		}		
		// 检查是否已经被注册
		ServletContext application = request.getServletContext();
		Object o = application.getAttribute("user" + username);
		if (o == null) {
			session.setAttribute("msg", "此用户不存在，请先注册再登录");
			session.setAttribute("url", "regist.jsp");
			response.sendRedirect("error.jsp");
			return;
		}		
		if (o instanceof User dbuser) {			
			if (!dbuser.getPassword().equals(password)) {
				session.setAttribute("msg", "密码输入错误，请重新登录");
				session.setAttribute("url", "login.jsp");
				response.sendRedirect("error.jsp");
				return;
			}			
		}		
		//到这里表示登录成功，然后将用户数据（user、userinfo）保存到session【1.方便之后使用；2.可以根据session中是否有数据，判断是否登录了】
		session.setAttribute("userinfo", application.getAttribute("userinfo"+username));
		session.setAttribute("user", o);	

		// 6.回到个人信息页面		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print("<script>alert('登录成功，请登录!');location.href='index.jsp'</script>");

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
