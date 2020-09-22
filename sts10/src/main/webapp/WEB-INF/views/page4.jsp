<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="utf-8" language="java" contentType="text/html; charset=utf-8"%>
<html>
<head>
	<meta charset="utf-8">
	<title>Home</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
	<script type="text/javascript">
		var sock = new SockJS('/sts10/echo');
		$(function() {
			$('button').click(function() {
				var msg = $(this).prev().val();
				if(msg) {
					sock.send(msg);
					$(this).prev().val('');
				} else {
					$(this).prev().focus();
				}
			});
		});
	</script>
</head>
<body>
	<h1>
		PUBLIC  
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
	<div>
		<h3>Chat</h3>
		<input type="text"><button>Send</button>
	</div>
</body>
</html>
