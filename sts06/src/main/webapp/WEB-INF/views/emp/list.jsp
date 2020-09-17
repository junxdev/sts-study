<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<%@ include file="../template/head.jspf" %>
</head>
<body>
	<%@ include file="../template/header.jspf" %>
	<!-- content begins here -->
	<table class="table">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>연봉</th>
				<th>입사일</th>
				<th>부서</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="bean">
				<tr>
					<td>${bean.empno }</td>
					<td>${bean.ename }</td>
					<td>${bean.sal }</td>
					<td>${bean.hiredate }</td>
					<td>${bean.deptno }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- content ends here -->
	<%@ include file="../template/footer.jspf" %>
</body>
</html>
