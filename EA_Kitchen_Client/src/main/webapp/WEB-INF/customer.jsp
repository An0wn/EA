
<jsp:include page="Customerheader.jsp" flush="true">
	<jsp:param name="title" value=" Search Kitchen" />
</jsp:include>
<div style="margin: 0 auto; width: 1200px">
	<h2>Search Kitchen</h2>
	<p>${error}</p>
	<form action="/searchKitchen" method="get">
			<label for="Address">Address</label> <input type="text"
				name="Address" id="Address" required autofocus>

		<button type="submit">Search</button>
	</form>
</div>

<jsp:include page="footer.jsp" flush="true" />