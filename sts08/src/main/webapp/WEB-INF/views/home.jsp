<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">
	<script type="text/javascript" src="resources/js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.js"></script>
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
<table class="table">
	<thead>
		<tr>
			<th>deptno</th>
			<th>dname</th>
			<th>loc</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list }" var="bean">
			<tr>
				<td>${bean.deptno }</td>
				<td>${bean.dname }</td>
				<td>${bean.loc }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>
