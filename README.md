# Rent-A-Rig_Spring-MVC

# --------------NOTES---------------
Start COMPLETELY OVER. Basic HTML until functionality is there.
 - get products to list correctly with filter
 - get account info to show
 - get cart and checkout to show correctly

Log information to help debug
 - INFO log statement for each method in controller
 - DEBUG log statement for each method in service/dao
 - WARNING log statement for each HANDLED exception

Write test cases
 - *shrugs*

adding navbar and footer
 - <jsp:include page="navbar.jsp"></jsp:include>
 - <jsp:include page="footer.jsp"></jsp:include>

including static resources (like css/js)
 - use link like to resource like this <link href='<spring:url value="/resources/css/mainStyles.css"/>' rel="stylesheet">
 - any urls/links in the css will be relative to the views folder (ex./ ../images/image.jpg)
