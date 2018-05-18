package cn.edu.nyist.bookmanv1.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.nyist.bookmanv1.biz.BookTypeBiz;
import cn.edu.nyist.bookmanv1.biz.impl.BookTypeBizImpl;
import cn.edu.nyist.bookmanv1.vo.TypeVo;

@WebServlet("/selAllBookType")
public class SelAllBookTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SelAllBookTypeServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1先取页面数据
		//2连接业务层
		BookTypeBiz bookType=new BookTypeBizImpl();
		List<TypeVo> ls=bookType.getAllType();
		//3返回响应结果
		request.setAttribute("ls", ls);
		request.getRequestDispatcher("bookdata.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
