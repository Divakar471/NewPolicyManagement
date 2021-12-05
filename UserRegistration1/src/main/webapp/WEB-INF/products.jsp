
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Product Manager</title>
		<style>
		mark{
     background-color: #ffffff;
      }
     body {
     font-family: Arial, Helvetica, sans-serif;
     background-image: url("img/item.jpg");
     background-size: cover;
	
}
* {box-sizing: border-box;
}
</style>
	</head>
	<body align="center">
		<h1>Policy List</h1>
		<a href="new">Add New Policy</a>
		<br><br>
		<table border="1" align="center" cellpadding="10">
			<thead>
				<tr>
					<th>Policy ID</th>
					<th>Customer Name</th>
					<th>Customer Address</th>
					<th>Policy Term</th>
					<th>Policy Date</th>
					<th>Policy Product</th>
					<th>Policy Amount</th>
					<th>Agency Code</th>
					<th>Policy Type</th>
					<th>Policy Premium</th>
					
					
					
				</tr>
			</thead>
			<tbody>
				 <c:forEach items="${listProducts}" var="product">
					<tr>
					<td>${product.getId()}</td>
					<td>${product.getCustomer_name()}</td>
					<td>${product.getCustomer_address() }</td>
					<td>${product.getPolicy_term()}</td>
					<td>${product.getPolicy_effective_date()}</td>
					<td>${product.getPolicy_product()}</td>
					<td>${product.getPolicy_amount()}</td>
					<td>${product.getAgency_code() }</td>
					<td>${product.getPolicy_type()}</td>
					<td>${product.getPremium() }</td>
					<!--  <td>
						<a href="/+${product.id}">Edit</a>
						<a href="/delete/+${product.id}">Delete</a>
					</td>-->
					
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>