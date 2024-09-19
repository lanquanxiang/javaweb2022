package cn.edu.pzhu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/regist")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.接受数据
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String sex=request.getParameter("sex");
		String [] types=request.getParameterValues("type");
		String code=request.getParameter("captcha");
		
		HttpSession session = request.getSession();//通过request得到session存储对象
		
		//2.数据校验
		if("".equals(username)) { //文本框没有输入得到的是空串；Java中字符串不能用==比较
			//保存信息，回到视图
			session.setAttribute("msg", "用户名不能为空！");
			response.sendRedirect("error.jsp");
			return;
		}
		if(!"gbcw".equalsIgnoreCase(code)) {
			//保存信息，回到视图
			session.setAttribute("msg", "验证码输入错误！");
			response.sendRedirect("error.jsp");
			return;
		}
		if(types==null) {//单选多选一个都没有选，得到的是null；Java中==null
			session.setAttribute("msg", "关注类型必须要选择！");
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