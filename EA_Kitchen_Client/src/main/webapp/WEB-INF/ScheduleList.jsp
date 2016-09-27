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
<div>
Customer Info<br/>
User Name:${currenUser.username}<br/>
Role :${currenUser.userRole}<br/>
</div>
<table>
		<tr>
			<th>Kitchen Name</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th>Add Food</th>
		</tr>
		<c:forEach var="s" items="${schedules}">
			<tr>
			<td>${k.kitchen.kitchenName}</td>
				<td>${s.startDate}</td>
				<td>${s.endDate}</td>
				<td>${k.city}</td>
				<td><form action="/addFoodToSchedule/${s.scheduleId}" method="get">
						<input type="submit" name="Add Food"/>
					</form></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>