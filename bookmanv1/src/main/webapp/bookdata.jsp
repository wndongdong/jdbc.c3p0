<%@page import="java.util.List"%>
<%@page import="cn.edu.nyist.bookmanv1.vo.TypeVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书管理界面</title>
<!-- 告诉浏览器不要缩放 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="bower_components/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<form class="form-horizontal" role="form" method="post"
					action="bookAdd" enctype="multipart/form-data">
					<div class="form-group">
						<label for="inputName" class="col-sm-2 control-label"> 书名
						</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputName"
								name="name" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputDescri" class="col-sm-2 control-label">
							描述 </label>
						<div class="col-sm-10">
							<textarea rows="" cols="" class="form-control" id="inputDescri"
								name="descri"></textarea>
						</div>
					</div>

					<div class="form-group">
						<label for="inputAuthor" class="col-sm-2 control-label">
							作者 </label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputAuthor"
								name="author" />
						</div>
					</div>

					<div class="form-group">
						<label for="inputPhoto" class="col-sm-2 control-label"> 封面
						</label>
						<div class="col-sm-10">
							<input type="file" class="form-control" id="inputPhoto"
								name="photo" />
						</div>
					</div>

					<div class="form-group">
						<label for="inputtype" class="col-sm-2 control-label"> 类型
						</label>
						<div class="col-sm-10">
							<select class="form-control" id="inputtype" name="tid">
						<!-- 	<option value="1">法学</option>
								<option value="2">哲学</option>
								<option value="3">经济学</option>
								<option value="4">软件编程</option> -->	
							<%
								List<TypeVo> ls=(List<TypeVo>)request.getAttribute("ls");
								for(TypeVo typeVo:ls){
									%>
										<option value="<%=typeVo.getId()%>"><%=typeVo.getName() %></option>
									<%
								}
							%>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label for="inputPubDate" class="col-sm-2 control-label">
							出版日期 </label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputPubDate"
								name="pubDate" />
						</div>
					</div>

					<div class="form-group">
						<label for="inputprice" class="col-sm-2 control-label"> 价格
						</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputprice"
								name="price" />
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
							<button type="submit" class="btn btn-default">确定添加</button>
						</div>
					</div>
				</form>
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
</body>
</html>