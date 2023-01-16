<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
	


<!DOCTYPE html>
<html>
<style><%@include file="/WEB-INF/style.css"%></style>
<head>
<meta charset="ISO-8859-1">
<title>FLYAWAY.COM</title>
</head>
<body>
	<div align="center">
		<h2>Admin Login</h2>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<br><br>
		<form action="login" method="post">
			<table border="2" cellpadding="5" postion="bottom">
				<tr>
					<th>Email :</th>
					<td><input type="email" name="email" size="45" required>
					</td>
				</tr>
				<tr>
					<th>Password :</th>
					<td><input type="password" name="pwd" size="45" required>
					</td>
				</tr>
			</table>
			<input type="submit" value="Login">
		</form>
	</div>
</body>
</html>