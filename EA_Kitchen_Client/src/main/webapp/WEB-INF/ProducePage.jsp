<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produce List</title>
</head>
<body>
	<h1>PRODUCE required</h1>
	<table>
		<tr>
			<th>Produce Name</th>
			<th>Price</th>
			<th>Action</th>
		</tr>
		<c:forEach var="Produce"
			items="${Produces}">
			<tr>
				<td>${Produce.produceName}</td>
				<td>${Produce.producePrice}</td>
				<td>
					<form action="/produceList" method="post">
						<input type="number" name="quantity" min="1"/>
						<input type="hidden" name="produceId" value="${Produce.produceId}"/>
						<input type="submit" value="Add"/>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>