<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!-- 	navigation Bar -->
<%@ include file="navbar.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Cart Management</title>
	<link rel="icon" type="image/x-icon"
		  href="<c:url value="/resource/images/favicon1.png"/>" />
	<link rel="stylesheet"
		  href="<c:url value="/resource/bootstrap/css/bootstrap.min.css"/>">
	<script src="<c:url value="/resource/js/jquery.js"/>"></script>
	<script src="<c:url value="/resource/bootstrap/js/bootstrap.min.js"/>"></script>
	<link rel="stylesheet" type="text/css"
		  href="<c:url value="/resource/css/ProductList.css"/>">
	<script
			src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
	<script src="<c:url value="/resource/js/productController.js"/>"></script>
</head>
<body>
<div class="container"
	 style="width: 1145px; margin-top: 20px; margin-bottom: 180px;">
	<div ng-app="myapp" ng-controller="myController"
		 style="margin-bottom: 30px">
		<div ng-init="getCart(${carts.cartId})">
	<h2>Cart Management</h2>
	<p>The List of Cart Items in our Database</p>
		<div>

			<a class="btn btn-danger pull-left" ng-click="clearCart()"
			   style="margin-top: 15px; margin-left: 20px"> <span
					class="glyphicon glyphicon-remove-sign"> </span>Clear Cart
			</a>
		</div>
		<div>
			<c:url value="/order/${carts.cartId}" var="url1"></c:url>
			<a href="${url1}" class="btn btn-danger pull-left"
			   style="margin-top: 15px; margin-left: 20px"> <span
					class="glyphicon glyphicon-shipping-cart"> </span>Check Out
			</a>
		</div>
	<table class="table table-hover" id="cartItemList">
		<thead>
		<tr>
			<th>Product Name</th>
			<th>Quantity</th>
			<th>Price</th>
			<th>Total Price</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${carts.getCartItem()}" var="car">
			<tr>
				<td>${car.getProduct().productName}</td>
				<td>${car.quality}</td>
				<td>${car.getProduct().productPrice}</td>
				<td>${car.getPrice()}</td>
				<td><a href="#" class="btn btn-danger"
					   ng-click="removeFromCart(${car.cartItemId})"
					   style="margin-top: 0px;"><span
						class="glyphicon glyphicon-trash"></span>remove</a>
				</td>

			</tr>
		</c:forEach>
		</tbody>
	</table>
		<span >Grand Total Price: {{grandTotal}} </span>
		</div>

		<c:url value="/getAllProducts" var="url"></c:url>
	<a href="${url}" class="btn btn-default" style="margin-left: 20px">Continue
		Shopping</a>


	</div>
		</div>


</body>