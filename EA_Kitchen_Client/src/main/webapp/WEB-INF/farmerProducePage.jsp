<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Farmer Produce List</title>
</head>
<body>
	<h1>FARMER required</h1>
	<table>
		<tr>
			<th>Farmer name</th>
			<th>Quantity</th>
			<th>Quantity Available</th>
			<th>Produce Name</th>
			<td>Price</td>
		</tr>
		<c:forEach var="farmerProduce"
			items="${farmerProduces}">
			<tr>
				<td>${farmerProduce.farmer.username}</td>
				<td>${farmerProduce.quantity}</td>
				<td>${farmerProduce.remainingQuantity}</td>
				<td>${farmerProduce.produce.produceName}</td>
				<td>${farmerProduce.date}</td>
				
				<%-- <td><a href="scheduleProduceAccept/${scheduleProduce.scheduleProduceId} }">Accept</a></td> --%>
			</tr>
		</c:forEach>
	</table>
	<a href="/farmerProducesList">List of accepted produces</a>
</body>
</html>