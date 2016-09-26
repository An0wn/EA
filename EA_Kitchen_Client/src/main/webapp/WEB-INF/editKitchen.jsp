<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add kitchen</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>
</head>
<body>
<div class="container">
<h1>Edit kitchen</h1>
<form class="form" action="/kitchen/edit" method="post">
<input type="hidden" value="${kitchen.kitchenId}" name="kitchenId">
  <div class="form-group">
    <label class="col-sm-2 control-label" for="KitchenName">KitchenName</label>
    <div class="col-sm-10">
      <input class="form-control" type="text" id="KitchenName" value="${kitchen.kitchenName}" placeholder="KitchenName" name="kitchenName">
    </div>
  </div>
  <div class="form-group">
    <label class="col-sm-2 control-label" for="city">city</label>
    <div class="col-sm-10">
      <input class="form-control" type="text" value="${kitchen.city}" id="city" placeholder="city" name="city">
    </div>
  </div>
    <div class="form-group">
    <label class="col-sm-2 control-label" for="kitchenType">kitchenType</label>
    <div class="col-sm-10">
      <input class="form-control" type="text" id="kitchenType" placeholder="kitchenType" value="${kitchen.kitchenType}" name="kitchenType">
    </div>
  </div>
    <div class="form-group">
    <label class="col-sm-2 control-label" for="address">address</label>
    <div class="col-sm-10">
      <input class="form-control" type="text" id="address" placeholder="address" value="${kitchen.address}" name="address">
    </div>
  </div>
  <input type="submit" value="Edit kitchen"/>
</form>

</div>



	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
</body>
</html>