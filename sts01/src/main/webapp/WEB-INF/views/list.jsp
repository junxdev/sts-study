<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
	<h1>List</h1>
	<table>
		<tr>
			<th>No</th>
			<th>Name</th>
			<th>Location</th>
		</tr>
		<c:forEach items="${list }" var="bean">
		<tr>
			<td>${bean.deptno }</td>
			<td>${bean.dname }</td>
			<td>${bean.loc }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
