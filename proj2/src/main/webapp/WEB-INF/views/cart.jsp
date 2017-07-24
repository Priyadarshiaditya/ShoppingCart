<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
		<%@include file="header.jsp"%>
		<div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-10 col-md-offset-1">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Product</th>
                        <th>Quantity</th>
                        <th class="text-center">Price</th>
                        <th class="text-center">Total</th>
                        <th> </th>
                    </tr>
                </thead>
                <tbody>
                
                <c:set var="tot" value="0" scope="session"/>
				<c:forEach var="cartItem" items="${cartContent}">
				
				
                    <tr>
                        <td class="col-sm-8 col-md-6">
                        <div class="media">
                            <a class="thumbnail pull-left" href="#"> <img class="media-object" src="${pageContext.request.contextPath}/${cartItem.product.productImage}" style="width: 72px; height: 72px;"> </a>
                            <div class="media-body">
                                <h4 class="media-heading">${cartItem.product.productName}</h4>
                             <%--   <p>${cartItem.product.productDescription}</p> --%> 
                               <span>Status: </span><span class="text-success"><strong>In Stock</strong></span>
                            </div>
                        </div></td>
                        <td class="col-sm-1 col-md-1" style="text-align: center">
<b>                        ${cartItem.quantity}</b>
                        </td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>${cartItem.product.productPrice}</strong></td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>${cartItem.product.productPrice * cartItem.quantity }</strong></td>
                        
                        
                        <c:set var="tot"  value="${tot +cartItem.subTotal } " scope="session"/>
                        
                        
                         <td class="col-sm-1 col-md-1">
                           <a href="${pageContext.request.contextPath}/cart/deleteItem/${cartItem.cartItemId}"><button type="button" class="btn btn-danger">
                            <span  class="glyphicon glyphicon-remove"></span> Remove
                        </button></a>
                        </td>
                    </tr>
                  
                  
                    
                    
                    
                   
                          </c:forEach>
                      <tr>
                        <td>   </td>
                        <td>   </td>
                      <td></td>
                        <td><h3>Grand Total:</h3></td>
                        <td class="text-right"><h3><strong>${tot}</strong></h3></td>
                    </tr>
                    <tr>
                       
                       <td><a href="/proj2/home1" class="btn btn-warning"><i
							class="fa fa-angle-left"></i> Continue Shopping</a></td>
					<td colspan="3" class="hidden-xs"></td>
					<td><a href="/proj2/billform" class="btn btn-success btn-block">Checkout
							<i class="fa fa-angle-right"></i>
					</a></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>