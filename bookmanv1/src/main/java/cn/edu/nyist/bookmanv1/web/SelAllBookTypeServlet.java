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
import cn.edu.nyist.bookmanv1.vo.TypeVo;



@WebServlet("/selAllBookType")
public class SelAllBookTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SelAllBookTypeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getSession().getAttribute("loginSeccess")==null||!request.getSession().getAttribute("loginSeccess").equals("1")){
			response.sendRedirect("login.jsp");
			return;
		}
		//连接业务层，获取数据
		BookBiz bookBiz=new BookBizImpl();
		List<TypeVo> ls=(List<TypeVo>) bookBiz.getAllType();
		int j=0;
		while(j<ls.size()) {
			System.out.println(ls.get(j).getId()+","+ls.get(j).getName());
			j++;
		}
		//返回连接响应结果
		//使用jsp来直接加载，则使用javascript来请求数据
		response.setContentType("text/html;charset=utf-8");
		//这里iframe会把这段代码当成html文本执行，所以不能使用javascript文本来传递
		/*但若要进行动态样式生成，则需要进行添加script标签，强制执行下列代码*/
		response.getWriter().write("<script>");
		String js="[";
		for (int i=0;i<ls.size();i++) {
			js+="{id:"+ls.get(i).getId()+",name:'"+ls.get(i).getName()+"'}";
			if(i<ls.size()-1) {
				js+=",";
			} 
		}
		js+="]";
		//这里iframe为子窗口，而方法selAllType在父窗口中，所以要调用父窗口的方法
		response.getWriter().write("window.parent.selAllType("+js+")");
		response.getWriter().write("</script>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
