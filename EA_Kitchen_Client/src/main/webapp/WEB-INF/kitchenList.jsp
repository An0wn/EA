<jsp:include page="header.jsp" flush="true">
	<jsp:param name="title" value="Kitchen List" />
</jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<a href="add" class="btn btn-info">Add kitchen</a>
<table class="table table-bordered">
	<tr>
		<th>ID</th>
		<th>kitchenName</th>
		<th>city</th>
		<th>kitchenType</th>
		<th>address</th>
		<th>Operation</th>

	</tr>
	<c:forEach var="kitchen" items="${kitchens}">
		<tr>
			<td>${ kitchen.kitchenId}</td>
			<td>${ kitchen.kitchenName}</td>
			<td>${ kitchen.city}</td>
			<td>${ kitchen.kitchenType}</td>
			<td>${ kitchen.address}</td>
			<td><a href="/kitchen/edit/${ kitchen.kitchenId}">Edit</a> <a
				href="/kitchen/delete/${ kitchen.kitchenId}">Delete</a></td>
		</tr>
	</c:forEach>
</table>


<jsp:include page="footer.jsp" flush="true" />
