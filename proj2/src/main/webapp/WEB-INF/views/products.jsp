<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container">
<div class="row">
        <div class="col-sm-12 col-md-10 col-md-offset-1">
<table  class="table table-hover" >  
<tr><th>Image</th><th>Name</th><th>Price</th><th>Show</th></tr>  
   <c:forEach var="product" items="${productList}">   
   <tr>  
   <td><img src="${pageContext.request.contextPath}/${product.productImage}" height="150" width="150"></td> 
   <td><h4><b>${product.productName}</b></h4></td>  
   
    <td><h4><b>${product.productPrice}</b></h4></td>   
  
   <td><a href="${pageContext.request.contextPath}/showProduct/${product.productId}"><button type="button" class="btn btn-success">
                         <span  class="glyphicon glyphicon-ok"></span>   Show
                        </button></a></td>
    

    
   </tr>  
   </c:forEach>  
   </table>  
   </div>
   </div>
   </div>
</body>
</html>