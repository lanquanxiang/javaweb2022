package cn.edu.pzhu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.pzhu.pojo.User;
import cn.edu.pzhu.util.Conver2MD5;

/**
 * Servlet implementation class LoginEmailServlet
 */
@WebServlet("/loginemail")
public class LoginEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginEmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String code=request.getParameter("code");
		//请对上面的数据进行完整性校验
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if (username==null||email==null||code==null||"".equals(username)||"".equals(code)||"".equals(email)) {
			out.print("<script>alert('信息不完整!');window.location.href='loginemail.jsp';</script>");
			return;	
		}
		Object object=request.getSession().getAttribute("token");
		if (object==null) {
			out.print("<script>alert('请先发送验证码!');window.location.href='loginemail.jsp';</script>");
			return;	
		}
		String token=(String)object;
		String answer= Conver2MD5.getSHA256(username)+Conver2MD5.getSHA256(email)+Conver2MD5.getSHA256(code);
		if (token.equals(answer)) {
			//登录成功
			request.getSession().setAttribute("user", new User(username, answer, 1));//6.将信息存入session，表示登录成功；方面后续读取用户信息
			out.print("<script>alert('登录成功!');window.location.href='index.jsp';</script>");
		}
		else {
			out.print("<script>alert('登录失败!');window.location.href='loginemail.jsp';</script>");
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
