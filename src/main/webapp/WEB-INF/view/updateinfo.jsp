<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Registration</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<h2>Update Account Information</h2>
		<form:form action="updateMyAccountInfo" method="post"
			modelAttribute="address">
			<table align="center">
				<%-- <div class="form-group">
					<tr>
						<td><label for="firstname">First Name: </label>
						<td><input name="firstname" value="${user.firstname }" /></td>
					</tr>
				</div>
				<div class="form-group">
					<tr>
						<td><label for="lastname">Last Name: </label>
						<td><input name="lastname" value="${user.lastname }" /></td>
					</tr>
				</div>
				<div class="form-group">
					<tr>
						<td><label for="email">Email: </label>
						<td><input name="email" value="${user.email }" /></td>
					</tr>
				</div>
				<div class="form-group">
					<tr>
						<td><label for="phone">Phone Number: </label>
						<td><input name="phone" value="${user.phone }" /></td>
					</tr>
				</div> --%>
				<div class="form-group">
					<tr>
						<td><input type="hidden" name="username"
							value="${cookie.username.value }"></td>
					</tr>
				</div>
				<div class="form-group">
					<tr>
						<td><label for="street">Street: </label>
						<td><input name="street" value="${user.street }" /></td>
					</tr>
				</div>
				<div class="form-group">
					<tr>
						<td><label for="city">City: </label>
						<td><input name="city" value="${user.city }" /></td>
					</tr>
				</div>
				<div class="form-group">
					<tr>
						<td><label for="state">State: </label>
						<td><input name="state" value="${user.state }" /></td>
					</tr>
				</div>
				<div class="form-group">
					<tr>
						<td><label for="zip">Zip Code: </label>
						<td><input name="zip" value="${user.zip }" /></td>
					</tr>
				</div>
				<div class="form-group">
					<tr>
						<td><label for="place">Place: </label>
						<td><select name="place">
								<option value="shipping">shipping</option>
								<option value="billing">billing</option></td>
						</select>
					</tr>
				</div>
				<div class="fomr-group">
					<tr>
						<td><button id="home" name="home" class="btn btn-primary">Submit</button>
					</tr>
				</div>
			</table>
		</form:form>
	</div>
</body>
</html>