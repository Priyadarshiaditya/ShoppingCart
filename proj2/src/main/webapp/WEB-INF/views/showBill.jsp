<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<head>
	  <title>Bootstrap Case</title>
	  <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	   
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
<body>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 <%@include file="header.jsp"%>
 <center>
 <h1>Reciept</h2>
 <h2>
 <strong>Your Order has been placed successfully</strong><br>
 <strong>Here is the receipt of the order:</strong>
 </h2>
 </center>
 <div class="container">
 <div class="well">  
<h4>
<b>
 Order No:-${bill.billId}  
 </b>
 <br>
 <br>
 <br>
 <b>
   Bill Address:-${bill.billAddress}
   </b>
   <br>
    <br>
 <br>
   <b>
   Name:-${bill.users.userName}
   </b>
   <br>
    <br>
 <br>
   <b>
   Grand Total:-${bill.total}
   </b>
   <br>
    <br>
 <br>
   </h4>
   
  </div>
  <p align="right">
  <a href="/proj2/home1" class="btn btn-warning"> Continue Shopping</a>
  </p>
  </div>
</body>
</html>