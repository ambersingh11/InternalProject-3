<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details Added</title>
</head>
<body>
<h2>Student Record Added</h2><br>
<table border="1" cellspacing="0">
	<tr>
		<td><label>Student Roll</label></td>
		<td><label>Students Name</label></td>
		<td><label>Student Department</label></td>
		<td><label>Academic marks</label></td>
		<td><label>Academic events</label></td>
		<td><label>Sports events</label></td>
		<td><label>Cultural events</label></td>
		<td><label>Picture</label></td>
	</tr>
	<tr>	
		<td>${command.rollNo }</td>
		<td>${command.name }</td>
		<td>${command.department }</td>
		<td>${command.academics }</td>
		<td>${command.events }</td>
		<td>${command.sports }</td>
		<td>${command.cultural }</td>
		<td><img src="${command.imagePath}" height="200px" width=""></img></td>
	</tr>	
</table>
<br>
<a href="adminpage">Add Another</a>
<a href="logout">LOG OUT</a>
</body>
</html>