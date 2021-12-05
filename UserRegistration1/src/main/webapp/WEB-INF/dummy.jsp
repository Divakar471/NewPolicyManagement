<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dummy Page</title>
<style>  
h3{
  font-family: Calibri; 
  font-size: 25pt;         
  font-style: normal; 
  font-weight: bold; 
  color:SlateBlue;
  text-align: center; 
  }
  
body {font-family: Arial, Helvetica, sans-serif;
background-image: url("img/booking.jpg");
background-size: cover;
}
* {box-sizing: border-box;}

</style> 
</head>
<body>

	<h3>Order Your Booking</h3>
	<%
		
		 response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
		
		if(session.getAttribute("username")==null)
		{
			response.sendRedirect("/login");
		}
	
	%>
	Welcome, ${sessionScope.username }
	<br>
	
	<a href="${pageContext.request.contextPath }/logout">Logout</a>
	<br>
	<a href="${pageContext.request.contextPath }/home">home</a>
	<br>
	<a href="${pageContext.request.contextPath }/homeproduct">itemsManagement</a>
	<br>
	
</body>
</html>

