<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
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

<link href='<spring:url value="/resources/css/products.css"/>'
	rel="stylesheet">
<link href='<spring:url value="/resources/css/mainStyles.css"/>'
	rel="stylesheet">
</head>
<body>

	<jsp:include page="navbar.jsp"></jsp:include>
	<jsp:include page="header.jsp"></jsp:include>
	<div>
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<ul class="navbar-nav">

				<li class="nav-item"><a class="nav-link" href="adminhome">New
						Requests</a></li>
				<li class="nav-item"><a class="nav-link" href="pendingRequests">Pending
						Requests</a></li>
				<li class="nav-item"><a class="nav-link"
					href="previousRequests">Closed Requests</a></li>
				<li class="nav-item"><a class="nav-link" href="allRequests">All
						Requests</a></li>
			</ul>
		</nav>
	</div>
	<h1>${title}</h1>
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th>Product Name</th>
				<th>Product ID</th>
				<th>Requested Amount</th>
				<th>Request Status</th>
				<th>Request Date</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="request" items="${requests}">
				<form:form modelAttribute="product" action="requestInventory">
					<tr>
						<td>${request.product_name}</td>
						<td>${request.product_id}</td>
						<td>${request.request_qty}</td>
						<td>${request.fulfilled}</td>
						<td>${request.request_date}</td>
					</tr>

				</form:form>
			</c:forEach>
		</tbody>
	</table>


	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>