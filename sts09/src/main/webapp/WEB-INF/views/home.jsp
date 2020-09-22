<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE HTML>
<head>
	<meta charset="utf-8">
	<title>Home</title>
</head>
<body>
	<h1>
		File Upload  
	</h1>
	<form action="upload" method="post" enctype="multipart/form-data">
		<div>
			<label for="test_id">test_id</label>
			<input type="text" name="test_id">
		</div>
		<div>
			<label for="test_file">test_file_name</label>
			<input type="file" name="test_file">
		</div>
		<div>
			<button>Send</button>
		</div>
	</form>
</body>
</html>
