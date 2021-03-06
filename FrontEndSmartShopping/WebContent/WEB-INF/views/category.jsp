<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Category</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
 
 
  	<c:if test="${not empty msg}">
		
		
 
			<div class="row">
				<div class="col-xs-12 col-md-offset-2 col-md-8">
					<div class="alert alert-info fade in">${msg}</div>
				</div>
			</div>
		</c:if>
		 <form action= "/FrontEndSmartShopping/category" method="post">
    <div class="form-group">
      <label for="cid">Category ID:</label>
      <input type="text" class="form-control" id="cid" placeholder="Enter Id" name="cid">
    </div>
    <div class="form-group">
      <label for="cname">Category Name:</label>
      <input type="text" class="form-control" id="cname" placeholder="Enter Category Name" name="cname">
    </div>
   
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</div>

</body>
</html>
