<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div style="margin: 0 auto; width: 300px">
		<br /> <br />
		<h2>KBNB Kitchen</h2>
		<br /> <br />
		<form action="/login" method="post">
			<div style="float: left; padding: 8px 0px">
				<label for="userName">User Name</label> <input type="text"
					name="username" id="username" required autofocus>
			</div>
			<br />
			<div style="float: left; padding: 8px 0px">
				<label for="password">Password</label> <input type="password"
					name="password" id="password" required>
			</div>
			<br />
			<div style="float: left; padding: 8px 0px">
				<button style="margin-left: 74px" type="submit">Sign in</button>
			</div>
		</form>
	</div>
	<br />
	<div style="color: red;">${error }></div>

	<#if error.isPresent()>
	<p>The email or password you have entered is invalid, try again.</p>
	</#if>
</body>
</html>