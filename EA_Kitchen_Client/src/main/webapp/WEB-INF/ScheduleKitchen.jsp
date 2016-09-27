<jsp:include page="Customerheader.jsp" flush="true">
	<jsp:param name="title" value=" Schedule Kitchen" />
</jsp:include><%@taglib prefix="form"
	uri="http://www.springframework.org/tags/form"%>

<h2>Schedule Kitchen</h2>
<div>
	Kitchen Name:${currentKitchen.kitchenName}<br /> Kitchen
	Type:${currentKitchen.kitchenType}<br />
	ID:${schedule.kitchen.kitchenId}<br />
</div>
<br />
<br />
<form:form action="/saveschedulekitchen" method="post"
	modelAttribute="schedule">
		Start Date<form:input type="date" path="startDate" />
	<font color="red"><form:errors path="startDate" /></font>
	<br />
		End Date<form:input type="date" path="endDate" />
	<font color="red"><form:errors path="endDate" /></font>
	<br />
	<button type="submit">Schedule</button>
</form:form>
<jsp:include page="footer.jsp" flush="true" />