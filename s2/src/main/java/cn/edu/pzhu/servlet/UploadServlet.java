package cn.edu.pzhu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import cn.pzhuweb.filesys.util.FileUtil;
import cn.pzhuweb.filesys.util.Result;

/**
 * Servlet implementation class UploadServlet
 */
@MultipartConfig
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//上传文件到服务器
		Part file = request.getPart("file");
		Result res = FileUtil.uploadFile(file);

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(res.isSuccess()) {
			//做实验时的时候不要下面这一行
			out.print("<script>alert('上传成功，文件的地址是"+res.getData()+"!');window.location.href='upload.jsp';</script>");
			//将文件信息写入数据库，类似于注册
			//id不需要（自动生成） username来源于登录之后的session 文件名、类别、发布时间、推荐指数、描述来源于前端 文件地址res.getData()
			
		}else {			
			out.print("<script>alert('上传失败，失败的原因是"+res.getMsg()+"!');window.location.href='upload.jsp';</script>");
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
