package cn.edu.nyist.bookmanv1.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.nyist.bookmanv1.biz.UserBiz;
import cn.edu.nyist.bookmanv1.biz.impl.UserBizImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.获取客户端输入
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		String vcode=request.getParameter("vcode");
			//为防止分布式事务攻击，在连接数据库前进行验证码比对
		/*
		 * 获取服务器生成的验证码
		 */
		HttpSession session = request.getSession();
		String serverVcode=(String) session.getAttribute("validateCode");
		//2.连接数据库比对
		if(!serverVcode.equalsIgnoreCase(vcode)) {
			//如果不同则不用进行下面步骤
			return;
		}
		//连接数据库查询
		UserBiz userBiz=new UserBizImpl();
		boolean ret=userBiz.getFindNameAndPwd(name,pwd);
		//3.返回比对结果给客户
		if(ret) {
			response.sendRedirect("main.jsp");
		}else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
