package cn.edu.nyist.bookmanv1.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/*")
public class TimerFilter implements Filter {

    public TimerFilter() {

    }


	public void destroy() {

	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

//		HttpServletRequest req=(HttpServletRequest) request;
//		
		long startTime=System.nanoTime();
		System.out.println("start++++++++++++++++++++++++++++++++++");
		chain.doFilter(request, response);
		long endTime=System.nanoTime();
		System.out.println("拦截总时长："+(endTime-startTime)+"纳秒");
		System.out.println("end------------------------------------");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
