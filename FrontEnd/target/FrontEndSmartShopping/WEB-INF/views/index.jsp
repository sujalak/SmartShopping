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
		<p>Click on the images to enlarge them.</p>
		<td>
		<tr>
			<td>
				<div class="row">
					<div class="col-md-4">
						<div class="thumbnail">
							<a href="images\KidsKurtha.jpg" target="_blank"> <img
								src="images\KidsKurtha.jpg" alt="Lights"
								style="width: 100%; height: 45%">
								<div class="caption">
									<p>KidsKurtha</p>
								</div>
							</a>
						</div>
					</div>
			</td>
			<td>
				<div class="col-md-4">
					<div class="thumbnail">
						<a href="images\lehenga-saree.jpg" target="_blank"> <img
							src="images\lehenga-saree.jpg" alt="Nature" style="width: 100%">
							<div class="caption">
								<p>lehenga.</p>
							</div>
						</a>
					</div>
				</div>
			</td>
			<td>
				<div class="col-md-4">
					<div class="thumbnail">
						<a href="images\lehngacholiSet.jpg" target="_blank"> <img
							src="images\lehngacholiSet.jpg" alt="Fjords" style="width: 100%">
							<div class="caption">
								<p>lehngacholiSet</p>
							</div>
						</a>
					</div>
				</div>
			</td>
		</tr>
	</div>
	</div>
</body>
</html>
