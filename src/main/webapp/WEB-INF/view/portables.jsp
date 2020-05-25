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

	<div class="container">
		<div class="col-xs-12 ">
			<nav>
				<div class="nav nav-tabs nav-pills nav-fill" id="nav-tab"
					role="tablist">
					<a class="nav-item nav-link active" id="nav-desktop-tab"
						data-toggle="tab" href="#nav-thinandlight" role="tab"
						aria-controls="nav-thinandlight" aria-selected="true"
						onclick="showAllPort()">Thin And Light</a> <a
						class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab"
						href="#nav-gaminglaptops" role="tab" aria-controls="nav-gaminglaptops"
						aria-selected="false" onclick="showAllPort()">Gaming Laptops</a> <a
						class="nav-item nav-link" id="nav-tablets-tab"
						data-toggle="tab" href="#nav-tablets" role="tab"
						aria-controls="nav-tablets" aria-selected="false"
						onclick="showAllPort()">Tablets</a>
				</div>
			</nav>

			<div class="tab-content py-3 px-3 px-sm-0" id="nav-tabContent">
				<div class="tab-pane fade show active" id="nav-thinandlight"
					role="tabpanel" aria-labelledby="nav-thinandlight-tab">
					<!-- Page Content -->
					<div class="container">
						<!-- Page Heading -->
						<h1 class="my-4">
							Thin And Light <small>Portable laptops for work on the go!</small>
						</h1>
						<!-- Gaming Rigs -->
						<c:forEach var="product" items="${tabOne}">
							<div class="product">
								<div class="row">
									<div class="col-md-5">
										<img class="img-fluid rounded center-block"
											src='<c:url value="/resources/images/${product.id}.jpg"/>'
											alt="">

									</div>
									<div class="col-md-7">
										<h3>${product.name}</h3>
										<p>${product.shortDesc}</p>
										<p>
											<b>Pricing: </b> $${product.price}/month
										</p>

										<c:if test='${product.inventory < 1}'>
											<button type="button" class="btn btn-primary">Out of
												Stock</button>
										</c:if>
										<c:if test='${product.inventory >= 1}'>
											<form:form modelAttribute="cartRedirectEntity"
												action="addToCart">
												<div class="number-input md-number-input float-left">
													<button type="button"
														onclick="this.parentNode.querySelector('input[type=number]').stepDown()"
														class="minus"></button>
													<form:input class="quantity" min="0" path="quantity"
														value="1" type="number" />
													<button type="button"
														onclick="this.parentNode.querySelector('input[type=number]').stepUp()"
														class="plus"></button>
												</div>
												<form:hidden path="filter"
													value="${cartRedirectEntity.filter}" />
												<form:hidden path="prodID" value="${product.id}" />
												<button type="submit" class="btn btn-primary">Add
													to Cart</button>
											</form:form>
										</c:if>

									</div>
									<div id="accordion" role="tablist" aria-multiselectable="true">
										<div class="card">
											<div class="card-header" role="tab"
												id="${product.id}_headingOne">
												<h5 class="mb-0">
													<a data-toggle="collapse" data-parent="#accordion"
														href="#${product.id}_Overview" aria-expanded="false"
														aria-controls="${product.id}_Overview"> Overview </a>
												</h5>
											</div>

											<div id="${product.id}_Overview" class="collapse"
												role="tabpanel" aria-labelledby="${product.id}_headingOne">
												<div class="card-block">
													<div>${product.longDesc}</div>
												</div>
											</div>
											<div class="card">
												<div class="card-header" role="tab"
													id="${product.id}_headingTwo">
													<h5 class="mb-0">
														<a class="collapsed" data-toggle="collapse"
															data-parent="#accordion" href="#${product.id}_Specs"
															aria-expanded="false" aria-controls="${product.id}_Specs">
															Specifications </a>
													</h5>
												</div>
												<div id="${product.id}_Specs" class="collapse"
													role="tabpanel" aria-labelledby="${product.id}_headingTwo">
													<div class="card-block">
														<div>${product.shortDesc}</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="tab-pane fade" id="nav-gaminglaptops"
					role="tabpanel" aria-labelledby="nav-gaminglaptops-tab">
					<!-- Page Content -->
					<div class="container">
						<!-- Page Heading -->
						<h1 class="my-4">
							Gaming Laptops <small>Powerful and compact!</small>
						</h1>
						<!-- Gaming Rigs -->
						<c:forEach var="product" items="${tabTwo}">
							<div class="product">
								<div class="row">
									<div class="col-md-5">
										<img class="img-fluid rounded center-block"
											src='<c:url value="/resources/images/${product.id}.jpg"/>'
											alt="">

									</div>
									<div class="col-md-7">
										<h3>${product.name}</h3>
										<p>${product.shortDesc}</p>
										<p>
											<b>Pricing: </b> $${product.price}/month
										</p>

										<c:if test='${product.inventory < 1}'>
											<button type="button" class="btn btn-primary">Out of
												Stock</button>
										</c:if>
										<c:if test='${product.inventory >= 1}'>
											<form:form modelAttribute="cartRedirectEntity"
												action="addToCart">
												<div class="number-input md-number-input float-left">
													<button type="button"
														onclick="this.parentNode.querySelector('input[type=number]').stepDown()"
														class="minus"></button>
													<form:input class="quantity" min="0" path="quantity"
														value="1" type="number" />
													<button type="button"
														onclick="this.parentNode.querySelector('input[type=number]').stepUp()"
														class="plus"></button>
												</div>
												<form:hidden path="filter"
													value="${cartRedirectEntity.filter}" />
												<form:hidden path="prodID" value="${product.id}" />
												<button type="submit" class="btn btn-primary">Add
													to Cart</button>
											</form:form>
										</c:if>

									</div>
									<div id="accordion" role="tablist" aria-multiselectable="true">
										<div class="card">
											<div class="card-header" role="tab"
												id="${product.id}_headingOne">
												<h5 class="mb-0">
													<a data-toggle="collapse" data-parent="#accordion"
														href="#${product.id}_Overview" aria-expanded="false"
														aria-controls="${product.id}_Overview"> Overview </a>
												</h5>
											</div>

											<div id="${product.id}_Overview" class="collapse"
												role="tabpanel" aria-labelledby="${product.id}_headingOne">
												<div class="card-block">
													<div>${product.longDesc}</div>
												</div>
											</div>
											<div class="card">
												<div class="card-header" role="tab"
													id="${product.id}_headingTwo">
													<h5 class="mb-0">
														<a class="collapsed" data-toggle="collapse"
															data-parent="#accordion" href="#${product.id}_Specs"
															aria-expanded="false" aria-controls="${product.id}_Specs">
															Specifications </a>
													</h5>
												</div>
												<div id="${product.id}_Specs" class="collapse"
													role="tabpanel" aria-labelledby="${product.id}_headingTwo">
													<div class="card-block">
														<div>${product.shortDesc}</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="tab-pane fade" id="nav-tablets"
					role="tabpanel" aria-labelledby="nav-tablets-tab">
					<!-- Page Content -->
					<div class="container">
						<!-- Page Heading -->
						<h1 class="my-4">
							Tablets <small>Small Portable devices on the go!</small>
						</h1>
						<!-- Gaming Rigs -->
						<c:forEach var="product" items="${tabThree}">
							<div class="product">
								<div class="row">
									<div class="col-md-5">
										<img class="img-fluid rounded center-block"
											src='<c:url value="/resources/images/${product.id}.jpg"/>'
											alt="">

									</div>
									<div class="col-md-7">
										<h3>${product.name}</h3>
										<p>${product.shortDesc}</p>
										<p>
											<b>Pricing: </b> $${product.price}/month
										</p>

										<c:if test='${product.inventory < 1}'>
											<button type="button" class="btn btn-primary">Out of
												Stock</button>
										</c:if>
										<c:if test='${product.inventory >= 1}'>
											<form:form modelAttribute="cartRedirectEntity"
												action="addToCart">
												<div class="number-input md-number-input float-left">
													<button type="button"
														onclick="this.parentNode.querySelector('input[type=number]').stepDown()"
														class="minus"></button>
													<form:input class="quantity" min="0" path="quantity"
														value="1" type="number" />
													<button type="button"
														onclick="this.parentNode.querySelector('input[type=number]').stepUp()"
														class="plus"></button>
												</div>
												<form:hidden path="filter"
													value="${cartRedirectEntity.filter}" />
												<form:hidden path="prodID" value="${product.id}" />
												<button type="submit" class="btn btn-primary">Add
													to Cart</button>
											</form:form>
										</c:if>

									</div>
									<div id="accordion" role="tablist" aria-multiselectable="true">
										<div class="card">
											<div class="card-header" role="tab"
												id="${product.id}_headingOne">
												<h5 class="mb-0">
													<a data-toggle="collapse" data-parent="#accordion"
														href="#${product.id}_Overview" aria-expanded="false"
														aria-controls="${product.id}_Overview"> Overview </a>
												</h5>
											</div>

											<div id="${product.id}_Overview" class="collapse"
												role="tabpanel" aria-labelledby="${product.id}_headingOne">
												<div class="card-block">
													<div>${product.longDesc}</div>
												</div>
											</div>
											<div class="card">
												<div class="card-header" role="tab"
													id="${product.id}_headingTwo">
													<h5 class="mb-0">
														<a class="collapsed" data-toggle="collapse"
															data-parent="#accordion" href="#${product.id}_Specs"
															aria-expanded="false" aria-controls="${product.id}_Specs">
															Specifications </a>
													</h5>
												</div>
												<div id="${product.id}_Specs" class="collapse"
													role="tabpanel" aria-labelledby="${product.id}_headingTwo">
													<div class="card-block">
														<div>${product.shortDesc}</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
