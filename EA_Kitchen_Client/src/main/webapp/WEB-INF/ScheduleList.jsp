<jsp:include page="header.jsp" flush="true">
	<jsp:param name="title" value=" Scheduled Kitchen List" />
</jsp:include>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<jsp:include page="footer.jsp" flush="true" />