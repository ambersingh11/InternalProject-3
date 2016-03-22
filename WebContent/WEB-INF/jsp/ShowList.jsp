<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Performers List</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
</head>
<body>
	<h3>Student List</h3>
<table border="1" cellspacing="0">
	<tr>
		<td><label>Student Roll</label></td>
		<td><label>Students Name</label></td>
		<td><label>Student Department</label></td>
		<td><label>Academic marks</label></td>
		<td><label>Academic events</label></td>
		<td><label>Sports events</label></td>
		<td><label>Cultural events</label></td>
		<td><label>Grade</label></td>
	</tr>

<c:forEach items="${student}" var="student">
	<tr>	
		<td>${student.rollNo }</td>
		<td>${student.name }</td>
		<td>${student.department }</td>
		<td>${student.academics }</td>
		<td>${student.events }</td>
		<td>${student.sports }</td>
		<td>${student.cultural }</td>
		<td>${student.grade }</td>

</c:forEach>	
</table>
<a href="../">Home Page</a>
</body>
</html>