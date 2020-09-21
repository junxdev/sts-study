<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">
	<script type="text/javascript" src="resources/js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.js"></script>
	<script type="text/javascript">
		$(function() {
			$('nav a').eq(0).click(function(idx) {
				console.log(idx, this);
				return false;
			});
			$('nav a').eq(1).click(function(idx) {
				console.log(idx, this);
				return false;
			});
			$('nav a').eq(2).click(function(idx) {
				console.log(idx, this);
				return false;
			});
			$('.dropdown-menu a').click(function() {
				console.log($(this).text());
				if($(this).text() == 'DEPARTMENT') {
					callDeptList();
				}
				return false;
			});
		});
		
		function callDeptList() {
			$('.jumbotron').before('<div class="page-header"><h1>Dept<small> List</small></h1></div>').hide();
			$('.jumbotron').after('<div id="content"></div>');
			$('#content').html('<table class="table"><thead><tr><th>deptno</th><th>dname</th><th>loc</th></tr></thead>' 
					+ '<tbody></tbody></table>');
			$.getJSON('dept/', function(data) {
				var alist = data.root;
				for(var i = 0; i < alist.length; i++) {
					$('#content table tbody').append('<tr><td>' + alist[i].deptno + '</td><td>'
							+ alist[i].dname + '</td><td>' + alist[i].loc + '</td></tr>');
				}
			});
		}
	</script>
</head>
<body>
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="#">BIT</a>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li class="active"><a href="#">HOME <span class="sr-only">(current)</span></a></li>
	        <li><a href="#">LOGIN</a></li>
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">DATA <span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li><a href="#">DEPARTMENT</a></li>
	            <li role="separator" class="divider"></li>
	            <li><a href="#">EMPLOYEE</a></li>
	          </ul>
	        </li>
	      </ul>
	       <form class="navbar-form navbar-right">
	        <div class="form-group">
	        	<label for="empno">Emp. No</label>
	          <input type="text" class="form-control" name="empno">
	        </div>
	        <div class="form-group">
	        	<label for="deptno">Dept. No</label>
	          <input type="password" class="form-control" name="deptno">
	        </div>
	        <button type="submit" class="btn btn-default">LOGIN</button>
	      </form>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>
	<div class="jumbotron">
		<h2>Hello, world</h2>
		<p>Programming education</p>
	</div>
</body>
</html>
