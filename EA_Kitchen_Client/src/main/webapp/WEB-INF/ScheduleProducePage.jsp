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


<h1>Produce required</h1>

	<table>

	<tr>

		<th>Address to Deliver</td>

		<th>Produce Name</th>

		<th>Quantity</th>

		<th>Deliver By</th>

		<td>Action</td>

	</tr>

	<c:forEach var="scheduleProduce" items="${scheduleProduces}">

	<tr>

		<td>${scheduleProduce.schedule.city},${scheduleProduce.schedule.address}</td>

		<td>${scheduleProduce.produce.produceName}</td>

		<td>${scheduleProduce.quantity}</td>

		<td>${scheduleProduce.date}</td>

		<%-- <td><a href="scheduleProduceAccept/${scheduleProduce.scheduleProduceId} }">Accept</a></td> --%>
		<td id="list${scheduleProduce.scheduleProduceId}">
			<form action='/scheduleProduceList' method='post'>
				<%-- <button type="button" id="accept${scheduleProduce.scheduleProduceId}" onclick="clickAccept(${scheduleProduce.scheduleProduceId})">Accept</button> --%>
				<%-- <p id="accept${scheduleProduce.scheduleProduceId}" style="display:none;"> --%>
					<input type='text' name ='quantity' placeholder='quantity'/>
					<input type='hidden' name = 'scheduleProduceId' value="${scheduleProduce.scheduleProduceId}"/>
					<input type='submit' value='submit'/>
				<!-- </p> -->
			</form>
		</td>

		
	</tr>
	</c:forEach>

	</table>


<a href="/scheduleFarmerProduceList">List of accepted deliveries</a>


</body>

</html>