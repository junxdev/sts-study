<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<%@ include file="../template/header.jspf" %>
</head>
<body>
	<%@ include file="../template/menu.jspf" %>
	<div class="page-header">
		<h1>EMPLOYEE <small>${title eq null ? 'Add' : title }</small></h1>
	</div>
	<form class="form-horizontal" method="post">
		<input type="text" name="empno" value="${bean.empno eq null ? 0 : bean.empno }" hidden/>
		<div class="form-group">
			<label for="ename" class="col-sm-2 control-label">Name</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="ename" id="ename" value="${bean.ename }">
			</div>
		</div>
		<div class="form-group">
			<label for="sal" class="col-sm-2 control-label">Salary</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="sal" id="sal" value="${bean.sal }">
			</div>
		</div>
		<!-- 
		<div class="form-group">
			<label for="hiredate" class="col-sm-2 control-label">Hired date</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="hiredate" id="hiredate">
			</div>
		</div>
		 -->
		<div class="form-group">
			<label for="deptno" class="col-sm-2 control-label">Department No</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="deptno" id="deptno" value="${bean.deptno }">
			</div>
		</div>
		<div class="form-group">
		  	<div class="col-sm-offset-2 col-sm-10">
		    <button type="submit" class="btn btn-default">Add</button>
		  	</div>
		</div>
	</form>
	<a href="add" class="btn btn-primary" role="btn">New Employee</a>
	<%@ include file="../template/footer.jspf" %>
</body>
</html>