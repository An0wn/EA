<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kitchen Application</title>
</head>
<body>
	<h2>Schedule Kitchen</h2>
	<div>
		Kitchen Name:${currentKitchen.kitchenName}<br /> Kitchen
		Type:${currentKitchen.kitchenType}<br />
		ID:${schedule.kitchen.kitchenId}<br />
	</div>
	<br />
	<br />
	<form:form action="/saveschedulekitchen" method="post" modelAttribute="schedule">
		Start Date<form:input type="date" path="startDate" /><font color="red"><form:errors path="startDate" /></font>
		<br />
		End Date<form:input type="date" path="endDate" /><font color="red"><form:errors path="endDate" /></font>
		<br />
		<button type="submit">Schedule</button>
	</form:form>
</body>
</html>