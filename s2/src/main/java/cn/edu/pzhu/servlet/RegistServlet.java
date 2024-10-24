package cn.edu.pzhu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); //得到输出流
		
		//2.数据校验
		if("".equals(username)) { //文本框没有输入得到的是空串；Java中字符串不能用==比较
			//保存信息，回到视图
			session.setAttribute("msg", "用户名不能为空！");
			session.setAttribute("url", "regist.jsp");
			response.sendRedirect("error.jsp");
			return;
		}
		if(!"gbcw".equalsIgnoreCase(code)) {
			//保存信息，回到视图
			session.setAttribute("msg", "验证码输入错误！");
			session.setAttribute("url", "regist.jsp");
			response.sendRedirect("error.jsp");
			return;
		}
		if(types==null) {//单选多选一个都没有选，得到的是null；Java中==null
			session.setAttribute("msg", "关注类型必须要选择！");
			session.setAttribute("url", "regist.jsp");
			response.sendRedirect("error.jsp");
			return;
		}
				
		//3.类型转换
		int gender = Integer.parseInt(sex);//将字符串强制转换为int，可能会出现异常，缺少try catch
		String type = JSON.toJSONString(types);//调用阿里巴巴的庫将数组转为JSON
		
		//4.数据封装
		User user = new User(username, password, 1);//1表示账号可以使用
		UserInfo userinfo = new UserInfo(username, email, gender, type);
		//5.初始化业务层接口
		UserService us = new UserServiceImp();
		Msg msg = us.regist(user, userinfo);
		
		//6.处理结果
		if(msg.isSuccess()) {
			out.print("<script>alert('注册成功，请登录!');window.location.href='login.jsp';</script>");
			return;
		}			
		out.print("<script>alert('"+msg.getMessage()+"');window.location.href='regist.jsp';</script>");	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
