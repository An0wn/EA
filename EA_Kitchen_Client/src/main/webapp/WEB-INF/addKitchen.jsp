<jsp:include page="header.jsp" flush="true">
 <jsp:param name="title" value="Add Kitchen"/>
</jsp:include>

	<div class="container">
		<h1>Add kitchen</h1>
		<form class="form" action="add" method="post" data-toggle="validator">
			<div class="form-group">
				<label class="col-sm-2 control-label" for="KitchenName">KitchenName</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="KitchenName"
						placeholder="KitchenName" name="kitchenName" required>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="city">city</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="city"
						placeholder="city" name="city" required>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="kitchenType">kitchenType</label>
				<div class="col-sm-10">
					<select name="kitchenType" class="form-control">
						<option>COMMERCIAL</option>
						<option>REGULAR</option>
					</select> 
<!-- 					<input class="form-control" type="text" id="kitchenType" -->
<!-- 						placeholder="kitchenType" name="kitchenType"> -->
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="address">address</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="address"
						placeholder="address" name="address" required>
				</div>
			</div>
			<input type="submit" value="Add kitchen" />
		</form>

	</div>



	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
</body>
</html>