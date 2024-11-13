package cn.edu.pzhu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.pzhu.pojo.Msg;
import cn.edu.pzhu.service.UserInfoService;
import cn.edu.pzhu.service.imp.UserInfoServiceImp;
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
		String username = request.getParameter("name");
		String email = request.getParameter("email");
		
		response.setContentType("text/html;charset=utf-8");		
		if(username==null || "".equals(username) || email==null || "".equals(email)) {
			response.getWriter().print("账号和邮箱信息不完整！");
			return;
		}
		//合法性校验
		UserInfoService uis = new UserInfoServiceImp();
		Msg msg = uis.sendEmail(username, email);
		if (msg.isSuccess()) {
			//保存正确的验证码，然后提示发送成功
			String ans = Conver2MD5.getSHA256(username)+Conver2MD5.getSHA256(email)+Conver2MD5.getSHA256(msg.getMessage());
			request.getSession().setAttribute("ans", ans);
			response.getWriter().print("邮件已发送！");
		} else {
			//提示错误消息
			response.getWriter().print(msg.getMessage());
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
