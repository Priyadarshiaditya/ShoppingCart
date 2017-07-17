<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
 photo :  ${photo}
        <h1>Edit Users</h1>  
       <form:form method="POST" action="/proj2/editsave" enctype="multipart/form-data">
        
        <table >    
        <tr>  
        <td></td>    
         <td><form:hidden  path="userId" /></td>  
         </tr>   
         <tr>    
          <td>Name : </td>   
          <td><form:input path="userName"  /></td>  
         </tr>    
         <tr>    
          <td>Address  :</td>    
          <td><form:input path="userAddress" /></td>  
         </tr>   
          <td><img src="${pageContext.request.contextPath}/${photo}" height="50" width="50"></td>
           <tr>
									<td><form:hidden path="userImage"/></td>
								</tr>
								<tr>
									<td>Choose Image</td>
									<td><input type="file" name="file"/></td>
								</tr>
         
         <tr>    
           
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Edit Save" /></td>    
         </tr>    
        </table>    
       </form:form>    