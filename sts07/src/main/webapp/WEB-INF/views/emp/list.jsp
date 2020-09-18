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
		<div class="page_header">
			<h1>직원 목록</h1>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>직원 번호</th>
					<th>이름</th>
					<th>연봉</th>
					<th>입사일</th>
					<th>부서</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="bean">
					<tr>
						<td><a href="#">${bean.empno }</a></td>
						<td><a href="#">${bean.ename }</a></td>
						<td><a href="#">${bean.sal }</a></td>
						<td><a href="#">${bean.hiredate }</a></td>
						<td><a href="#">${bean.dname }</a></td>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="../template/footer.jspf" %>
	</body>
</html>