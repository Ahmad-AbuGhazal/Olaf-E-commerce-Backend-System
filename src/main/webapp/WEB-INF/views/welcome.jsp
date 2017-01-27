<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href="http://getbootstrap.com/dist/css/bootstrap.css"	rel="stylesheet">
<link href="http://getbootstrap.com/examples/jumbotron/jumbotron.css" rel="stylesheet">
<style type="text/css">@import url("<spring:url value="/css/style.css"/>");</style>
</head><body>
	<div class="container">
	    <div class="pull-right"><a href="?language=en">English</a>|<a href="?language=ar">Arabic</a></div>
		<div class="header">
			<ul class="nav nav-pills pull-right">
				 <li><a href="<spring:url value="/welcome"/>">Home</a></li>
                 <li><a href="<spring:url value="/login"/>">Login</a></li>
                 <li><a href="<spring:url value="/signUp"/>">Register</a></li>
                 <li><a href="<spring:url value="/about"/>">About</a></li>
                 <li><a href="<spring:url value="/contactUs"/>">Contact Us</a></li>

			</ul>
			<h3 class="text-muted">Olaf Ecommerce</h3>
		</div>


		<div class="jumbotron">
			<h1>
			Ecommerce Website
				</h1>
			<p>
			Enjoy in Shopping
			</p>
		</div>

		<div class="row">
		
		</div>

		<div class="footer">
			</div>

	</div>
</body>
</html>