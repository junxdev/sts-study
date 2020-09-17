<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${list }" var="bean">
	<div>
		<ul>${bean.deptno }
			<li>${bean.dname }</li>
			<li>${bean.loc }</li>
		</ul>
	</div>
</c:forEach>
</body>
</html>