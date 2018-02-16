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
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
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
		 <form action= "${contextRoot}/category" method="post">
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
<div class="container">
  <h2>Category List</h2>
 <c:if test="${!empty categoryList}">       
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>CategoryID</th>
        <th>Category Name</th>
        <th>Edit</th>
        <th>Delete</th>
       
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${categoryList}" var="category">
      <tr>
        <td>${category.cid}</td>
        <td>${category.cname}</td>
        <td><a href="<c:url value='category/edit/${category.cid}'/>"><i class="fa fa-edit" style="font-size:36px"></i></a></td>
        <td><i class="fa fa-trash-o" style="font-size:36px"></i></td>
      </tr>
     </c:forEach>
    </tbody>
   
  </table>
  </c:if>
</div>
</body>
</html>
