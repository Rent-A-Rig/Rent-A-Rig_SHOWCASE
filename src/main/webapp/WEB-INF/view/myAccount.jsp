<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Account</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<style>
.bodystuff {
	font-family: arial;
	color: dark-grey;
	margin-top: 20px;
}

.welcome1 {
	font-size: 48;
	letter-spacing: 0.2em;
	text-align: center;
	border: 1px solid #665544;
	paddint: 10px;
}

p {
	padding: 15px;
}

h2 {
	letter-spacing: 0.2em;
	text-align: center;
	border: 1px solid #665544;
	paddint: 10px;
}
</style>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<jsp:include page="header.jsp"></jsp:include>
	<br>
	<div class="welcome1">
		<h1>W * E * L * C * O * M * E</h1>
		<h5>this your your account information page... Please don't let
			anyone else see it. that's how identity theft happens.</h5>
	</div>
	<div class="bodystuff">

		<!-- 	Model Data = user, Model Name = "user" -->

		<p>
			<u>Username:</u><br>${user.username}</p>
		<br>
		<form:form action="updateMyAccountInfo" method="post"
			modelAttribute="user">
			<p>
				<u>first name:</u><br> ${user.firstname}
				<form:input path="username" name="username" id="username" value="${user.username}"/>
			</p>
			<br>
			<p>
				<u>last name:</u><br> ${user.lastname}
			</p>
			<br>
			<p>
				<u>email:</u><br> ${user.email}
			</p>
			<br>
			<p>
				<u>phone:</u><br> ${cookie.phone.value}
			</p>
			<br>
			<p>
				<u>phone:</u><br> ${user.address.line1}
			</p>
			<br>
			<p>
				<u>phone:</u><br> ${user.address.city}
			</p>
			<br>
			<p>
				<u>phone:</u><br> ${user.address.state}
			</p>
			<br>
			<p>
				<u>phone:</u><br> ${user.address.zip}
			</p>
		</form:form>
		>
	</div>
	<br>
	<br>
	<h2>More Features Will Be Coming Soon... To A Rent-A-Rig Near You!
		;)</h2>
	<br>
	<a href="orderhistory"> View Order History </a>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>