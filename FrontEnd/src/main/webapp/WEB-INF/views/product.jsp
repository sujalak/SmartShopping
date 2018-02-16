<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>

	<c:if test="${not empty msg}">



		<div class="row">
			<div class="col-xs-12 col-md-offset-2 col-md-8">
				<div class="alert alert-info fade in">${msg}</div>
			</div>
		</div>
	</c:if>
	<form action="${contextRoot}/product" method="post"
		class="form-horizontal" enctype="multipart/form-data">





		<!-- Form Name -->



		<!-- Text input-->

		<div class="form-group">

			<label class="col-md-4 control-label" for="product_id">Product
				Id</label>

			<div class="col-md-4">

				<input id="product_id" name="product_id" placeholder="Product Id"
					class="form-control input-md" required type="text">



			</div>

		</div>




		<!-- Text input-->

		<div class="form-group">

			<label class="col-md-4 control-label" for="product_name">Product
				Name</label>

			<div class="col-md-4">

				<input id="product_name" name="product_name"
					class="form-control input-md" type="text"
					placeholder="Product Name" required>



			</div>

		</div>




		<!-- Text input-->

		<div class="form-group">

			<label class="col-md-4 control-label" for="product_name_fr">Product
				Description </label>

			<div class="col-md-4">

				<input id="product_name_fr" name="product_name_fr"
					placeholder="Product Description " class="form-control input-md"
					required type="text">



			</div>

		</div>

		<div class="form-group">

			<label class="col-md-4 control-label" for="product_price">Product
				Price</label>

			<div class="col-md-4">

				<input id="product_price" name="productprice"
					placeholder="Product Price" class="form-control input-md" required
					type="text">



			</div>

		</div>

		<div class="form-group">

			<label class="col-md-4 control-label" for="product_stock">Product
				Stock</label>

			<div class="col-md-4">

				<input id="product_stock" name="produc_stock"
					placeholder="Product Stock" class="form-control input-md" required
					type="text">



			</div>

		</div>



		<!-- Select Basic -->

		<div class="form-group">

			<label class="col-md-4 control-label" for="categorie">Product
				Category</label>


			<div class="col-md-4">


				<select class="form-control">
					<c:forEach var="category" items="${categoryList}">
						<option>${category.cname}</option>
					</c:forEach>
				</select>

			</div>


		</div>

		<div class="form-group">

			<label class="col-md-4 control-label" for="suppliers">Product
				Supplier</label>


			<div class="col-md-4">


				<select class="form-control">
					<c:forEach var="supplier" items="${supplierList}">
						<option>${supplier.supplierName}</option>
					</c:forEach>
				</select>

			</div>


			<div class="col-md-4"></div>

		</div>










		<!-- File Button -->

		<div class="form-group">

			<label class="col-md-4 control-label" for="filebutton">Product
				image</label>

			<div class="col-md-4">

				<input id="file" name="file" class="input-file" type="file">

			</div>

		</div>

		<!-- Button -->

		



			<div class="form-group">
				<div class="row">
					<div class="col-md-4">

						<button id="submitbutton" name="submit" class="btn btn-primary">Submit</button>



						<button id="cancelbutton" name="cancel" class="btn btn-warning">Cancel</button>

					</div>
				</div>
				</div>
	</form>




</body>

</html>