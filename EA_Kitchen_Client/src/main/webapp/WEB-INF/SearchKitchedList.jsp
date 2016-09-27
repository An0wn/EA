
<jsp:include page="header.jsp" flush="true">
	<jsp:param name="title" value=" Search Kitchen List" />
</jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table  class="table table-bordered">
	<tr>
		<th>Kitchen Name</th>
		<th>City</th>
		<th>Kitchen Type</th>
		<th>Address</th>
	</tr>
	<c:forEach var="k" items="${kitchens}">
		<tr>
			<td>${ k.kitchenName}</td>
			<td>${ k.city}</td>
			<td>${ k.kitchenType}</td>
			<td>${ k.address}</td>
			<td><form action="/schedulekitchen"
					method="post">
					<input type="text" name="kitchenId" value="${k.kitchenId}" /> <input type="submit" name="Schedule" />
				</form></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>