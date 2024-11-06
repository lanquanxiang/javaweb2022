package cn.edu.pzhu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;

import cn.edu.pzhu.pojo.Msg;
import cn.edu.pzhu.pojo.User;
import cn.edu.pzhu.pojo.UserInfo;
import cn.edu.pzhu.service.UserService;
import cn.edu.pzhu.service.imp.UserServiceImp;
import cn.edu.pzhu.util.Conver2MD5;

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
		//0.重置编码
		
		//1.接收参数
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String sex=request.getParameter("sex");
		String[] types=request.getParameterValues("type");
		String captcha=request.getParameter("captcha");
		
		HttpSession session =  request.getSession();
		if(session.getAttribute("ans") instanceof String ans) {
			if(!ans.equalsIgnoreCase(captcha)) {
				session.setAttribute("msg", "验证码输入错误");		
				session.setAttribute("url", "regist.jsp");
				response.sendRedirect("error.jsp");
				return; //流程结束，后续代码不需要再执行...
			}
		}else {
			session.setAttribute("msg", "验证码初始化失败");		
			session.setAttribute("url", "regist.jsp");
			response.sendRedirect("error.jsp");
			return; //流程结束，后续代码不需要再执行...
		}
		
		
		
		//2.数据校验
		
		if("".equals(username)) {//文本框没有输入，结果是""
			//提醒用户名不能为空			
			session.setAttribute("msg", "用户名不能为空");	
			session.setAttribute("url", "regist.jsp");
			//返回视图View(异常处理建议使用重定向)
			response.sendRedirect("error.jsp");
			return; //流程结束，后续代码不需要再执行...
		}
		if(types==null) { //复选框没有选择，结果是null
			//提醒用户名不能为空			
			session.setAttribute("msg", "关注类型不能为空");	
			session.setAttribute("url", "regist.jsp");
			//返回视图View(异常处理建议使用重定向)
			response.sendRedirect("error.jsp");
			return; //流程结束，后续代码不需要再执行...
		}		
		int gender = Integer.parseInt(sex);//强制类型转换，注意异常捕获（不完整）
		String type = JSON.toJSONString(types); //类型转换
				
		//3.数据封装
		//写入数据库的密码进行加密
		String  md5password = Conver2MD5.getSHA256(Conver2MD5.getSHA256(username+password)+"pzhu");
		
		
		User user = new User(username,md5password,1);//默认账号可用，状态为1		
		UserInfo userinfo = new UserInfo(username, email, gender , type);
		//4.调用模型（省略）
		UserService us = new UserServiceImp();
		Msg msg = us.regist(user, userinfo);
		if (msg.isSuccess()) {
			session.setAttribute("userinfo", userinfo);
			session.setAttribute("user", user);
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print("<script>alert('注册成功，请登录!');location.href='login.jsp'</script>");
		}else {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print("<script>alert('"+msg.getMessage()+"');location.href='login.jsp'</script>");
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
