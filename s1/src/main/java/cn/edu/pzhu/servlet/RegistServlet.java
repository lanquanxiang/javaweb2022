package cn.edu.pzhu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;

import cn.edu.pzhu.pojo.User;
import cn.edu.pzhu.pojo.UserInfo;

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
		//1.接收参数
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String sex=request.getParameter("sex");
		String[] types=request.getParameterValues("type");
		String captcha=request.getParameter("captcha");
		
		HttpSession session =  request.getSession();
		
		
		//2.数据校验
		if(!"gbcw".equalsIgnoreCase(captcha)) {
			//提醒用户名不能为空			
			session.setAttribute("msg", "验证码输入错误");			
			//返回视图View(异常处理建议使用重定向)
			response.sendRedirect("error.jsp");
			return; //流程结束，后续代码不需要再执行...
		}
		if("".equals(username)) {//文本框没有输入，结果是""
			//提醒用户名不能为空			
			session.setAttribute("msg", "用户名不能为空");			
			//返回视图View(异常处理建议使用重定向)
			response.sendRedirect("error.jsp");
			return; //流程结束，后续代码不需要再执行...
		}
		if(types==null) { //复选框没有选择，结果是null
			//提醒用户名不能为空			
			session.setAttribute("msg", "关注类型不能为空");			
			//返回视图View(异常处理建议使用重定向)
			response.sendRedirect("error.jsp");
			return; //流程结束，后续代码不需要再执行...
		}
		
		
		int gender = Integer.parseInt(sex);//强制类型转换，注意异常捕获（不完整）
		String type = JSON.toJSONString(types); //类型转换
		
		
		//3.数据封装
		User user = new User(username,password,1);//默认账号可用，状态为1		
		UserInfo userinfo = new UserInfo(username, email, gender , type);
		//4.调用模型（省略）
		//5.保存信息回到视图
		session.setAttribute("userinfo", userinfo);
		session.setAttribute("user", user);
		
		//6.回到个人信息页面
		response.sendRedirect("userinfo.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
