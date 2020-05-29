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
	<h1>Welcome to Rent-A-Rig Admin Page </h1>
	<table class="table">
  	<thead class="thead-dark">
    	<tr>
     	 <th>Product Name</th>
     	 <th>Product ID</th>
      	 <th>Current Product Inventory</th>
      	 <th>Restock</th>
   		 </tr>
  </thead>
  
  <tbody>
	<c:forEach var="product" items="${cartRedirectEntity.products}">  
    	<tr>
      		<td>${product.name}</td>
      		<td>${product.id}</td>
      		<td>${product.inventory}</td>
      		<c:if test='${product.inventory < 5}'>
      			<td><button class="btn btn-success"> Restock </button></td>		
    		</c:if>
    	</tr>
	</c:forEach>
  </tbody>
</table>

		
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>