<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Kitchen List By Location</h1>
	<table>
		<tr>
			<th>Kitchen Name</th>
			<th>Address</th>
			<th>City</th>
			<th>Type</th>
			<th>Schedule</th>
			<!-- <td>Action</td> -->
		</tr>
		<c:forEach var="k" items="${kitchens}">
			<tr>
				<td>${k.kitchenName}</td>
				<td>${k.address}</td>
				<td>${k.city}</td>
				<td>${k.kitchenType}</td>
				<td>
					<form action="/schedulekitchen" method="post">
						<input type="hidden" name="kitchenId" value="${k.kitchenId}"/>
						<input type="submit" name="Schedule"/>
					</form>
				<%-- <a
					style="float: left; width: 100px; margin: 3px; border: 1px solid #dddddd; background: #eeeeee; text-align: center; text-decoration: none; padding: 2px; color: black"
					href="<c:url value="/schedulekitchen/${k.kitchenId }"/>">Schedule</a>
				 --%>
				 </td>
				<%-- <td><a href="scheduleProduceAccept/${scheduleProduce.scheduleProduceId} }">Accept</a></td> --%>
				<%-- <td id="list"+${scheduleProduce.scheduleProduceId}><button onclick="clickAccept(${scheduleProduce.scheduleProduceId})">Accept</a></td> --%>
			</tr>
		</c:forEach>
	</table>
</body>
</html>