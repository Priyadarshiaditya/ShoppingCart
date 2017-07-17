<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
   <head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

  <%@ include file="header.jsp" %>
      <form:form method="post" action="save" enctype="multipart/form-data" >  
    <style>
    table th,td{
    padding:10px
    }
    </style>
         ${error}
        <table style="width:100%">
        <tr>    
          <td>Id : </td>   
          <td><form:input path="userId"  /></td>  
         </tr>     
         <tr>    
          <td>Name : </td>   
          <td><form:input path="userName"  /></td>  
         </tr>    
         <tr>    
          <td>Address :</td>    
          <td><form:input path="userAddress" /></td>  
         </tr>      
         <tr>    
          <td>Create Password:</td>    
          <td><form:password path="password"  id="txtPassword" /></td>  
         </tr>   
         <tr>    
          <td>Confirm Password:</td>    
          <td><input type="password" id="txtConfirmPassword" /></td>  
         </tr>
         <tr>
									<td><form:hidden path="userImage"/></td>
								</tr>
								<tr>
									<td>Choose Image</td>
									<td><input type="file" name="file"/></td>
								</tr>
         
         <tr>    
          <td> </td>    
          <td><input type="submit"  id="btnSubmit"  value="Save" onclick="return Validate()"/></td>    
         </tr>    
        </table>
       <script type="text/javascript">
    function Validate() {
        var password = document.getElementById("txtPassword").value;
        var confirmPassword = document.getElementById("txtConfirmPassword").value;
        if (password != confirmPassword) {
            alert("Passwords do not match.");
            return false;
        }
        return true;
    }
</script> 
   
       </form:form>    
