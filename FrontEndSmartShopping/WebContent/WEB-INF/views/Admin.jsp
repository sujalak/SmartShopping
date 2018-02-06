<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Admin Add</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Admin</h2>
  <ul class="nav nav-tabs nav-justified"">
    <li class="active"><a data-toggle="tab" href="#Product">Product</a></li>
    <li><a data-toggle="tab" href="#menu1">Category</a></li>
    <li><a data-toggle="tab" href="#menu2">Supplier</a></li>
    
  </ul>

  <div class="tab-content">
    <div id="home" class="tab-pane fade in active">
      <h3>Product</h3>
        <%@include file="product.jsp" %>
    </div>
    <div id="menu1" class="tab-pane fade">
      <h3>Category</h3>
     <%@include file="category.jsp" %>
    </div>
    <div id="menu2" class="tab-pane fade">
  <c:if test="${isUserClickedSupplier==true}">
<jsp:include page="supplier.jsp"></jsp:include> 
</c:if>
    
      <%@include file="supplier.jsp" %>
    </div>

  </div>
</div>

</body>
</html>