<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Register</title>
</head>
<body>
	<div class="panel panel-primary">
		<div class="panel-heading">Sign Up Form </div>

		<div class="panel-body">

			<div class="container">

				<div class="row">

					<div class="col-md-offset-2 col-md-8">


						<form action="user" method="post">



							<div class="form-group">
								<label class="control-label col-md-4">Email Id</label>
								<div class="col-md-8">
									<input type="text" name="email" class="form-control"
										placeholder="Email Id" />

								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4">Name</label>
								<div class="col-md-8">
									<input type="text" name="name" class="form-control"  placeholder="Name" />

								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-4">Password</label>
								<div class="col-md-8">
									<input type="password" name="Password" class="form-control"
										placeholder="Password" />

								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-4">Phone No</label>
								<div class="col-md-8">
									<input type="text" name="phone" class="form-control"
										placeholder="Phone No" />

								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-4">Address</label>
								<div class="col-md-8">
									<input type="text" name="Address" class="form-control"
										placeholder="Address" />

								</div>
							</div>



							<div class="form-group">
								<div class="row">
									<div class="col-md-4">

										<button id="submitbutton" name="submit"
											class="btn btn-primary">Submit</button>



										<button id="cancelbutton" name="cancel"
											class="btn btn-warning">Cancel</button>

									</div>
								</div>
							</div>
						
</form>
					</div>
				</div>
				</div>
				</div>
				</div>
			
			
</body>
</html>