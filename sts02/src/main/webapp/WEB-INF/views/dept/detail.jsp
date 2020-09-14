<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css">
		<style type="text/css">
			#menu {
				margin-bottom: 0px;
			}
		</style>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-1.12.4.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			$(function() {
				if('${readonly}') {
					$('form').submit(function() {
						location.href = "edit?deptno=${vo.deptno}";
						return false;
					});
					$('.btn-danger').click(function() {
						$.post('delete', 'deptno=${vo.deptno}', function(data) {
								console.log(data);
							if(data) {
							} else {
								
								location.replace("list");
							}
						});
					});
				} else {
					$('.btn-danger').text('Cancel').attr('type', 'reset').removeClass('btn-danger').addClass('btn-default');
				}
			});
		</script>
	</head>
	<body>
		<nav class="navbar navbar-default" id="menu">
		  	<div class="container">
		    	<div class="navbar-header">
		    		<a class="navbar-brand" href="#">STS</a>
		    	</div>
			    <ul class="nav navbar-nav">
			        <li class="active"><a href="${pageContext.request.contextPath }/">HOME</a></li>
			        <li><a href="${pageContext.request.contextPath }/emp/list">EMP</a></li>
			        <li><a href="${pageContext.request.contextPath }/dept/list">DEPT</a></li>
			        <li><a href="${pageContext.request.contextPath }/login">LOGIN</a></li>
		        </ul>
		  	</div>
		</nav>
		<div class="jumbotron">
			<div class="container">
				<div class="row" id="header">
					<div class="col-md-12">
					    <p class="lead">This is a whole new experience!</p>
					    <p>Try Spring Tool Suite right now!</p>
					</div>
				</div>
		  	</div>
		</div>
		<div class="container">
			<div class="row" id="header">
				<div class="col-md-12">
					<div class="page-header">
						<h1>Departments <small>${title }</small></h1>
					</div>
				</div>
			</div>
			<div class="row" id="content">
				<div class="col-md-12">
					<form class="form-horizontal" method="post">
					  	<div class="form-group">
					    	<label for="deptno" class="col-sm-2 control-label">No</label>
					    	<div class="col-sm-10">
					    		<input type="text" class="form-control" name="deptno" id="deptno" value="${vo.deptno }" readonly/>
					    	</div>
					  	</div>
					  	<div class="form-group">
					    	<label for="dname" class="col-sm-2 control-label">Name</label>
					    	<div class="col-sm-10">
					    		<input type="text" class="form-control" name="dname" id="dname" value="${vo.dname }" ${readonly }/>
					    	</div>
					  	</div>
					  	<div class="form-group">
					    	<label for="loc" class="col-sm-2 control-label">Location</label>
					    	<div class="col-sm-10">
					    		<input type="text" class="form-control" name="loc" id="loc" value="${vo.loc }" ${readonly }/>
					    	</div>
					  	</div>
					  	<div class="form-group">
 							<div class="col-sm-offset-2 col-sm-10">
					  			<button type="submit" class="btn btn-default">Edit this</button>
					  			<button type="button" class="btn btn-danger">Delete this</button>
					  		</div>
					  	</div>
					</form>
				</div>
			</div>
			<div class="row" id="footer">
				<div class="col-md-12">
					<address>address blah blah</address>
				</div>
			</div>
		</div>
	</body>
</html>