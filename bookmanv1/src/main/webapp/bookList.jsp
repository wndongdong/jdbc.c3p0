<%@page import="cn.edu.nyist.bookmanv1.vo.TypeVo"%>
<%@page import="java.util.List"%>
<%@page import="cn.edu.nyist.bookmanv1.vo.BookVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
								<li><a href="main.jsp">图书馆主页</a></li>
								<li><a href="bookdata.jsp">书籍添加</a></li>
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
							<td colspan="9">
							<form class="form-inline" action="bookList" id="serchFrm">
							  <div class="form-group">
							    <label for="inputName">书名</label>
							    <input type="text" class="form-control" id="inputName" name="name" value="${requestScope.name }">
							  </div>
							  <div class="form-group">
							    <label for="selType">类型</label>
							   		<select id="selType" class="form-control" name="tid" >
							   			
							   			<option value="-1">--请选择--</option>
							   			<c:forEach items="${requestScope.tls }" var="typeVo">
							   				<c:choose>
							   					<c:when test="${requestScope.tid==typeVo.id }">
							   						<option value="${typeVo.id }" selected="selected" >${typeVo.name }</option>
							   					</c:when>
							   					<c:otherwise>
							   						<option value="${typeVo.id }" >${typeVo.name }</option>
							   					</c:otherwise>
							   				</c:choose>
							   			</c:forEach>
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
							<th>书籍管理操作</th>
						</tr>
					</thead>
					<tbody>
					
					<c:forEach items="${requestScope.ls }" var="bookVo">
						<tr height="170px;">
							<td>${bookVo.id }</td>
							<td>${bookVo.name }</td>
							<td>${bookVo.author }</td>
							<td>${bookVo.descri }</td>
							<c:forEach items="${requestScope.tls }" var="typeVo">
								<c:if test="${typeVo.id==bookVo.tid }">
									<td>
											${typeVo.name }
									</td>
								</c:if>
							</c:forEach>
							<td>
								<img alt="" src="upload/${bookVo.photo }"  style="max-height: 120px;">
							</td>
							<td>${bookVo.price }</td>
							<td>${bookVo.pubDate }</td>
							<td>
								<a class=" glyphicon glyphicon-remove"  href="bookDel?id=${bookVo.id } %>" onclick="confirmDel()"></a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a class="glyphicon glyphicon-pencil" href="toBookEdit?id=${bookVo.id } %>"></a>
							</td>
						</tr>
					</c:forEach>
					<!-- 现在jsp取数据，取来的数据来动态填入表格 -->
						<tr>
							<td colspan="9" class="text-center">
								<ul class="pagination"  style="margin: 0px;">
									
									<c:choose>
										<c:when test="${requestScope.pageNo==1 }">
											<li class="disabled"><a href="#">&lt;&lt;</a></li>
										</c:when>
										<c:otherwise>
											<li><a href="bookList?pageNo=${requestScope.pageNo-1 }">&lt;&lt;</a></li>
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${requestScope.totalPage<=5 }">
											<c:forEach begin="1" end="${requestScope.totalPage }" var="i">
												<li><a href="bookList?pageNo=${i }">${i }</a></li>
											</c:forEach>
										</c:when>
										<c:when test="${requestScope.pageNo<=3 }">
											<li><a href="bookList?pageNo=1">1</a></li>
											<li><a href="bookList?pageNo=2">2</a></li>
											<li><a href="bookList?pageNo=3">3</a></li>
											<li><a href="bookList?pageNo=4">4</a></li>
											<li><a href="bookList?pageNo=${requestScope.totalPage }">..${requestScope.totalPage }</a></li>
										</c:when>
										<c:when test="${requestScope.pageNo>=requestScope.totalPage-2 }">
											<li><a href="bookList?pageNo=1">..1</a></li>
											<li><a href="bookList?pageNo=${requestScope.totalPage-3 }">${requestScope.totalPage-3 }</a></li>
											<li><a href="bookList?pageNo=${requestScope.totalPage-2 }">${requestScope.totalPage-2 }</a></li>
											<li><a href="bookList?pageNo=${requestScope.totalPage-1 }">${requestScope.totalPage-1 }</a></li>
											<li><a href="bookList?pageNo=${requestScope.totalPage }">${requestScope.totalPage }</a></li>
										</c:when>
										<c:otherwise>
											<li><a href="bookList?pageNo=1">1..</a></li>
											<li><a href="bookList?pageNo=${requestScope.pageNo-1 }">${requestScope.pageNo-1 }</a></li>
											<li><a href="bookList?pageNo=${requestScope.pageNo }">${requestScope.pageNo }</a></li>
											<li><a href="bookList?pageNo=${requestScope.pageNo+1 }">${requestScope.pageNo+1 }</a></li>
											<li><a href="bookList?pageNo=${requestScope.totalPage }">..${requestScope.totalPage }</a></li>
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${requestScope.pageNo==requestScope.totalPage }">
											<li class="disabled"><a href="#">&gt;&gt;</a></li>
										</c:when>
										<c:otherwise>
											<li ><a href="bookList?pageNo=${requestScope.pageNo+1 }">&gt;&gt;</a></li>
										</c:otherwise>
									</c:choose>
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
			$("a[href='bookList?pageNo=${requestScope.pageNo}']").parent("li").addClass("active");

			$(".pagination a[href^='bookList?pageNo=']").click(function(){
				//这里是给表单提交内容进行序列化，从而通过序列化进行表单查询内容加载
					this.href+="&"+$("#serchFrm").serialize();
				});
		});
		function confirmDel(event){
			if(!confirm("确认删除")){
				event.preventDefault();
			}
		}
	</script>
</body>
</html>