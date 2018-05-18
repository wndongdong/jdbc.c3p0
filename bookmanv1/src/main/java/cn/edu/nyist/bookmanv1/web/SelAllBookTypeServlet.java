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

		//连接业务层，获取数据
		BookTypeBiz bookTypeBiz=new BookTypeBizImpl();
		List<TypeVo> ls=(List<TypeVo>) bookTypeBiz.getAllType();
		int j=0;
		while(j<ls.size()) {
			System.out.println(ls.get(j).getId()+","+ls.get(j).getName());
			j++;
		}
		//返回连接响应结果
		//使用jsp来直接加载，则使用javascript来请求数据
		response.setContentType("text/javascript;charset=utf-8");
		String js="var types=[";
		for (int i=0;i<ls.size();i++) {
			js+="{id:"+ls.get(i).getId()+",name:'"+ls.get(i).getName()+"'}";
			if(i<ls.size()-1) {
				js+=",";
			}
		}
		js+="]";
		System.out.println(js);
		response.getWriter().write(js);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
