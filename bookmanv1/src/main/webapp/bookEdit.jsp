<%@page import="cn.edu.nyist.bookmanv1.vo.BookVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书籍修改界面</title>
<!-- 告诉浏览器不要缩放 -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="bower_components/bootstrap/dist/css/bootstrap.css" rel="stylesheet" type="text/css"/>
	<link href="bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.css" rel="stylesheet" type="text/css"/>
	<style type="text/css">
		#mainId {
			padding-top: 10px;
		}
		.bookdata{
			width: 80%;
			margin-left: auto;
			margin-right: auto;
			
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
					<a class="navbar-brand" >图书馆</a>
				</div>

				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">书籍管理<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li><a href="main.jsp">图书馆主页</a></li>
								<li><a href="bookList">书籍列表</a></li>
							</ul>
						</li>
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
		<div class="bookdata">
		<div class="row">
			<div class="col-md-12">
				<form class="form-horizontal" id="signupForm" role="form" method="post" action="doBookEdit" enctype="multipart/form-data">
					<%
						BookVo bookVo=(BookVo)request.getAttribute("bookVo");
					%>
					<input type="hidden"  value="<%=bookVo.getId()%>" name="id"/>
					<%System.out.println("JSP页面上的输出值：*****************************."+bookVo.getId()); %>
					<div class="form-group">
						<label for="inputName" class="col-sm-2 control-label"> 书名
						</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputName" name="name" value='<%=bookVo==null||bookVo.getName()==null?"":bookVo.getName()%>'/>
						</div>
					</div>
					<div class="form-group">
						<label for="inputDescri" class="col-sm-2 control-label">
							描述 </label>
						<div class="col-sm-10">
							<textarea rows="" cols="" class="form-control" id="inputDescri" name="descri" ><%=bookVo==null||bookVo.getDescri()==null?"":bookVo.getDescri() %></textarea>
						</div>
					</div>

					<div class="form-group">
						<label for="inputAuthor" class="col-sm-2 control-label">
							作者 </label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputAuthor"  name="author"  value='<%=bookVo==null||bookVo.getAuthor()==null?"":bookVo.getAuthor()%>'/>
						</div>
					</div>

					<div class="form-group">
						<label for="inputPhoto" class="col-sm-2 control-label"> 封面
						</label>
						<div class="col-sm-6">
							<input type="file" class="form-control" id="inputPhoto" name="photo" />	
						</div>
						<%
							if(!(bookVo==null||bookVo.getPhoto()==null)){
								%>
								<div class="col-sm-4">
									<img alt="" src="upload/<%=bookVo.getPhoto()%>" style="max-height: 100px;">
								</div>	
								<%
							}
						%>
					</div>
					
					<div class="form-group">
						<label for="inputtype" class="col-sm-2 control-label"> 类型
						</label>
						<div class="col-sm-10">
							<select class="form-control" id="inputtype" name="tid" >
						<!-- 		<option value="1">法学</option>
								<option value="2">哲学</option>
								<option value="3">经济学</option>
								<option value="4">软件编程</option> -->
								
							</select>
						</div>
					</div>

					<div class="form-group">
						<label for="inputPubDate" class="col-sm-2 control-label">
							出版日期 </label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputPubDate"
								name="pubDate"  value='<%=bookVo==null||bookVo.getPubDate()==null?"":bookVo.getPubDate()%>'/>
						</div>
					</div>

					<div class="form-group">
						<label for="inputprice" class="col-sm-2 control-label"> 价格
						</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputprice"
								name="price" value='<%=bookVo==null?"":bookVo.getPrice()%>'/>
						</div>
					</div>

					<div class="form-group">
						<label for="inputVcode" class="col-sm-2 control-label">
							验证码 </label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="inputVcode"
								name="vcode" maxlength="4" />
						</div>
						<div class="col-sm-4">
							<img alt="" src="vcode.png" id="vcodeImg" title="单击换图">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">确定修改</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div
					style="text-align: center; background-color: #DCDCDC;padding-top: 15px;padding-bottom: 15px;">
					<p>&copy;忆殇雨版权所有</p>
				</div>
			</div>
		</div>
	</div>
	<!-- 为加速网页显示速度，在body中进行js添加 -->
	<script type="text/javascript"
		src="bower_components/jquery/dist/jquery.min.js"></script>
	<script type="text/javascript"
		src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
	<script type="text/javascript"
		src="bower_components/bootstrap-datepicker/dist/locales/bootstrap-datepicker.zh-CN.min.js"></script>
	<script type="text/javascript" src="bower_components/jquery-validation/dist/jquery.validate.js"></script>
	
	<script type="text/javascript">
		$(function() {
			$("#vcodeImg").click(function(e) {
				this.src = "vcode.png?t=" + Math.random();
			});
			$("#inputPubDate").datepicker({
				format : "yyyy-mm-dd",
				language : "zh-CN",
				autoclose : true
			});
		});
	</script>
	<script type="text/javascript">
		function selAllType(types){
			var tid= <%=bookVo.getTid()%>;
			var sel = document.getElementById("inputtype");
			for(var i=0;i<types.length;i++){
				var op=new Option(types[i].name,types[i].id);
				sel.appendChild(op);	
				if(tid==types[i].id){
					op.selected=true;
				}
			}
		}
	</script>
	<!-- 使用iframe标签 -->
	<!-- 为了使得iframe窗口能够隐藏起来，使用styl配置display属性为none
				display不保留窗口位置
				visibility被设置为"hidden"的时候，元素虽然被隐藏了，但它仍然占据它原来所在的位置
		 -->
	<iframe src="selAllBookType" style="display:none;"></iframe>
	<!-- 
	<script type="text/javascript" src="selAllBookType">
	</script>
	 -->
	<!-- 
	<script type="text/javascript" src="selAllBookType" onload="selAllType()">
	</script>
	 -->
</body>
</html>