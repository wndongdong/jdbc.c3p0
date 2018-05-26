package cn.edu.nyist.bookmanv1.web;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import cn.edu.nyist.bookmanv1.biz.BookBiz;
import cn.edu.nyist.bookmanv1.biz.impl.BookBizImpl;
import cn.edu.nyist.bookmanv1.util.MyBeanUtils;
import cn.edu.nyist.bookmanv1.vo.BookVo;

@WebServlet("/doBookEdit")
@MultipartConfig
public class DoBookEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DoBookEditServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 若要进行操作，则需要先判定的登录是否成功，若成功了才能继续，若不成功，则返回到登录界面
		 * 	
		 */
			
			
		//1.获取输入的内容
				//获取图片，图片既是文件，即要上传文件
					//(1)文件内容上传时编码问题
				request.setCharacterEncoding("utf-8");
				Part part=request.getPart("photo");
				System.out.println("---------------************************------------------"+part);
				String fileName=part.getHeader("Content-Disposition").split(";")[2].split("=")[1].replace("\"", "");
				String newFileName=null;
				if(!fileName.equals("")) {
					fileName = fileName.lastIndexOf("\\") == -1 ? fileName : fileName.substring(fileName.lastIndexOf("\\") + 1);
					String ext = fileName.substring(fileName.lastIndexOf('.') + 1);
					newFileName = UUID.randomUUID().toString() + "." + ext;
					System.out.println(newFileName);
					part.write(request.getServletContext().getRealPath("upload/" + newFileName));
				}
				
				System.out.println(request.getParameter("name"));
				BookVo bookVo=new BookVo();
				MyBeanUtils.populate(bookVo,request.getParameterMap(),"yyyy-MM-dd");
				System.out.println(bookVo.getTid());
				if(!fileName.equals("")) {
					bookVo.setPhoto(newFileName);
				}
				System.out.println("**************************************************************************"+bookVo.getId());
				//2.连接数据库，添加书籍
				BookBiz badb=new BookBizImpl();
				int ret = badb.getEditBook(bookVo);
				//根据返回的结果，进行服务器对客户端的响应
				System.out.println("**************************************************************************"+ret);
				if(ret>0) {
					response.sendRedirect("bookList");
				}else {
					request.setAttribute("bookVo", bookVo);
					request.getRequestDispatcher("bookEdit.jsp").forward(request, response);
				}
	}

}
