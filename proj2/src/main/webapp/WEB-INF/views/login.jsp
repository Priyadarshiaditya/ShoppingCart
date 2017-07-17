<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"  isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
 <c:if test="${param.error == 'true'}">
         <div style="color:red;margin:10px 0px;">
          
                Login Failed!!!<br />
                Reason :  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                 
         </div>
    </c:if>
<%@include file="header.jsp" %>
<h2>Login Form</h2>

<form  name='f' action="${pageContext.request.contextPath}/j_spring_security_check" 

method='POST'>
  
  <div class="container">
    <label><b>Username</b></label>
    <input type="text" class="form" placeholder="Enter Username" name="username" required>
<br>
<br>
    <label><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
<br>
<br>        
    <button type="submit">Login</button>
    <input type="checkbox" checked="checked"> Remember me
  </div>
<br>
<br>
  <div class="container" style="background-color:#f1f1f1">
    <button type="button" class="cancelbtn">Cancel</button>
    <span class="psw">Forgot <a href="#">password?</a></span>
  </div>
  <br>
<br>
</form>

</body>
