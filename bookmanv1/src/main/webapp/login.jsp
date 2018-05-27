<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<!-- 告诉浏览器不要缩放 -->
<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<link href="bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

<style type="text/css">
	.container-fluid{
		width: 40%;
		position:absolute;
		top:50%;
		left:50%;
		margin-left: -300px;
		margin-top:-98px;
		background-color: #FAEBD7;
		padding-top:20px;
	}
</style>
</head>
<body>
	<div class="container-fluid"> 
		<div class="row"> 
			<div class="col-md-12"> 
				<form class="form-horizontal" role="form" method="post" action="login">
					<div class="form-group"> 
						<c:if test="${requestScope.msg!=null}">
							<div class="alert alert-warning" role="alert">
								${requestScope.msg}
							</div>
						</c:if>	
							<label for="inputName" class="col-sm-2 control-label"> 
							用户名
							</label> 
						<div class="col-sm-10"> 
							<input type="text" class="form-control" id="inputName" name="name" value="${requestScope.name }"/>
						</div> 
					</div> 
					<div class="form-group"> 
						<label for="inputPwd" class="col-sm-2 control-label"> 
						密码 
						</label> 
						<div class="col-sm-10"> 
							<input type="password" class="form-control" id="inputPwd" name="pwd"/>
						</div> 
					</div> 
					<div class="form-group">  
						<label for="inputVcode" class="col-sm-2 control-label">
						验证码
						</label> 
						<div class="col-sm-6"> 
							<input type="text" class="form-control" id="inputVcode" name="vcode" maxlength="4" value="${requestScope.vcode }"/>
						</div> 
						<div class="col-sm-4"> 
							<img alt="" src="vcode.png" id="vcodeImg" title="单击换图"> 
						</div> 
					</div> 
					<div class="form-group"> 
						<div class="col-sm-offset-2 col-sm-10">  
							<button type="submit" class="btn btn-default"> 
								登陆 
							</button> 
						</div> 
					</div> 
				</form> 
			</div> 
		</div> 
	</div> 
<!-- 为加速网页显示速度，在body中进行js添加 -->
	<script type="text/javascript" src="bower_components/jquery/dist/jquery.min.js"></script>
	<script type="text/javascript" src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	$(function(){
			$("#vcodeImg").click(function(e){
				this.src = "vcode.png?t=" + Math.random();
			});
	});
	</script>
</body>
</html>