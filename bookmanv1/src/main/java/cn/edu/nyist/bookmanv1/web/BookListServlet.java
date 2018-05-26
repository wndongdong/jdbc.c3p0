package cn.edu.nyist.bookmanv1.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.nyist.bookmanv1.biz.BookBiz;
import cn.edu.nyist.bookmanv1.biz.impl.BookBizImpl;
import cn.edu.nyist.bookmanv1.util.PageUtil;
import cn.edu.nyist.bookmanv1.vo.BookVo;
import cn.edu.nyist.bookmanv1.vo.TypeVo;

@WebServlet("/bookList")
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		//先获取界面输入的搜索内容
		String name=request.getParameter("name");
		String strTid=request.getParameter("tid");
		int tid=-1;
		try {
			tid=Integer.parseInt(strTid);
		} catch (NumberFormatException e1) {
			
		} 
		String strPageNo=request.getParameter("pageNo");
		int pageNo;
		try {
			pageNo = Integer.parseInt(strPageNo);
		} catch (NumberFormatException e) {
			pageNo=1;
		}

		BookBiz bookBiz=new BookBizImpl();
		List<BookVo> ls=bookBiz.getAllBooks(pageNo,name,tid);
		System.out.println("---------------------------------------------------------------------------");
		List<TypeVo> tls=bookBiz.getAllType();
		int totalPage=bookBiz.getTotal(name,tid);
		System.out.println("========================================================="+totalPage);
		if(totalPage%PageUtil.PAGE_SIZE==0) {
			if(totalPage==0) {
				request.setAttribute("totalPage",1);
			}else {
				request.setAttribute("totalPage",totalPage/PageUtil.PAGE_SIZE); 
			} 
		}else {	
			request.setAttribute("totalPage",totalPage/PageUtil.PAGE_SIZE+1);
		}
		request.setAttribute("name", name); 
		request.setAttribute("tid", tid);
		System.out.println(name+","+tid); 
		request.setAttribute("pageNo", pageNo);
		//为了获取书籍类型数据，所以要拿到书籍数据
		
		request.setAttribute("tls", tls);
		//将所得到的数据发送到jsp页面
		request.setAttribute("ls", ls);
		request.getRequestDispatcher("bookList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
 
}
