<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<link href='<spring:url value="/resources/css/mainStyles.css"/>'
	rel="stylesheet">
<link href='<spring:url value="/resources/css/orders.css"/>'
	rel="stylesheet">
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<!-- BEGIN INVOICE -->
			<div class="col-xs-12 order-container">
				<div class="grid invoice">
					<div class="grid-body">
						<div class="invoice-title">
							<div class="row justify-content-center">
								<div class="col-xs-12">
									<img src='<spring:url value="/resources/images/logo.png"/>'
										alt="" height="200">
								</div>

							</div>
							<div class="row justify-content-center">
								<div class="col-xs-12">
									<strong>Thank You For Ordering!</strong>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<h2>
										invoice<br> <span class="small">order #${order.id}</span>
									</h2>
								</div>
							</div>
						</div>
						<hr>
						<div class="row justify-content-between">
							<div class="col-xs-6 float-left">
								<address>
									<strong>Billed To:</strong><br>${user.firstname} ${user.lastname}<br>
									${user.address.line1}, ${user.address.line2}<br>
									${user.address.state}, ${user.address.zip}<br> <abbr
										title="Phone">P:</abbr> ${user.phone}
								</address>
							</div>
							<div class="col-xs-6 text-right float-right">
								<address>
									<strong>Shipped To:</strong><br>${user.firstname} ${user.lastname}<br>
									${user.address.line1}, ${user.address.line2}<br>
									${user.address.state}, ${user.address.zip}<br> <abbr
										title="Phone">P:</abbr> ${user.phone}
								</address>
							</div>
						</div>
						<div class="row justify-content-between">
							<div class="col-xs-6">
								<address>
									<strong>Payment Method:</strong><br> Credit Card<br>
									${user.email}<br>
								</address>
							</div>
							<div class="col-xs-6 text-right float-right">
								<address>
									<strong>Order Date:</strong><br> ${order.date}
								</address>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<h3>ORDER SUMMARY</h3>
								<table class="table table-striped">
									<thead>
										<tr class="line">
											<td class="text-center"><strong>PRODUCT</strong></td>
											<td class="text-center quantity-col"><strong>QTY</strong></td>
											<td class="text-right total-col"><strong>SUBTOTAL</strong></td>
										</tr>
									</thead>
									<tbody>
									<c:forEach var="item" items="${order.items}">
										<tr>
											<td class="order-row"><strong>${item.product.name}</strong><br>
												${item.product.shortDesc}</td>
											<td class="text-center">${item.qty}</td>
											<td class="text-right">$${item.product.price * item.qty}</td>
										</tr>
									</c:forEach>
										<tr>
											<td colspan="1"></td>
											<td class="text-right"><strong>Taxes</strong></td>
											<td class="text-right"><strong>N/A</strong></td>
										</tr>
										<tr>
											<td colspan="1"></td>
											<td class="text-right"><strong>Total</strong></td>
											<td class="text-right"><strong>$${order.total}</strong></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- END INVOICE -->
		</div>
	</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>