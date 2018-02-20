<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.carousel-inner img {
	width: 100%; /* Set width to 100% */
	margin: auto;
	min-height: 200px;
}
/* Hide the carousel text when the screen is less than 600 pixels wide */
@media ( max-width : 600px) {
	.carousel-caption {
		display: none;
	}
}

img {
	height: 50%;
}
</style>
</head>

<body>
	<div class="row">
		<div class="container">

			<div id="myCarousel" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
					<li data-target="#myCarousel" data-slide-to="3"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner">
					<div class="item active">
						<img src="images\gsaree.jpg" alt="Saree" style="width: 100%;">
					</div>

					<div class="item">
						<img src="images\jeans.jpg" alt="jeans" style="width: 100%;">
					</div>

					<div class="item">
						<img src="images\kurthis.jpg" alt="Kurthis" style="width: 100%;">
					</div>
					<div class="item">
						<img src="images\shirts.jpg" alt="shirts" style="width: 100%;">
					</div>
				</div>

				<!-- Left and right controls -->
				<a class="left carousel-control" href="#myCarousel"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#myCarousel"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
		</div>
	</div>
	
		<div class="container">

			
					<div class="row">
					<c:forEach items="${productList}" var="product">
						<div class="col-md-4">
						
							<div class="thumbnail">
								<img src="<c:url value="images/${product.pid}.jpg"/>"
									width="150" height="100"></img>
								<div class="caption">
									<p>${product.pname}</p>
									Rs:<p>${product.price}</p>
									<p>
										<a href="<c:url value='/cart/Add'/>">
											<button class="btn btn-info" style="font-size: 36px">
												<i class="fa fa-shopping-cart" style="font-size: 36px"></i>
											</button>
										</a>
									</p>
								</div>
								
							</div>
						</div>
						</c:forEach>
					</div>
				</div>
	






</body>
</html>
