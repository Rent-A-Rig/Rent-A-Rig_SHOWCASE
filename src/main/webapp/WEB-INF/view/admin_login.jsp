<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">

		<h2 align="center">Sign-In as Admin</h2>
		<form:form id="loginForm" modelAttribute="login" action="adminloginprocess"
			method="post">
			<table align="center">
				<div class="form-group">
					<tr>
						<td><form:label path="username">Username: </form:label></td>
						<td><form:input path="username" name="username" id="username" />
							<form:errors path="username" class="text-danger"></form:errors></td>
					</tr>
				</div>

				<div class="form-group">
					<tr>
						<td><form:label path="password">Password:</form:label></td>
						<td><form:password path="password" name="password"
								id="password" /> <form:errors path="password"
								class="text-danger"></form:errors></td>
					</tr>

				</div>



				<tr>
					<td><form:button id="login" name="login"
							class="btn btn-primary">Login</form:button></td>
				</tr>

				<tr>
					<td><a href="home">Home</a></td>
				</tr>
				<tr>
					<td><a href="register">Create your Rent-A-Rig account</a></td>
				</tr>
			</table>
		</form:form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html> 
