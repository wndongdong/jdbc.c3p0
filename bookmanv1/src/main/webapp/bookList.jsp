<%@page import="cn.edu.nyist.bookmanv1.vo.TypeVo"%>
<%@page import="java.util.List"%>
<%@page import="cn.edu.nyist.bookmanv1.vo.BookVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书列表界面</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="bower_components/bootstrap/dist/css/bootstrap.css" rel="stylesheet" type="text/css" />
<style type="text/css">
#mainId {
	padding-top: 10px;
}
#tableId{
	height: 400px;
}
</style>
</head>
<body>
	<div class="container-fluid" id="mainId">
		<div class="row">
			<div class="col-md-12">
				<nav class="navbar navbar-default" role="navigation">
				<div class="navbar-header">

					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span><span
							class="icon-bar"></span><span class="icon-bar"></span><span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">图书馆</a>
				</div>

				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">书籍管理<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li><a href="#">书籍修改</a></li>
								<li><a href="#">书籍列表</a></li>
							</ul></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#">退出</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">账号<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li><a href="login.jsp">登录</a></li>
								<li><a href="#">注册</a></li>
							</ul></li>
					</ul>
				</div>
				</nav>
			</div>
		</div>
		<div class="row" id="tableId">
			<div class="col-md-12" id="booklist">
				<table class="table table-bordered" id="t_booklist" height="400px">
					<thead>
						<tr height="36px">
							<td colspan="8">
							<form class="form-inline">
							  <div class="form-group">
							    <label for="inputName">书名</label>
							    <input type="text" class="form-control" id="inputName" name="name">
							  </div>
							  <div class="form-group">
							    <label for="selType">类型</label>
							   		<select id="selType" class="form-control">
							   		<%
							   			List<TypeVo> tls=(List<TypeVo>)request.getAttribute("tls");	
							    		for(TypeVo typeVo:tls){
							    			%>
							    			<option value="<%=typeVo.getId()%>"><%=typeVo.getName() %></option>
							    			<%
							    		}
							   		%>	
							   		</select>
							  </div>
							  <button type="submit" class="btn btn-default">搜索</button>
							</form>
							</td>
						</tr>
						<tr height="36px">
							<th>id</th>
							<th>name</th>
							<th>author</th>
							<th>descri</th>
							<th>type</th>
							<th>photo</th>
							<th>price</th>
							<th>pubDate</th>
						</tr>
					</thead>
					<tbody>
					<!-- 现在jsp取数据，取来的数据来动态填入表格 -->
					<%
						List<BookVo> ls=(List<BookVo>)request.getAttribute("ls");
						
						for(BookVo bookVo:ls){
							%>
						<tr height="170px;">
							<td><%=bookVo.getId() %></td>
							<td><%=bookVo.getName() %></td>
							<td><%=bookVo.getAuthor() %></td>
							<td><%=bookVo.getDescri() %></td>
							<% 
								for(TypeVo typeVo:tls){
									if(typeVo.getId()==bookVo.getTid()){
										%>
										<td>
											<%=typeVo.getName() %>
										</td><!-- 这里获取的tid也不是书籍类型编号 -->
										<%
									}
								}
								
							%>
							
							<td>
								<img alt="" src="upload/<%=bookVo.getPhoto()%>"  style="max-height: 120px;">
							</td>
							<td><%=bookVo.getPrice() %></td>
							<td><%=bookVo.getPubDate() %></td>
						</tr>
							<%
						}
					%>
						<tr>
							<td colspan="8" class="text-center">
								<ul class="pagination" id="page" style="margin: 0px;">
									
								<%
									int pageNo=(Integer)request.getAttribute("pageNo");
									int totalPage=(Integer)request.getAttribute("totalPage");
									if(pageNo==1){
										%>
										<li class="disabled"><a href="bookList?pageNo=<%=pageNo-1 %>">Prev</a></li>
										<%
									}else{
										%>
										<li><a href="bookList?pageNo=<%=pageNo-1 %>">Prev</a></li>
										<%
									}
									if(totalPage<=5){
										for(int i=1;i<=totalPage;i++){
										%>	
											<li><a href="bookList?pageNo=<%=i%>"><%=i %></a></li>
										<%
										}
									}else if(pageNo<=3){
										%>
										<li><a href="bookList?pageNo=1">1</a></li>
										<li><a href="bookList?pageNo=2">2</a></li>
										<li><a href="bookList?pageNo=3">3</a></li>
										<li><a href="bookList?pageNo=4">4</a></li>
										<li><a href="bookList?pageNo=<%=totalPage%>">..<%=totalPage %></a></li>
										<%
									}else if(pageNo>=totalPage-2){
										%>
										<li><a href="bookList?pageNo=1">..1</a></li>
										<li><a href="bookList?pageNo=<%=totalPage-3%>"><%=totalPage-3%></a></li>
										<li><a href="bookList?pageNo=<%=totalPage-2%>"><%=totalPage-2%></a></li>
										<li><a href="bookList?pageNo=<%=totalPage-1%>"><%=totalPage-1%></a></li>
										<li><a href="bookList?pageNo=<%=totalPage%>"><%=totalPage %></a></li>
										<%
									}else{
										%>
										<li><a href="bookList?pageNo=1">1..</a></li>
										<li><a href="bookList?pageNo=<%=pageNo-1 %>"><%=pageNo-1 %></a></li>
										<li><a href="bookList?pageNo=<%=pageNo %>"><%=pageNo%></a></li>
										<li><a href="bookList?pageNo=<%=pageNo+1 %>"><%=pageNo+1 %></a></li>
										<li><a href="bookList?pageNo=<%=totalPage%>">..<%=totalPage %></a></li>
										<%
									}
								%>	
									<%
										if(pageNo==totalPage){
											%>
											<li class="disabled"><a href="bookList?pageNo=<%=pageNo+1 %>">Prev</a></li>
											<%
										}else{
											%>
											<li ><a href="bookList?pageNo=<%=pageNo+1 %>">Prev</a></li>
											<%
										}
									%>
									
								</ul>
							</td>
						</tr>
					</tbody>
				</table>
				
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div
					style="text-align: center; background-color: #DCDCDC;padding-top: 15px;padding-bottom: 15px;">
					<p>&copy;忆殇雨</p>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="bower_components/jquery/dist/jquery.js">
		
	</script>
	<script type="text/javascript" src="bower_components/bootstrap/dist/js/bootstrap.js">
	</script>
	<script type="text/javascript">
		$(function(){
			$("a[href='bookList?pageNo=<%=pageNo%>']").parent("li").addClass("active");
		});
	</script>
</body>
</html>