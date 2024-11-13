package cn.edu.pzhu.servlet;

import java.io.IOException;
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
		String username =  request.getParameter("username");
		String email = request.getParameter("email");
		String code = request.getParameter("code");
		//完整性（是否null是否为空）
		String userAns = Conver2MD5.getSHA256(username)+Conver2MD5.getSHA256(email)+Conver2MD5.getSHA256(code);
		Object o = request.getSession().getAttribute("ans");//强制类型转换存在隐患，参考验证码
		response.setContentType("text/html;charset=utf-8");
		if(o==null) {
			response.getWriter().print("<script>alert('请先获取验证码再登录!');location.href='emaillogin.jsp'</script>");
			return;
		}
		String ans = (String)o;
		if(ans.equals(userAns)) {
			//销毁验证码
			request.getSession().setAttribute("user", new User(username,"",1));//如果需要密码，需要重新查询数据库
			response.getWriter().print("<script>alert('登录成功!');location.href='index.jsp'</script>");
		}else {
			response.getWriter().print("<script>alert('信息不正确，重新登录!');location.href='emaillogin.jsp'</script>");
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
