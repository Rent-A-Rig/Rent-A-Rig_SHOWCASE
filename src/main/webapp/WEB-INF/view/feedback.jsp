<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Feedback</title>=
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<link rel="stylesheet" href="css/mainStyles.css" type="text/css">
<link rel="stylesheet" href="css/ContactInfoStyle.css"
	type="text/css">
<script src="js/Rent-A-Rig.js"></script>
	
</head>
<body>
<div class="myNav">
    <p></p><nav id="navbar"></nav></div>
    <header id="header"></header>
<!--Navigation Section-->
	<div class="container-fluid headofpage">
		<br>
		<br>
		<header class="col-lg-12 col-med-8 col-sm-6 col-xs-4 headspace">
			<h1>Feedback - How was your experience?</h1>
		</header>
	</div>
	<hr>
	<div>
		<fieldset>
			<legend class="reviewbox">Review Time!</legend>
			<form>
				<p>
					How did you hear about us? <select name="recommend">
						<option value="Google">Google</option>
						<option value="Yahoo">Yahoo</option>
						<option value="Ask Jeeves">Ask Jeeves</option>
						<option value="A Friend">A friend</option>
						<option value="Ad">An ad</option>
						<option value="other..">You found us on your own.</option>
					</select>
				</p>
				<p>Would you recommend us to a friend/colleague?</p>
				<input type="radio" name="Yes" value="Yes" checked="checked" /> Yes
				<input type="radio" name="No" value="No" />No<br>
				<p>Comments:</p>
				<textarea name="Comments" cols="20" rows="4">Enter your comments here...</textarea>
				<br>

				<p>
					Would you like to be signed up for Email Offers and updates?<br>
					<br> <input type="checkbox" value="Email" name="Email">Email
					<input type="checkbox" value="Snail Mail" name="Snail Mail">Snail-Mail
				</p>
				<a href="thankYou">Submit
					your thoughts here</a>
				<br>
			</form>
			<a href="home">home</a>
		</fieldset>
	</div>
	<footer id="footer"></footer>
</body>
</html>