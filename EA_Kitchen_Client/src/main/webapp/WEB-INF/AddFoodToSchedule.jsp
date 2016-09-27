<jsp:include page="header.jsp" flush="true">
 <jsp:param name="title" value="Add Food To Schedule"/>
</jsp:include>

<script>
	function addFood(){
		var holderDiv = document.getElementById("holderDiv");
	    var cln = holderDiv.cloneNode(true);
	    document.getElementById("divToAppend").appendChild(cln);
	}
</script>


	<div class="container">
		<h1>Add Food To Schedule</h1>
		
		<table>
			<tr>
				<th>Produce</th>
				<th>Asked Quantity</th>
				<th>Recieved Quantity</th>
			</tr>
			
			<c:forEach var="scheduleProduce" items="${scheduleProduces}">
				<td>${scheduleProduce.produce.name}</td>
				<td>${scheduleProduce.quantity}</td>
				<td>${scheduleProduce.remainingQuantity}</td>
			</c:forEach>
			
		</table>
		
		
		
		
		<from id="aFrom" class="form" method="post" action="addFoodToKitchen">
		
		<div id="divToAppend">
			<div id="selectProduce">
					<select id="selectProduce" name="produces[]">
		   				<c:forEach var="produce" items="${produces}">
		       				<option value="${produce.produceId} selected=${produce.produceId == selectedProduceId ? 'selected' : ''">${produce.produceName}</option>
		   				</c:forEach>
					</select>
					<input type="number" min="1" name="quantity[]">
			</div>
		</div>
		
		
			<button type="button" onclick="addFood()">Add More Food</button>
			<br/>
			<input type="submit" name="Submit Orders"/>
		
		</from>

	</div>



	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
</body>
</html>