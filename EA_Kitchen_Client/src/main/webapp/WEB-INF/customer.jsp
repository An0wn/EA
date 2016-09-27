<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Kitchen</title>
</head>
<body>
	<h2>Search Kitchen</h2>
	<p>${error}</p>
	<form action="/searchKitchen" method="get">
		<div>
			<label for="Address">Address</label> <input type="text"
				name="Address" id="Address" required autofocus>
		</div>

		<button type="submit">Search</button>
	</form>
	
</body>
</html>