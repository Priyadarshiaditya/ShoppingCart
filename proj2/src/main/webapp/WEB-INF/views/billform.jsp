<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form method="post" action="save2" >  
    <style>
    table th,td{
    padding:10px
    }
    </style>
         ${error}
        <table style="width:100%">
        <tr>    
          <td>Id : </td>   
          <td><form:hidden path="billId"  /></td>  
         </tr> 
         <tr>    
          <td>Address :</td>    
          <td><form:input path="billAddress" /></td>  
         </tr>
         <tr>    
          <td> </td>    
          <td><input type="submit"   value="Save" /></td>    
         </tr>
</table>
</form:form>
</body>
</html>