<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
 photo :  ${photo}
        <h1>Edit Product</h1>  
       <form:form method="POST" action="/proj2/editsave1" enctype="multipart/form-data">
        
        <table >    
        <tr>  
        <td></td>    
         <td><form:hidden  path="productId" /></td>  
         </tr>   
         <tr>    
          <td>Name : </td>   
          <td><form:input path="productName"  /></td>  
         </tr>    
         <tr>    
          <td>Price :</td>    
          <td><form:input path="productPrice" /></td>  
         </tr>   
          <td><img src="${pageContext.request.contextPath}/${photo}" height="50" width="50"></td>
           <tr>
									<td><form:hidden path="productImage"/></td>
								</tr>
								<tr>
									<td>Choose Image</td>
									<td><input type="file" name="file"/></td>
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
                  
           
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Edit Save" onclick="return limitText()" /></td>    
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