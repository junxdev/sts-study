<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../template/head.jspf" %>
</head>
<body>
<%@ include file="../template/header.jspf" %>
<div class="page-header">
	<h1>부서 추가</h1>
</div>
<form action="./" method="post" class="form-horizontal">
	<div class="form-group">
		<label for="dname" class="col-sm-2 control-label">부서 이름</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="dname"/>
		</div>
	</div>
	<div class="form-group">
		<label for="loc" class="col-sm-2 control-label">부서 위치</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="loc"/>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default">추가</button>
		</div>
	</div>
</form>
<%@ include file="../template/footer.jspf" %>
</body>
</html>