package cn.edu.pzhu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.pzhu.pojo.Msg;
import cn.edu.pzhu.service.UserService;
import cn.edu.pzhu.service.imp.UserServiceImp;
import cn.edu.pzhu.util.Conver2MD5;

/**
 * Servlet implementation class SendEmailServlet
 */
@WebServlet("/sendemail")
public class SendEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendEmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("name");
		String email=request.getParameter("email");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//对接收到的数据进行合法性和完整性校验
		if (username==null||email==null||"".equals(username)||"".equals(email)) {
			out.print("账号或邮箱不完整");
			return;
		}
		UserService userService = new UserServiceImp();
		Msg msg = userService.sendemail(username, email);
		if (msg.isSuccess()) {
			//提示成功同时生成登录口令
			out.print("邮件发送成功");
			String token = Conver2MD5.getSHA256(username)+Conver2MD5.getSHA256(email)+Conver2MD5.getSHA256(msg.getMessage());
			request.getSession().setAttribute("token", token);
		}else {
			//提示失败
			out.print(msg.getMessage());
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
