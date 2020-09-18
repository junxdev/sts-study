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
<form action="../${bean.deptno }" method="post" class="form-horizontal">
	<input type="hidden" name="_method" value="put">
	<div class="form-group">
		<label for="deptno" class="col-sm-2 control-label">부서 번호</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="deptno" value="${bean.deptno }" readonly="readonly"/>
		</div>
	</div>
	<div class="form-group">
		<label for="dname" class="col-sm-2 control-label">부서 이름</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="dname" value="${bean.dname }"/>
		</div>
	</div>
	<div class="form-group">
		<label for="loc" class="col-sm-2 control-label">부서 위치</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="loc" value="${bean.loc }"/>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-primary btn-block">수정</button>
			<button type="reset" class="btn btn-default btn-block">취소</button>
		</div>
	</div>
</form>
<%@ include file="../template/footer.jspf" %>
</body>
</html>