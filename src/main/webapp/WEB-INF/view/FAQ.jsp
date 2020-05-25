<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>FAQs</title>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href='<spring:url value="/resources/css/mainStyles.css"/>'
	rel="stylesheet">
<link href='<spring:url value="/resources/css/FAQstyle.css"/>'
	rel="stylesheet">

</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<jsp:include page="header.jsp"></jsp:include>
	<!--Navigation Section-->

	<div class="container-fluid headofpage">
		<br> <br>
		<header class="col-lg-12 col-med-10 col-sm-8 col-xs-4 headspace">
			<h1>Frequently Asked Questions</h1>
		</header>
	</div>
	<hr>
	<table class="faq-table table table-bordered table-striped">
		<tr>
			<td class="faqbutton">
				<button type="button" class="btn" data-toggle="collapse"
					data-target="#collapseme">What happens when I don't get my
					package?</button>
			</td>
		<tr>
			<td><div class="collapse out" id="collapseme">
					Call us at 1-800-555-5555 and we will respond within 48 months.<br>
				</div></td>
		</tr>
		<td class="faqbutton">
			<button type="button" class="btn" data-toggle="collapse"
				data-target="#collapse2">What happens when I damage the
				product during the rental phase?</button>
		</td>
		<tr>
			<td><div class="collapse out" id="collapse2">
					We believe in being fair, so we will go ahead and damage your
					credit.<br>
				</div></td>
		</tr>
		<td class="faqbutton">
			<button type="button" class="btn" data-toggle="collapse"
				data-target="#collapse3">What if I didn't approve the
				purchase?</button>
		</td>
		<tr>
			<td><div class="collapse out" id="collapse3">
					Your keyboard entered your shipping and billing information and
					your mouse clicked submit? crazy...<br>
				</div></td>
		</tr>
		<td class="faqbutton">
			<button type="button" class="btn" data-toggle="collapse"
				data-target="#collapse4">What is the fastest shipping we
				can get?</button>
		</td>
		</tr>
		<tr>
			<td><div class="collapse out" id="collapse4">Whenever we
					finish binge watching a Netflix show, we will roll out of bed and
					make our way to UPS. Give or take, a few weeks or so.</div></td>
		</tr>
		<td class="faqbutton">
			<button type="button" class="btn" data-toggle="collapse"
				data-target="#collapse6">
				How do I delete my credit card info?<br>
			</button>
		</td>
		</tr>
		<tr>
			<td><div class="collapse out" id="collapse6">
					You can't.<br>
				</div></td>
		</tr>
		<td class="faqbutton">
			<button type="button" class="btn" data-toggle="collapse"
				data-target="#collapse5">Do our devs prefer AMD or Intel?</button>
		</td>
		</tr>
		<tr>

			<td><div class="collapse out" id="collapse5">
					-Romy says "Intel all the way babygirl!"<br> -Vivian says "AMD
					compensates with more cores at a given price!"<br> -Meg says
					"depends on the use"<br>
				</div></td>

		</tr>
		<td class="faqbutton">
			<button type="button" class="btn" data-toggle="collapse"
				data-target="#collapse7">What are the devs favorite part
				about the Step IT up program?</button>
		</td>
		</tr>
		<tr>

			<td><div class="collapse out" id="collapse7">
					-Romy: Everything except the commute<br> -Vivian: Improve soft
					skills<br>-Justin: The opportunity to demonstrate my worth to
					Costco while not being forced to leave the company to get the
					education I need for the career I want.<br>-Meg: learning new
					skills.<br>
				</div></td>

		</tr>
		<td class="faqbutton">
			<button type="button" class="btn" data-toggle="collapse"
				data-target="#collapse8">What are the devs favorite
				programming languages?</button>
		</td>
		</tr>
		<tr>

			<td><div class="collapse out" id="collapse8">
					-Romy: Java<br> -Vivian: Python<br>-Justin: Java and
					Python <br>-Meg: Java<br>
				</div></td>

		</tr>
		<td class="faqbutton">
			<button type="button" class="btn" data-toggle="collapse"
				data-target="#collapse9">Do you have a question for us that
				we didn't already answer?</button>
		</td>
		</tr>
		<tr>
			<td><div class="collapse out" id="collapse9">
					Too bad, we're done sharing.<br>
				</div></td>
		</tr>
	</table>
	<hr>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>