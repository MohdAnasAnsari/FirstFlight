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
	<h1 align="center">Flight Management</h1>
	<h2 align="center">
		<a href="add">Add Flight</a>
		&nbsp;&nbsp;&nbsp;
		<a href="ResetPage.jsp">Change Password</a>
		&nbsp;&nbsp;&nbsp;
		<a href="HomePage.jsp">Logout</a>
	</h2>
	<div align="center">
        <table border="1">
            <caption>
            	Flight Details 
            </caption>
   
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
            <c:forEach var="f" items="${list}">
                <tr>
                    <td><c:out value="${f.flightId}" /></td>
                    <td><c:out value="${f.flightNumber}" /></td>
                    <td><c:out value="${f.airline}" /></td>
                    <td><c:out value="${f.origin}" /></td>
                    <td><c:out value="${f.target}" /></td>
                    <td><c:out value="${f.dob}" /></td>
                    <td><c:out value="${f.price}" /></td>
                    <td>
                     <a href="edit?fid=<c:out value='${f.flightId}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="delete?fid=<c:out value='${f.flightId}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
</html>