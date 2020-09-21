<%@page import="java.util.*"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
{"root":[
	<c:forEach items="${list }" var="bean" varStatus="status">
	<c:if test="${status.index ne 0 }">,</c:if>
	{"deptno":${bean.deptno }, "dname":"${bean.dname }", "loc":"${bean.loc }"}
	</c:forEach>
]}
 --%>
<%
Map map = new HashMap();
map.put("root", request.getAttribute("list"));

com.google.gson.Gson gson = new com.google.gson.Gson();
out.print(gson.toJson(map));
%>