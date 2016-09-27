<jsp:include page="header.jsp" flush="true">
 <jsp:param name="title" value="Edit Kitchen"/>
</jsp:include>

<div class="container">
		<h1>Edit kitchen</h1>
		<form class="form" action="/kitchen/edit" method="post">
			<input type="hidden" value="${kitchen.kitchenId}" name="kitchenId">
			<div class="form-group">
				<label class="col-sm-2 control-label" for="KitchenName">KitchenName</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="KitchenName"
						value="${kitchen.kitchenName}" placeholder="KitchenName"
						name="kitchenName">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="city">city</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" value="${kitchen.city}"
						id="city" placeholder="city" name="city">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="kitchenType">kitchenType</label>
				<div class="col-sm-10">
					<select name="kitchenType" class="form-control">
						<option>COMMERCIAL</option>
						<option>REGULAR</option>
					</select>
					<%--       <input class="form-control" type="text" id="kitchenType" placeholder="kitchenType" value="${kitchen.kitchenType}" name="kitchenType"> --%>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="address">address</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="address"
						placeholder="address" value="${kitchen.address}" name="address">
				</div>
			</div>
			<input type="submit" value="Edit kitchen" />
		</form>

	</div>



	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
</body>
</html>