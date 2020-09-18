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
	<h1>부서 수정</h1>
</div>
<form action="../" method="post" class="form-horizontal">
	<div class="form-group">
		<label for="deptno" class="col-sm-2 control-label">부서 번호</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="deptno" value="${bean.deptno }" readonly="readonly"/>
		</div>
	</div>
	<div class="form-group">
		<label for="dname" class="col-sm-2 control-label">부서 이름</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="dname" value="${bean.dname }" readonly="readonly"/>
		</div>
	</div>
	<div class="form-group">
		<label for="loc" class="col-sm-2 control-label">부서 위치</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="loc" value="${bean.loc }" readonly="readonly"/>
		</div>
	</div>
</form>
<div>
	<a href="./${bean.deptno }/edit" class="btn btn-primary btn-block" role="btn">수정</a>
	<form method="post">
		<input type="hidden" name="_method" value="delete">
		<button type="submit" class="btn btn-danger btn-block">삭제</button>
	</form>
</div>
<%@ include file="../template/footer.jspf" %>
</body>
</html>