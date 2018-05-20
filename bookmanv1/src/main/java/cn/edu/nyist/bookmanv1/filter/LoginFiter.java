package cn.edu.nyist.bookmanv1.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 过滤器用于将重复代码提取，用于验证使用
 * @author 寒篱
 *		过滤器的过滤是采取栈的结构，先进行的过滤器后结束，所有的过滤验证是一个循环链一样的结构
 */
@WebFilter("/*")
public class LoginFiter implements Filter {

    public LoginFiter() {

    }


	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		System.out.println("验证拦截开始-----------------------------");
		if (req.getRequestURI().endsWith("/login") ||req.getRequestURI().endsWith("/login.jsp")
				|| req.getRequestURI().contains("/bower_components/") || req.getRequestURI().endsWith("/vcode.png")) {
			
			chain.doFilter(request, response);
			System.out.println("验证拦截结束-----------------------------");
			return;
		}
		if(req.getSession().getAttribute("loginSeccess")==null||!req.getSession().getAttribute("loginSeccess").equals("1")){
			resp.sendRedirect("login.jsp");
			System.out.println("验证拦截结束-----------------------------");
			return;
		}else {
			chain.doFilter(request, response);
			System.out.println("验证拦截结束-----------------------------");
			return;
		}
	}


	public void init(FilterConfig fConfig) throws ServletException {

	}

}
