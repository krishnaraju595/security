<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Registration Form</title>
</head>
<body>
    <div align="center">
        <h2>User Registration</h2>
        <form:form action="employee-signup" method="post" modelAttribute="employee">
            <form:label path="name">Full name:</form:label>
            <form:input path="name"/><br/>

            <form:label path="email">E-mail:</form:label>
            <form:input path="email"/><br/>

            <form:label path="password">Password:</form:label>
            <form:password path="password"/><br/>

            <form:label path="mobile">Mobile:</form:label>
            <form:input path="mobile"/><br/>

            <form:button>Register</form:button>
        </form:form>
    </div>
</body>
</html>