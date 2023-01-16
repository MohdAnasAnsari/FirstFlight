<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FLYAWAY.COM</title>
</head>
<style><%@include file="/WEB-INF/style.css"%></style>
<body>
	<div align="center">
		<c:if test="${p != null}">
			<form action="updatePassenger" method="post">
		</c:if>
		<c:if test="${p == null}">
			<form action="insertPassenger" method="post">
		</c:if>
		<table border="1" cellpadding="5">
			<c:if test="${f != null}">
				<input type="hidden" name="id"
					value="<c:out value='${p.pId}' />" />
			</c:if>
			<tr>
				<th>First Name :</th>
				<td><input type="text" name="fname" size="45"
					value="<c:out value='${p.fname}' />" required /></td>
			</tr>
			<tr>
				<th>Last Name :</th>
				<td><input type="text" name="lname" size="45"
					value="<c:out value='${p.lname}' />" required /></td>
			</tr>
			<tr>
				<th>Contact :</th>
				<td><input type="number" name="contact" size="45"
					value="<c:out value='${p.contact}' />" required /></td>
			</tr>
			<tr>
				<th>Age :</th>
				<td><input type="text" name="age" size="45"
					value="<c:out value='${p.age}' />" required /></td>
			</tr>
			<tr>
				<th>Email :</th>
				<td><input type="email" name="email" size="45"
					value="<c:out value='${p.email}' />" required /></td>
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