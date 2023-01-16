<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>FLYAWAY.COM</title>
</head>
<style><%@include file="/WEB-INF/style.css"%></style>
<body>
	<div align="center">
		<h2>Selected Flight Details</h2>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Number</th>
				<th>Air Name</th>
				<th>Origin</th>
				<th>Destination</th>
				<th>Date</th>
				<th>Booking Price</th>
				<th>Status</th>
			</tr>
			<c:forEach var="f" items="${Selectedlist}">
				<tr>
					<td><c:out value="${f.flightId}" /></td>
					<td><c:out value="${f.flightNumber}" /></td>
					<td><c:out value="${f.airline}" /></td>
					<td><c:out value="${f.origin}" /></td>
					<td><c:out value="${f.target}" /></td>
					<td><c:out value="${f.dob}" /></td>
					<td><c:out value="${f.price}" /></td>
					<td><a href="find?fid=<c:out value='${f.flightId}'/>">Book Now</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>