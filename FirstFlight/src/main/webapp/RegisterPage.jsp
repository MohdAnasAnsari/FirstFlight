<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<style><%@include file="/WEB-INF/style.css"%></style>
<head>
<meta charset="ISO-8859-1">
<title>FLYAWAY.COM</title>
</head>
<body>
	<h1 align="center">Passenger Details</h1>
	<h2 align="center">
		<a href="AddPassenger.jsp">Add Passenger</a> &nbsp;&nbsp;&nbsp;
	</h2>
	<div align="center">
		<table border="1">
			<caption>Passenger Details</caption>
			<tr>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Contact</th>
				<th>Age</th>
				<th>Email</th>
			</tr>
			<c:forEach var="p" items="${list}">
				<tr>
					<td><c:out value="${p.pId}" /></td>
					<td><c:out value="${p.fname}" /></td>
					<td><c:out value="${p.lname}" /></td>
					<td><c:out value="${p.contact}" /></td>
					<td><c:out value="${p.age}" /></td>
					<td><c:out value="${p.email}" /></td>
					<td><a href="deletePassenger?id=<c:out value='${p.pId}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="register">Confirm</a>
	</div>
</body>
</html>