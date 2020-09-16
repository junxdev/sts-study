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
		<h1>EMPLOYEE <small>LIST</small></h1>
	</div>
	<div class="list-group">
		<c:forEach items="${list }" var="bean">
		<a href="${bean.empno }" class="list-group-item">
			<h4 class="list-group-item-heading">${bean.ename }</h4>
			<p class="list-group-item-text">${bean.hiredate }</p>
		</a>
		</c:forEach>
	<a href="add" class="btn btn-primary btn-block" role="btn">New Employee</a>
	<%@ include file="../template/footer.jspf" %>
</body>
</html>