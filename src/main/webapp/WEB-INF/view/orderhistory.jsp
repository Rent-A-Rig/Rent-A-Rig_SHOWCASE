<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<jsp:include page="header.jsp"></jsp:include>
	
	<h1>Order History</h1><br>

	<c:forEach var="order" items="${orderhistory.orders}">
	<br>
		<div class="container">
			<h4>OrderID: ${order.id} <br> Order Date: ${order.date}</h4>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Product Name</th>
						<th>Quantity</th>
						<th>Price per Item</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${order.items}">
						<tr>
							<td>${item.product.name}</td>
							<td>${item.qty}</td>
							<td>${item.product.price}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		</c:forEach>
		<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>