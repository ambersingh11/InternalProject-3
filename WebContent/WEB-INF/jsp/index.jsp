<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BIT Student Portal</title>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
</head>
<body>
	<p>WELCOME!!!</p>
	<br>
	<a href="homescreen">Visitors Link</a>
	<br>
	<p>Admin Login</p>
	<form:form method="POST" action="adminpage">
	<form:errors path="*"/><br>
		<label>Admin UserName: </label><form:input path="userName"/>
		<br>
		<label>PassWord: </label><form:password path="passWord"/>
		<br>
		<input type="submit" value="Login">
	</form:form>
</body>
</html>