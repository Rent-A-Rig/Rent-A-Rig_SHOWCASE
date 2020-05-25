<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta charset="ISO-8859-1">

<link href='<spring:url value="/resources/css/mainStyles.css"/>' rel="stylesheet">
<link href='<spring:url value="/resources/css/homePage.css" />' rel="stylesheet">

<title>Rent-A-Rig</title>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="jumbotron mb-0 image1">
		<div class="container">
			<h1 class="display-3 text-warning">Rent-A-Rig&#169</h1>
			<h2 class="text-warning">The Right Rig For All Your Needs</h2>
			<button type="button" class="btn btn-secondary" data-toggle="modal"
			data-target="#exampleModalScrollable">About US</button>
		</div>
		
		<div class="modal" id="exampleModalScrollable" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalScrollableLabel"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-scrollable" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalCenteredLabel">Rent
							Powerful Technology For Your Event</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true"></span>
						</button>
					</div>
					<div class="modal-body">At Rent-A-Rig, we understand the
						importance of receiving the highest quality equipment delivered
						safely, on time, and stress-free to your event. We rent powerful
						gaming machines, notebooks, and tablets featuring Intel
						architecture, and monitors, and other needs for your event. With
						professionally managed inventory and competitive pricing, you can
						trust us with your technology, performance, and budgetary needs.</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="card-deck">
		<div class="card m-0">
			<div class="card-body">
				<h3 class="card-text">Portable PCs</h3>
			</div>
			<img class="image2">
			<div class="card-body">
				<a href="products?filter=portable" class="go-btn btn btn-info">See More</a>
			</div>
		</div>
		<div class="card m-0">
			<div class="card-body">
				<h3 class="card-text">Gaming Desktops</h3>
			</div>
			<img class="image3">
			<div class="card-body">
				<a href="products?filter=gamingrigs" class="go-btn btn btn-info">See More</a>
			</div>
		</div>
		<div class="card m-0">
			<div class="card-body">
				<h3 class="card-text">Accessories</h3>
			</div>
			<img class="image4">
			<div class="card-body">
				<a href="products?filter=accessories" class="go-btn btn btn-info">See More</a>
			</div>
		</div>

	</div>
	<div class="container6">
		<h2 style="color: white;">Learn More About Us</h2>
		<a href="faq" class="go-btn btn btn-warning">FAQ</a>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
