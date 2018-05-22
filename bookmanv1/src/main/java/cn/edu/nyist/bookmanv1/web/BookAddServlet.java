package cn.edu.nyist.bookmanv1.web;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import cn.edu.nyist.bookmanv1.biz.BookBiz;
import cn.edu.nyist.bookmanv1.biz.impl.BookBizImpl;
import cn.edu.nyist.bookmanv1.util.MyBeanUtils;
import cn.edu.nyist.bookmanv1.vo.BookVo;

@WebServlet("/bookAdd")
@MultipartConfig
public class BookAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BookAddServlet() {
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
				String fileName=part.getHeader("Content-Disposition").split(";")[2].split("=")[1].replace("\"", "");
				fileName = fileName.lastIndexOf("\\") == -1 ? fileName : fileName.substring(fileName.lastIndexOf("\\") + 1);
				String ext = fileName.substring(fileName.lastIndexOf('.') + 1);
				String newFileName = UUID.randomUUID().toString() + "." + ext;
				System.out.println(newFileName);
				part.write(request.getServletContext().getRealPath("upload/" + newFileName));
	
				//添加验证
				String vcode=request.getParameter("vcode");
				HttpSession session = request.getSession();
				String serverVcode=(String) session.getAttribute("validateCode");
				//2.连接数据库比对
				if(!serverVcode.equalsIgnoreCase(vcode)) {
					//如果不同则不用进行下面步骤
					response.setContentType("text/html;charset=utf-8");
					
					request.getRequestDispatcher("bookdata.jsp").forward(request, response);
				}
				/*			
				String name=request.getParameter("name");
				String descri=request.getParameter("descri");
				String author=request.getParameter("author");
				String strtid=request.getParameter("type");
				int tid=Integer.parseInt(strtid);
				String pd=request.getParameter("pubDate");
				//先进行此种转换
				//Date pubDate=java.sql.Date.parse(pd);//这样不行，因为后面的parse()方法返回值类型是long
				double price=Double.parseDouble(request.getParameter("price"));
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//这里的月份为与分钟区分，所以用大写M
				Date pubDate = null;
				try {
					pubDate=sdf.parse(pd);
				} catch (ParseException e) {
					e.printStackTrace();
				}*/
				System.out.println(request.getParameter("name"));//TODO
				BookVo bookVo=new BookVo();
				MyBeanUtils.populate(bookVo,request.getParameterMap(),"yyyy-MM-dd");
				System.out.println(bookVo.getTid());
				bookVo.setPhoto(newFileName);
				//2.连接数据库，添加书籍
				BookBiz badb=new BookBizImpl();
				int ret = badb.getAdd(bookVo);
				//根据返回的结果，进行服务器对客户端的响应
				if(ret>0) {
					response.sendRedirect("main.jsp");
				}else {
					request.getRequestDispatcher("bookList").forward(request, response);
				}
	}

}
