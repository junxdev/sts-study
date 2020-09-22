<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">
	<style type="text/css">
		table > tbody > tr {
			cursor: pointer;
		}
		table > tbody > tr:hover {
			background-color: rgba(200, 200, 200, 0.8);
		}
	</style>
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
			$(document).on('click', 'table > tbody > tr', function() {
				var deptno = $(this).find("td").first().text();
				if(deptno) {
					callDeptDetail(deptno);
				}
			});
		}
		function callDeptDetail(deptno) {
			$.getJSON('dept/' + deptno, function(data) {
				$('#myModal form .form-group input').eq(0).val(data.deptno);
				$('#myModal form .form-group input').eq(1).val(data.dname);
				$('#myModal form .form-group input').eq(2).val(data.loc);
				$('#myModal').modal();
				$('#myModal .modal-footer button').eq(0).click(function() {
					$('#myModal form .form-group input').eq(1).prop('readonly', false);
					$('#myModal form .form-group input').eq(2).prop('readonly', false);
					$(this).off('click');
					$(this).click(function() {
						editDept();
					});
				});
			});
		}
		function editDept() {
			/* 
			var params = $('#myModal form').serialize();
			 */
			var params = {'deptno':$('#deptno').val(), 'dname':$('#dname').val(), 'loc':$('#loc').val()};
			console.log(params);
			$.ajax({
				url: 'dept/',
				type: 'put',
				data: JSON.stringify(params),
				contentType: 'application/json; charset=utf-8',
				success: function() {
					$('.jumbotron').prev().remove();
					$('.jumbotron').next().remove();
					callDeptList();
					$('#myModal').modal('hide');
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
	<div id="myModal" class="modal fade" tabindex="-1" role="dialog">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	    <form class="form-horizontal">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title">Modal title</h4>
	      </div>
	      <div class="modal-body">
	        <div class="form-group">
			    <label for="deptno" class="col-sm-2 control-label">No</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="deptno" id="deptno" placeholder="" readonly="readonly">
			    </div>
			  </div>
	        <div class="form-group">
			    <label for="dname" class="col-sm-2 control-label">Name</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="dname" id="dname" placeholder="" readonly="readonly">
			    </div>
			  </div>
	        <div class="form-group">
			    <label for="loc" class="col-sm-2 control-label">Location</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="loc" id="loc" placeholder="" readonly="readonly">
			    </div>
			  </div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-primary">Edit</button>
	        <button type="button" class="btn btn-danger">Delete</button>
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	      </div>
	    </form>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
</body>
</html>
