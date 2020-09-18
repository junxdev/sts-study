<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8">
	<%@ include file="../template/head.jspf" %>
	<script type="text/javascript">
		$(function() {
			if('${title eq "add"}') {
				$('.form-group').eq(0).remove();
				$('.form-group').eq(2).remove();
			}
		})
	</script>
</head>
<body>
	<%@ include file="../template/header.jspf" %>
	<!-- content begins here -->
	<form class="form-horizontal" method="post">
	  <div class="form-group">
	    <label for="empno" class="col-sm-2 control-label">번호</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" name="empno" id="empno" value="${bean.empno }"/>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="ename" class="col-sm-2 control-label">이름</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" name="ename" id="ename" value="${bean.ename }"/>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="sal" class="col-sm-2 control-label">연봉</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" name="sal" id="sal" value="${bean.sal }"/>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="hiredate" class="col-sm-2 control-label">입사일</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" name="hiredate" id="hiredate" value="${bean.hiredate }"/>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="deptno" class="col-sm-2 control-label">부서</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" name="deptno" id="deptno" value="${bean.deptno }"/>
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-default">${title eq "add" ? "직원 추가" : "수정" }</button>
	    </div>
	  </div>
	</form>
	<!-- content ends here -->
	<%@ include file="../template/footer.jspf" %>
</body>
</html>
