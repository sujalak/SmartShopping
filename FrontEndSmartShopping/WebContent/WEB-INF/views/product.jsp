<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
     <%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

 <meta charset="utf-8">

  <meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>

<form class="form-horizontal">
<form:form action="" role="form" commandName="product" enctype="multipart/form-data">
<fieldset>




<!-- Form Name -->



<!-- Text input-->

<div class="form-group">

  <label class="col-md-4 control-label" for="product_id">PRODUCT ID</label>  

  <div class="col-md-4">

  <input id="product_id" name="product_id" placeholder="PRODUCT ID" class="form-control input-md" required="" type="text">

    

  </div>

</div>




<!-- Text input-->

<div class="form-group">

  <label class="col-md-4 control-label" for="product_name">PRODUCT NAME</label>  

  <div class="col-md-4">

  <input id="product_name" name="product_name" placeholder="PRODUCT NAME" class="form-control input-md" required="" type="text">

    

  </div>

</div>




<!-- Text input-->

<div class="form-group">

  <label class="col-md-4 control-label" for="product_name_fr">PRODUCT DESCRIPTION FR</label>  

  <div class="col-md-4">

  <input id="product_name_fr" name="product_name_fr" placeholder="PRODUCT DESCRIPTION FR" class="form-control input-md" required="" type="text">

    

  </div>

</div>




<!-- Select Basic -->

<div class="form-group">

  <label class="col-md-4 control-label" for="categorie">PRODUCT CATEGORY</label>
   <c:forEach var="category" items="${categoryList}">

  <div class="col-md-4">


  <select  class="form-control">
  <option>${category.cname}</option>
   
    </select>

  </div>
  </c:forEach>

</div>

<div class="form-group">

  <label class="col-md-4 control-label" for="suppliers">PRODUCT Supplier</label>
<c:forEach var="supplier" items="${supplierList}">

  <div class="col-md-4">


  <select  class="form-control">
  <option>${suppplier.supplierName}</option>
   
    </select>

  </div>
  </c:forEach>

  <div class="col-md-4">

    <select id="suppliers" name="suppliers" class="form-control">

    <option></option>

    </select>

  </div>

</div>










 <!-- File Button --> 

<div class="form-group">

  <label class="col-md-4 control-label" for="filebutton">Product image</label>

  <div class="col-md-4">

    <input id="filebutton" name="filebutton" class="input-file" type="file">

  </div>

</div>

<!-- Button -->

<div class="form-group">




  <label class="col-md-4 control-label" for="singlebutton">Single Button</label>

  <div class="col-md-4">

    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Submit</button>

  </div>

 

    <button id="submit" name="submit" class="btn btn-primary">Button</button>

  </div>

  </div>

</fieldset>




</form:form>




</body>

</html>