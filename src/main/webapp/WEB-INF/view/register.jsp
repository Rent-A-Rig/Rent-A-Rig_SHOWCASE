<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<h2 align="center">Create account</h2>
	<form:form action="registerProcess" method="post" modelAttribute="user">
		<table align="center">
			<div class="form-group">
			<tr>
				<td><form:label path="username">Username: </form:label></td>
				<td>
					<form:input path="username" name="username" id="username" placeholder="Enter username"/>
					<form:errors path="username" class="text-danger"></form:errors>
				</td>	
			</tr>
			</div>
			
			<div class="form-group">
			<tr>
				<td><form:label path="password">Password: </form:label></td>
				<td>
					<form:password path="password" name="password" id="password" placeholder="Enter password"/>
					<form:errors path="password" class="text-danger"></form:errors>
				</td>
			</tr>
			</div>
			
			<div class="form-group">
			<tr>
				<td><form:label path="firstname">FirstName: </form:label></td>
				<td>
					<form:input path="firstname" name="firstname" id="firstname" placeholder="Enter firstname"/>
					<form:errors path="firstname" class="text-danger"></form:errors>
				</td>
			</tr>
			</div>
			
			<div class="form-group">
			<tr>
				<td><form:label path="lastname">LastName: </form:label></td>
				<td>
					<form:input path="lastname" name="lastname" id="lastname" placeholder="Enter lastname"/>
					<form:errors path="lastname" class="text-danger"></form:errors>
				</td>
			</tr>
			</div>
			
			<div class="form-group">
			<tr>
				<td><form:label path="email">Email: </form:label></td>
				<td>
					<form:input path="email" name="email" id="email" placeholder="Ex:email@domain.com"/>
					<form:errors path="email" class="text-danger"></form:errors>
				</td>
			</tr>
			</div>
			
			<div class="form-group">
			<tr>
				<td><form:label path="phone">Phone: </form:label></td>
				<td>
					<form:input path="phone" name="phone" id="phone" placeholder="Ex:123-456-7890" />
					<form:errors path="phone" class="text-danger"></form:errors>
				</td>
			</tr>
			</div>
			
			<tr>
				<td></td>
				<td><form:button id="register" name="register" class="btn btn-primary">Register</form:button>
				</td>
			</tr>
			
			
			<tr>
				<td><a href="home">Home</a></td>
			</tr>
			<tr>
				<td><a href="login">Already have an account ? Sign-In</a></td>
			</tr>
		</table>
	</form:form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	
</body>
</html>
