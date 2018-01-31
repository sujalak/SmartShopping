<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Product</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
 
  <form action=>
    <div class="form-group">
      <label for="cid">Product ID:</label>
      <input type="text" class="form-control" id="pid" placeholder="Enter Id" name="pid">
    </div>
    <div class="form-group">
      <label for="cname">Product Name:</label>
      <input type="text" class="form-control" id="pname" placeholder="Enter Product Name" name="pname">
    </div>
   
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>

</body>
</html>
