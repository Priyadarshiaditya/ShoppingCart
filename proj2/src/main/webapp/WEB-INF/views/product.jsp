<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container">
<div class="well">
<center>
<img src=" ${pageContext.request.contextPath}/${product.productImage}" height="400px" width="400px">
<br><br><table class="table table-hover">
<tr>

<td width="500px"><h4><strong>Product Name:</strong></h4></td>
<td><h4><strong><center>${product.productName}</center></strong></h4></td>
</tr>
<tr>

<td width="500px"><h4><strong>Product Price</strong></h4>	
</td>
<td><h4><strong><center>${product.productPrice }</center></strong></h4>
</td>

</tr>
<tr>
<td width="500px"><h4><strong>Product Description</strong></h4>	
</td>
<td><h4><strong><center>${product.productDescription }</center></strong></h4>
</td>

</tr>
<tr>
<td colspan="2"><center> <a href="${pageContext.request.contextPath}/cart/addItem/${product.productId}" class="btn btn-info btn-lg">
    <span class="glyphicon glyphicon-shopping-cart"></span> ADD TO CART
   </a>
   
</center>
</td>
</tr>
</table>
</center>
</div>
</div>

</body>
</html>