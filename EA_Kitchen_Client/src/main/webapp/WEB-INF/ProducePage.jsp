<jsp:include page="header.jsp" flush="true">
	<jsp:param name="title" value="Produce List" />
</jsp:include>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produce List</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>
<body>
	<h1>Produce</h1>
	<table class="table table-bordered">
		<tr>
			<th>Produce Name</th>
			<th>Price</th>
			<th>Action</th>
		</tr>
		<c:forEach var="Produce" items="${Produces}">
			<tr>
				<td>${Produce.produceName}</td>
				<td>${Produce.producePrice}</td>
				<td>
					<form action="/produceList" method="post">
						<input type="number" name="quantity" min="1"/>
						<input type="hidden" name="produceId" value="${Produce.produceId}"/>
						<input type="submit" value="Add" />
					</form>
				</td>
			</tr>
		</c:forEach>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
			integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
			crossorigin="anonymous"></script>
</body>
</html>

<jsp:include page="footer.jsp" flush="true" />