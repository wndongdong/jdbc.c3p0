package cn.edu.nyist.bookmanv1.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.nyist.bookmanv1.biz.BookBiz;
import cn.edu.nyist.bookmanv1.biz.impl.BookBizImpl;
import cn.edu.nyist.bookmanv1.vo.BookVo;

@WebServlet("/toBookEdit")
@MultipartConfig
public class ToBookEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ToBookEditServlet() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String strId=req.getParameter("id");
		int id=Integer.parseInt(strId);
		
		BookBiz bookBiz=new BookBizImpl();
		BookVo bookVo=bookBiz.selAllBooks(id);
		
		req.setAttribute("bookVo", bookVo);
		req.getRequestDispatcher("bookEdit.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doPost(req, resp);
	}

}
