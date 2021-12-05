<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Add product</title>
		<style>
		mark{
     background-color: #ffffff;
      }
     body {
     font-family: Arial, Helvetica, sans-serif;
     background-image: url("img/add.jpg");
     background-size: cover;
	
}
* {box-sizing: border-box;
}
</style>
		
	</head>
	<body align="center">
		<h1>Add New Policy</h1>
		
		<br><br>
		${error}
		<form action="/saveunderwritter" method="post" modelAttribute="policy" >
		<table  align="center" >
			<tr>
				<td>Policy Holder Name</td>
				<td><input name= "customer_name" type="text"></td>
			</tr>
			<tr>
				<td>Policy holder Address</td>
				<td><input name="customer_address"  type="text"></td>
			</tr>
			<tr>
				<td>Policy Term</td>
				<td><input name="policy_term" type="text"></td>
			</tr>
			<tr>
				<td>Policy Effective Date</td>
				<td><input name="policy_effective_date"  type="text" ></td>
			</tr>
			<tr>
				<td>Policy Product</td>
				<td><input name="policy_product"  type="text" ></td>
			</tr>
			<tr>
				<td>Policy Amount</td>
				<td><input name="policy_amount"  type="text" ></td>
			</tr>
			<tr>
				<td>Agency Code</td>
				<td><input name="agency_code"  type="text" ></td>
			</tr>
			<tr>
				<td>Policy Type</td>
				<td>
				<select  name="policy_type" id="policy_type" type="text" >
				<option value="5">AUTO</option>
				<option value="2">PROPERTY</option>
				<option value="3">LIABILITY</option>
				<option value="2">MARINE</option>
				
				</select>
				</td>
			</tr>
			<tr>
				
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
		</form>
	</body>
</html>