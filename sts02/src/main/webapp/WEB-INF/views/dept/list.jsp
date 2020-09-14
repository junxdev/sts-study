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
						<h1>Departments <small>Where we play, work, love</small></h1>
					</div>
				</div>
			</div>
			<div class="row" id="content">
				<div class="col-md-12">
					<table class="table">
						<thead>
							<tr>
								<th>No</th>
								<th>Name</th>
								<th>Location</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list }" var="vo">
								<tr>
									<td><a href="${pageContext.request.contextPath }/dept/detail?deptno=${vo.deptno }">${vo.deptno }</a></td>
									<td>${vo.dname }</td>
									<td>${vo.loc }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<a href="${pageContext.request.contextPath }/dept/add" class="btn btn-default" role="btn">New Department</a>
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