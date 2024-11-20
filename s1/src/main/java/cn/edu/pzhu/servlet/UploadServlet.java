package cn.edu.pzhu.servlet;

import java.io.IOException;
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
		Part part = request.getPart("file");
		Result res =  FileUtil.uploadFile(part);
		if(res.isSuccess()) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print("<script>alert('上传成功，文件地址是："+res.getData()+"!');location.href='upload.jsp'</script>");
		}else {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print("<script>alert('上传失败，失败的原因是："+res.getMsg()+"!');location.href='upload.jsp'</script>");
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
