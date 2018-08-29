<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Hotel Search</title>
<!-- Link the bootstrap CSS -->
<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous"> -->
<!-- Or in this case, a variation theme... -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/darkly/bootstrap.min.css" />
<!-- Custom CSS goes below Bootstrap CSS -->
<link rel="stylesheet" href="/style.css" />
</head>
<body>
	<!-- With boostrap, pages should generally be surrounded with a container element. -->
	<main class="container">
		<h1 class="page-header mt-4 mb-4">Search for Hotels by City</h1>
		
		<form class="form-inline" method="post" autocomplete="off">
		  
		  <label class="sr-only" for="city">City</label>
		  <select class="form-control mb-2 mr-sm-2" id="city" name="city">
		  	<option required value="">Select a City</option>
		  	<c:forEach items="${ cities }" var="city">
		  		<option <c:if test="${ city eq param.city }">selected</c:if>>${ city }</option>
		  	</c:forEach>
		  </select>
		  
		  <label class="sr-only" for="city">Max Price</label>
		  <select class="form-control mb-2 mr-sm-2" id="maxPrice" name="maxPrice">
		  	<option value="">Select a Max Price</option>
		  	<c:forEach items="${ prices }" var="price">
		  		<option <c:if test="${ price eq param.price }">selected</c:if>>${ price }</option>
		  	</c:forEach>
		  </select>
		
		  <button type="submit" class="btn btn-primary mb-2 mr-2">Search</button>
		  <c:if test="${not empty param.city}">
		  	<a href="/hotel-search" class="btn btn-secondary mb-2">Clear</a>
	  	  </c:if>
		</form>
		<c:if test="${not empty param.city}">
			<table class="table">
				<thead>
				<tr>
					<th style="width: 50%">Hotel</th><th style="width: 35%">City</th><th style="width: 15%">Price</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach var="hotel" items="${hotels}">
					<tr>
						<td>${hotel.name}</td><td>${hotel.city}</td><td>$${hotel.pricePerNight}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>

	</main>
</body>
</html>