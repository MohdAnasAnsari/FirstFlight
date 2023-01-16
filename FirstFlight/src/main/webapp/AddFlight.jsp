<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FLYAWAY.COM</title>
</head>
<style><%@include file="/WEB-INF/style.css"%></style>
<body>
	<div align="center">
		<c:if test="${f != null}">
			<form action="update" method="post">
		</c:if>
		<c:if test="${f == null}">
			<form action="insert" method="post">
		</c:if>
		<table border="1" cellpadding="5">
			<c:if test="${f != null}">
				<input type="hidden" name="fid"
					value="<c:out value='${f.flightId}' />" />
			</c:if>
			<tr>
				<th>Flight Number :</th>
				<td><input type="number" name="fnumber" size="45"
					value="<c:out value='${f.flightNumber}' />" required /></td>
			</tr>
			<tr>
				<th>Airline :</th>
				<td><input type="text" name="fname" size="45"
					value="<c:out value='${f.airline}' />" required /></td>
			</tr>
			<tr>
				<th>Origin :</th>
				<td><input type="text" name="forigin" size="45"
					value="<c:out value='${f.origin}' />" required /></td>
			</tr>
			<tr>
				<th>Destination :</th>
				<td><input type="text" name="ftarget" size="45"
					value="<c:out value='${f.target}' />" required /></td>
			</tr>
			<tr>
				<th>Flight Date :</th>
				<td><input type="date" name="fdate" size="45"
					value="<c:out value='${f.dob}' />" required /></td>
			</tr>
			<tr>
				<th>Ticket Price :</th>
				<td><input type="number" name="fprice" size="45"
					value="<c:out value='${f.price}' />" required /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Save" /></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>