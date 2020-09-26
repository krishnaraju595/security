<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="ctx" value="${pageContext['request'].contextPath}" />
<html>
<body>
	<h1>Date: ${date}</h1>

	<ul>
		<li>jsp：<a href="hello">hello</a></li>
		<li>jsp-from-common：<a href="hello-from-common">hello-from-common</a></li>
		<li>jsp-emp-data：<a href="rest-emps">rest-emps</a></li>
        <li>jsp：<a href="employees">employees</a></li>
         <li>jsp：<a href="add?t1=2&t2=3">GetResult</a></li>
         <li>jsp：<a href="shell?command=systeminfo">GetResult</a></li>
         <li>jsp：<a href="projects">GetProjects</a></li>
         <li>jsp：<a href="employee-signup">Employee-SignUp</a></li>



	</ul>
</body>
</html>