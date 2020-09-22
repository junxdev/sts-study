<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#f').click(function() {
			$(this).append('<input type="file" name="files"><br/>')
		});
	});
</script>
</head>
<body>
	<h1>Multi File Upload</h1>
	<form action="uploads" method="post" enctype="multipart/form-data">
		<div>
			<label for="test_id">test_id</label>
			<input type="text" name="test_id">
		</div>
		<div id="f">
			<input type="file" name="files">
			<input type="file" name="files">
			<input type="file" name="files">
		</div>
		<div>
			<button>Send</button>
		</div>
	</form>
</body>
</html>