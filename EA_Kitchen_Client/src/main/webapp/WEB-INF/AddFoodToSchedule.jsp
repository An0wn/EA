<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Schedule Produce List</title>
</head>
<body>

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
		       				<option value="${produce.produceId}" >${produce.produceName}</option>
		       				<!-- selected="${produce.produceId == selectedProduceId ? 'selected' : ''" -->
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

</body>
</html>