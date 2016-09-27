<jsp:include page="header.jsp" flush="true">
	<jsp:param name="title" value="Farmer Produce List" />
</jsp:include>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Farmer Produce List</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>
<body>
	<h1>Farmer Produce</h1>
	<table class="table table-bordered">
		<tr>
			<th>Farmer name</th>
			<th>Quantity</th>
			<th>Quantity Available</th>
			<th>Produce Name</th>
			<th>Price</th>
		</tr>
		<c:forEach var="farmerProduce" items="${farmerProduces}">
			<tr>
				<td>${farmerProduce.farmer.username}</td>
				<td>${farmerProduce.quantity}</td>
				<td>${farmerProduce.remainingQuantity}</td>
				<td>${farmerProduce.produce.produceName}</td>
				<td>${farmerProduce.date}</td>
			</tr>
		</c:forEach>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
			integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
			crossorigin="anonymous"></script>
</body>
</html>

<jsp:include page="footer.jsp" flush="true" />