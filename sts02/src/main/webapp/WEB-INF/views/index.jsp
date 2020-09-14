<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css">
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-1.12.4.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/bootstrap.min.js"></script>
	</head>
	<body>
		<nav class="navbar navbar-default" id="menu">
		  	<div class="container-fluid">
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
		<div class="container-fluid">
			<div class="row" id="header">
				<div class="col-md-12">
				</div>
			</div>
			<div class="row" id="content">
				<div class="col-md-12">
					<img alt="window-from-inside" class="img-responsive" src="resources/img/pexels-johannes-rapprich-2508810.jpg">
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