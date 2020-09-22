<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="utf-8" language="java" contentType="text/html; charset=utf-8"%>
<html>
<head>
	<meta charset="utf-8">
	<title>Home</title>
</head>
<body>
	<h1>
		Log in  
	</h1>
	<nav>
		<a href="/sts10/">HOME</a>
		<a href="/sts10/emp">EMP</a>
		<a href="/sts10/dept">DEPT</a>
		<a href="/sts10/page4">PUBLIC</a>
		<c:if test="${sessionScope.login eq null }">
		<a href="/sts10/login">login</a>
		</c:if>
		<c:if test="${sessionScope.login }">
		<a href="/sts10/logout">logout</a> Hi! ${sessionScope.user }
		</c:if>
	</nav>
	<form action="result">
		ID <input type="text" name="id">
		 PW <input type="text" name="pw">
		<button>Sign in</button>
	</form>
</body>
</html>
