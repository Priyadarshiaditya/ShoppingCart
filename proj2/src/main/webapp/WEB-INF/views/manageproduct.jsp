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
   <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<head>
<%@ include file="header.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>

      <form:form method="post"  action="save1" enctype="multipart/form-data">  
    <style>
    table th,td{
    padding:10px
    }
    </style>
    ${error}         
        <table style="width:100%">
        <tr>    
          <td>Product Id : </td>   
          <td><form:input path="productId"  /></td>  
         </tr>     
         <tr>    
          <td>Product Name : </td>   
          <td><form:input path="productName"  /></td>  
         </tr>    
         <tr>    
          <td>Product Price :</td>    
          <td><form:input path="productPrice" /></td>  
         </tr>      
              <tr>    
          <td>Product Description : </td>   
   <td ><form:textarea path="productDescription" id="desc" rows="5" cols="100" size="255" /></td>
         </tr>  
        <tr>
				<td>Category:</td>
				<td><form:select path="productCategory.categoryId" itemLabel="categoryName" itemValue="categoryId" items="${categoryList}"
					 /></td>
				<td><form:errors path="productCategory.categoryId" cssClass="error" /></td>
			</tr>
              <tr>
									<td><form:hidden path="productImage"/></td>
								</tr>
								<tr>
									<td>Choose Image</td>
									<td><input type="file" name="file"/></td>
								</tr>    
           <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" onclick="return limitText()" /></td>    
         </tr>   
            
        </table> 
   
       </form:form>    
     <script type="text/javascript">
     function limitText() {
    	    if (document.getElementById("desc").value.length >=255) {
    	    	alert("Product Description should exceed 255 characters");
    	    	 return false;
    	    } 
    	    return true;
    	}
    
</script> 
   
</body>
</html>