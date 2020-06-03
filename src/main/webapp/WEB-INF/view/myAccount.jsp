<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Account</title>
<link href='<spring:url value="/resources/css/myAccount.css"/>'
	rel="stylesheet">
<link href='<spring:url value="/resources/css/mainStyles.css"/>'
	rel="stylesheet">
<!-- <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"> -->

<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<style type="text/css">
button {
	text-align: center;
}
</style>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<jsp:include page="header.jsp"></jsp:include>
	<br>

	<div class="bodystuff">
		<!--    Model Data = user, Model Name = "user" -->
		<h2>Account Information</h2>
		<table align="center">
			<tr>
				<th colspan="3">Membership Type:</th>
				<td>Gold Star</td>
			<tr>
				<th colspan="3">Username:</th>
				<td>${username}</td>
			</tr>
			<tr>
				<th colspan="3">First name:</th>
				<td>${firstname}</td>
			</tr>
			<tr>
				<th colspan="3">Last name:</th>
				<td>${lastname}</td>
			</tr>
			<tr>
				<th colspan="3">Email:</th>
				<td>${email}</td>
			</tr>
			<tr>
				<th colspan="3">Phone Number:</th>
				<td>${phone}</td>
			</tr>
			<form:form action="updateinfo" method="post" modelAttribute="address">
				<tr>
					<th colspan="3">Type of Address:</th>
					<td>${placeatt}</td>
				</tr>
				<tr>
					<th colspan="3">Street Address:</th>
					<td>${streetatt}</td>
				</tr>
				<tr>
					<th colspan="3">City:</th>
					<td>${cityatt}</td>
				</tr>
				<tr>
					<th colspan="3">State:</th>
					<td>${stateatt}</td>
				</tr>
				<tr>
					<th colspan="3">Zip:</th>
					<td>${zipatt}</td>
				</tr>


				<hr>
				<p>
		</table>
		<button id="updateinfo" name="updateinfo" class="btn btn-primary">Update
			Address here</button>
	</div>

	</form:form>
	<form:form action="orderhistory" method="get">
		<br>
		<button name="orderhistory" type="submit" class="btn btn-primary">View
			Order History</button>
	</form:form>
	<br>
	<br>
	<h6>More Features Will Be Coming Soon... To A Rent-A-Rig Near You!
		;)</h6>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>