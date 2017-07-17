<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

   
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

 





</head>
<body>

  <%@include file="header.jsp" %>  
  <div class="container">
        <h1>Add New Users</h1>  
       <form:form method="post" action="saveUser">    
        <table class="table table-bordered">    
        <tr>    
          <th>User Id : </th>   
          <td><form:input path="userId"  /></td>  
         </tr>  
         <tr>    
          <th>Password :</th>    
          <td><form:input path="password" /></td>  
         </tr>   
         <tr>    
          <th>Name : </th>   
          <td><form:input path="name"  /></td>  
         </tr>    
         
         <tr>    
          <th>Email :</th>    
          <td><form:input path="email" /></td>  
         </tr>  
                  
         <tr>    
          <td> </td>    
          <td><input class="btn-success" type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>    
</div>
</body>
</html>