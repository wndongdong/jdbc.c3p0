package cn.edu.nyist.bookmanv1.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.nyist.bookmanv1.biz.BookBiz;
import cn.edu.nyist.bookmanv1.biz.impl.BookBizImpl;


@WebServlet("/bookDel")
public class BookDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public BookDelServlet() {
        super();
       
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String strId=request.getParameter("id");
		int id = -1;
		try {
			id = Integer.parseInt(strId);
		} catch (NumberFormatException e) {
			
		}
		
		BookBiz bookbiz=new BookBizImpl();
		boolean ret=bookbiz.getDel(id);
		
		if(ret) {
			request.getRequestDispatcher("bookList").forward(request, response);
		}else {
			request.setAttribute("msg", "删除失败！！！");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
