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
		
		/**
		 * 由于一些人没有权限，所以对书籍管理不能进行操作，所以就必须加以验证
		 * 		由于这样写，有过多的代码重复，使得在后期维护上不利于维护，所以在此基础上的做法是，使用过滤器
		 */
		
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
			request.setAttribute("msg", "验证码错误！");
			request.setAttribute("name", name);
			request.setAttribute("vcode", vcode);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		//连接数据库查询
		UserBiz userBiz=new UserBizImpl();
		boolean ret=userBiz.getFindNameAndPwd(name,pwd);
		//3.返回比对结果给客户
		if(ret) {
			//登录成功之后，对于登录成功的用户有一个记录，这个记录要用于在之后的一些操作中
			request.getSession().setAttribute("loginSeccess", "1");
			response.sendRedirect("main.jsp");
		}else {
			request.setAttribute("msg", "用户名或密码错误");
			request.setAttribute("name", name);
			request.setAttribute("vcode", vcode);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
