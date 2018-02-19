<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<title>Product List</title>
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

	<div class="container">
		<h2>Product List</h2>
       <a href="${contextRoot}/product" class="btn btn-info btn-lg">
          <span class="glyphicon glyphicon-plus"></span> Add Product 
        </a>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ProductID</th>
					<th>Product Name</th>
					<th>Image</th>
					<th>Description</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Category</th>
					<th>Supplier</th>

					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${productList}" var="product">
					<tr>
						<td>${product.pid}</td>
						<td>${product.pname}</td>
						<td ><img src="<c:url value="images/${product.pid}.jpg"/>" width="150" height="100"></img></td>
						<td>${product.description}</td>
						<td>${product.price}</td>
						<td>${product.stock}</td>
						<td>${product.category.cname}</td>
						<td>${product.supplier.supplierName}</td>
						<td><a href="<c:url value='/productEdit/${product.pid}'/>">
								<button class="btn btn-warning" style="font-size: 20px">
									<i class="fa fa-edit" style="font-size: 36px"></i>
								</button>
						</a></td>
						<td><a href="<c:url value='/productDelete/${product.pid}'/>">
								<button class="btn btn-danger" style="font-size: 20px">
									<i class="fa fa-trash-o" style="font-size: 36px"></i>
								</button>
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>
