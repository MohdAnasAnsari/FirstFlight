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
		<h2>Summary Details</h2>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<form action="PaymentPage.jsp" method="post">
			<table border="1">
					<tr>
						<th>Flight Number :</th>
						<td><c:out value="${f.flightNumber}" /></td>
					</tr>
					<tr>
						<th>Flight Name :</th>
						<td><c:out value="${f.airline}" /></td>
					</tr>
					<tr>
						<th>Flight From :</th>
						<td><c:out value="${f.origin}" /></td>
					</tr>
					<tr>
						<th>Flight To :</th>
						<td><c:out value="${f.target}" /></td>
					</tr>
					<tr>
						<th>Flight Boarding Date :</th>
						<td><c:out value="${f.dob}" /></td>
					</tr>
					<tr>
						<th>Ticket Price :</th>
						<td><c:out value="${f.price * n}" /></td>
					</tr>
			</table>
			<input type="submit" value="Payment">
		</form>
	</div>
</body>
</html>