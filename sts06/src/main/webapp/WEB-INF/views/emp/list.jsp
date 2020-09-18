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
	<div aria-label="Page navigation">
	  <ul class="pagination">
	    <li>
	      <a href="#" aria-label="Previous">
	        <span aria-hidden="true">&laquo;</span>
	      </a>
	    </li>
	    <c:forEach begin="${begin }" end="${begin + 4 }" varStatus="status">
	    <li><a href="?page=${begin - 1 + status.index }">${begin - 1 + status.index }</a></li>
	    </c:forEach>
	    <li>
	      <a href="#" aria-label="Next">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </li>
	  </ul>
	</div>
	<p><a href="add" class="btn btn-primary btn-block" role="btn">직원 추가</a></p>
	<!-- content ends here -->
	<%@ include file="../template/footer.jspf" %>
</body>
</html>
