<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>
<body>
	<h1>Kitchen List</h1>
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
				<td><a href="/kitchen/edit/${ kitchen.kitchenId}">Edit</a>
				<a href="/kitchen/delete/${ kitchen.kitchenId}" >Delete</a>
				 </td>
			</tr>
		</c:forEach>
	</table>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
</body>
</html>