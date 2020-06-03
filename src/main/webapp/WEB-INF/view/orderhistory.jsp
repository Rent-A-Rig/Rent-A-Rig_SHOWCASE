<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<link href='<c:url value="/resources/css/orders.css"/>' rel="stylesheet">
<link href='<c:url value="/resources/css/mainStyles.css"/>'
	rel="stylesheet">
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
		<div class="row justify-content-center">
			<h1>Order History</h1>
		</div>
		<div class="row">
			<!-- BEGIN INVOICE -->
			<div class="col-xs-12 order-container">
				<div class="grid invoice">
					<div class="grid-body">
						<c:forEach var="order" items="${orderhistory}">
							<div class="invoice-title">
								<div class="row">
									<div class="col-xs-12">
										<h2>
											invoice<br> <span class="small">order
												#${order.id}</span>
										</h2>
									</div>
								</div>
							</div>
							<hr>
							<div class="row justify-content-between">
								<div class="col-xs-6 float-left">
									<address>
										<strong>Billed To:</strong><br>${user.firstname}
										${user.lastname}<br> <abbr title="Phone">P:</abbr>
										${user.phone}
									</address>
								</div>
								<div class="col-xs-6 text-right float-right">
									<address>
										<strong>Shipped To:</strong><br>${user.firstname}
										${user.lastname}<br> <abbr title="Phone">P:</abbr>
										${user.phone}
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
							<div class="row table-row">
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
													<td class="text-right"><fmt:formatNumber
															value="${item.product.price * item.qty}" type="currency" />/month</td>
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
												<td class="text-right"><strong><fmt:formatNumber
															value="${order.total}" type="currency" />/month</strong></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<!-- END INVOICE -->
		</div>
	</div>

</body>
</html>