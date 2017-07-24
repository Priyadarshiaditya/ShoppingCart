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
      <div class="container">
      <div class="form-group">
      
      <form:form method="post" action="save" enctype="multipart/form-data" >  
    
         ${error}
  
        
           <label><b>Id :</b></label>    
          <td><form:input path="userId" class="form-control" />     
         
          <label><b>Name :    </b></label>
          <form:input path="userName" class="form-control" />  
             
                   
          <label><b> Create Password:</b></label>
         <form:password path="password"  id="txtPassword" class="form-control"/>  
            
          <label><b>Confirm Password:   </b></label>
          <input type="password" id="txtConfirmPassword" class="form-control" />  
        
									<form:hidden path="userImage" />
								
									 <label><b>Choose Image:</b></label>
								<input type="file" name="file" />
								
         <br>
         <br>
           <center>
         <input type="submit"  id="btnSubmit" class="btn btn-primary btn-md btn-success"  value="Save" onclick="return Validate()"/>    
           </center>
       
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
</div>
</div>x