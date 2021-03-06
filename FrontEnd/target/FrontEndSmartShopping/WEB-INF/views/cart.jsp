<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">

<style>
.table>tbody>tr>td, .table>tfoot>tr>td{
    vertical-align: middle;
}
@media screen and (max-width: 600px) {
    table#cart tbody td .form-control{
		width:20%;
		display: inline !important;
	}
	.actions .btn{
		width:36%;
		margin:1.5em 0;
	}
	
	.actions .btn-info{
		float:left;
	}
	.actions .btn-danger{
		float:right;
	}
	
	table#cart thead { display: none; }
	table#cart tbody td { display: block; padding: .6rem; min-width:320px;}
	table#cart tbody tr td:first-child { background: #333; color: #fff; }
	table#cart tbody td:before {
		content: attr(data-th); font-weight: bold;
		display: inline-block; width: 8rem;
	}
	
	
	
	table#cart tfoot td{display:block; }
	table#cart tfoot td .btn{display:block;}
	
}
</style>
</head>
<body>
<div class="container">
	<table id="cart" class="table table-hover table-condensed">
	
	<c:if test="${empty cartList}">
	<div class="container">
  <div class="jumbotron">
        
    <p>Cart is Empty</p>
  </div>
     
</div>
	</c:if><form:form action="${contextRoot}/cart/checkout/${sum}">
	
    				<thead>
						<tr>
							<th style="width:50%">Product</th>
							<th style="width:10%">Price</th>
							<th style="width:8%">Quantity</th>
							<th style="width:22%" class="text-center">Subtotal</th>
							<th style="width:10%"></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${cartList}" var="cart">
						<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-2 hidden-xs"><img src="<c:url value="/images/${cart.p_id}.jpg"/>" width="150" height="100"></img></div>
									<div class="col-sm-10">
										<h4 class="nomargin">${cart.p_name}</h4>
										<p></p>
									</div>
								</div>
							</td>
							<td data-th="Price">${cart.price}</td>
							<td data-th="Quantity">
								<input type="number" class="form-control text-center" value="${cart.quantity}">
							</td>
							<td data-th="Subtotal" class="text-center">${sum}</td>
							<td class="actions" data-th="">
								<a href="<c:url value='/cart/Delete/${product.pid}'/>">
								<button class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></button></a>								
							</td>
						</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr class="visible-xs">
							<td class="text-center"><strong>Total${sum}</strong></td>
						</tr>
						<tr>
							<td><a href="${contextRoot}/home" class="btn btn-warning"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
							<td colspan="2" class="hidden-xs"></td>
							<td class="hidden-xs text-center"><strong>Total ${sum}</strong></td>
							
							<td><a href="${contextRoot}/cart/checkout/${sum}" class="btn btn-success btn-block">Checkout <i class="fa fa-angle-right"></i></a></td>
						</tr>
					</tfoot>
					</form:form>
					
				</table>
</div>
</body>
</html>