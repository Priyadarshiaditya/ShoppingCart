<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
<head>
<%@ include file="header.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>

      <form:form method="post"  action="save3" enctype="multipart/form-data">  
    <style>
    table th,td{
    padding:10px
    }
    </style>         
        <table style="width:100%">
        <tr>    
          <td>Category Id : </td>   
          <td><form:input path="categoryId"  /></td>  
         </tr>     
         <tr>    
          <td>Category Name : </td>   
          <td><form:input path="categoryName"  /></td>  
         </tr>    
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>   
            
        </table> 
   
       </form:form>    

</body>
</html>