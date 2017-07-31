 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
  
 		 
	   <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
	
   
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Shop First</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
           <!-- each <li> </li> is one menu option -->
            <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                    </c:if>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <li class="active"><a href="${pageContext.request.contextPath}/home1">Home</a></li>
                    </c:if>
                            
            <c:forEach items="${categoryList}" var="category">
            <li><a href="${pageContext.request.contextPath}/showProductsByCategory/${category.categoryId}">${category.categoryName}</a></li>
             </c:forEach>
        <security:authorize access="hasRole('ROLE_ADMIN')">	
                    <li><a href="${pageContext.request.contextPath}/viewusers">View All Users</a></li>
                    
    
        
        			
    <li class="dropdown">
        
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Manage Products <span class="caret"></span></a>
         <!-- <ul class="dropdown-menu">  is used to create the sub menu items -->
          <ul class="dropdown-menu">
          
  <li><a href="${pageContext.request.contextPath}/manageproduct">Add Product</a></li>
  <li><a href="${pageContext.request.contextPath}/viewproduct">View Product</a></li>
          </ul>
            </li>
             <li class="dropdown">
        
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Manage Category <span class="caret"></span></a>
         <!-- <ul class="dropdown-menu">  is used to create the sub menu items -->
          <ul class="dropdown-menu">
          
  <li><a href="${pageContext.request.contextPath}/managecategory">Add Category</a></li>
  <li><a href="${pageContext.request.contextPath}/viewcategory">View Category</a></li>
          </ul>
            </li>
      
   </security:authorize>
        
      </ul>
      <ul class="nav navbar-nav navbar-right">
  <c:if test="${pageContext.request.userPrincipal.name == null}">
        <li><a href="${pageContext.request.contextPath}/usersform"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        <li><a href="${pageContext.request.contextPath}/loginPage"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
 
</c:if>


      	</ul>
      	<ul class="nav navbar-nav navbar-right">
      	 <c:if test="${pageContext.request.userPrincipal.name != null}">
      	  <li><a href="${pageContext.request.contextPath}/cart/showCart"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
      	  <li><a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-out"></span> LogOut</a></li>
      	 </c:if>
    	</ul>
  
    </div>
  </div>
</nav>    