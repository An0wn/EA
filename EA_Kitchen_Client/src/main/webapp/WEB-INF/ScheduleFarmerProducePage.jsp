<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Schedule Produce List</title>
</head>
<body>

<h1>Produce to Deliver</h1>
	<table>
	<tr>
		<th>Address to Deliver</td>
		<th>Produce Name</th>
		<th>Quantity</th>
		<th>Deliver By</th>
		<!-- <td>Action</td> -->
	</tr>
	<c:forEach var="scheduleFarmerProduces" items="${scheduleFarmerProduces}">
	<tr>
		<td>${scheduleFarmerProduces.scheduleProduce.schedule.city},${scheduleFarmerProduces.scheduleProduce.schedule.address}</td>
		<td>${scheduleFarmerProduces.scheduleProduce.produce.produceName}</td>
		<td>${scheduleFarmerProduces.quantity}</td>
		<td>${scheduleFarmerProduces.scheduleProduce.date}</td>
		<%-- <td><a href="scheduleProduceAccept/${scheduleProduce.scheduleProduceId} }">Accept</a></td> --%>
		<%-- <td id="list"+${scheduleProduce.scheduleProduceId}><button onclick="clickAccept(${scheduleProduce.scheduleProduceId})">Accept</a></td> --%>
	</tr>
	</c:forEach>
	</table>

<a href="/scheduleProduceList">List of potential delivery</a>

</body>
</html>