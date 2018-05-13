package cn.edu.nyist.bookmanv1.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SeletBookTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SeletBookTypeServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//直接获取数据库中的类型，所以直接
	}

}
