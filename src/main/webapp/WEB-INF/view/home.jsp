<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Homepage</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <h1> Homepage</h1>
     <form:form action="panel/search" method="POST">
            <input type="search" id="mySearch" name="searchTerm" 
            placeholder="Search the site...">  <button>Search</button>
            </form:form>
    <security:authorize access="hasRole('ANONYMOUS')">
        <i style="color: gray"> You are currently not logged in. </i>
    </security:authorize>
            
    <hr>
    
      <security:authorize access="hasRole('ANONYMOUS')">
        <a href="${pageContext.request.contextPath}/denied">About</a>
    <br>
    </security:authorize>
       <security:authorize access="hasRole('ANONYMOUS')">
        <a href="${pageContext.request.contextPath}/denied">Products</a>
    <br>
    </security:authorize>
        <security:authorize access="hasRole('ANONYMOUS')">
        <a href="${pageContext.request.contextPath}/denied">Contact</a>
    <br>
    </security:authorize>
     
     <security:authorize access="hasAnyRole('USER', 'ADMIN')">
        <a href="${pageContext.request.contextPath}/about">About</a>
    <br>
    </security:authorize>
     <security:authorize access="hasAnyRole('USER', 'ADMIN')">
        <a href="${pageContext.request.contextPath}/portfolio">Products</a>
    <br>
    </security:authorize>
     <security:authorize access="hasAnyRole('USER', 'ADMIN')">
        <a href="${pageContext.request.contextPath}/shoppingcart/list">My shopping cart</a>
    <br>
    </security:authorize>
     <security:authorize access="hasAnyRole('USER', 'ADMIN')">
        <a href="${pageContext.request.contextPath}/about">Contact</a>
    <br>
    </security:authorize>
    <security:authorize access="hasRole('ADMIN')">
        <a href="${pageContext.request.contextPath}/add-product/product">Add product to sell</a>
    <br>
    </security:authorize>

    <security:authorize access="hasRole('ADMIN')">
        <a href="${pageContext.request.contextPath}/panel/list">management panel (only for managers)</a>
    <br>
    </security:authorize>

    <security:authorize access="!hasAnyRole('USER', 'ADMIN')">
        <a href="user/signup">Sign up</a>
    <br>
    </security:authorize>
    
    <security:authorize access="!hasAnyRole('USER', 'ADMIN')">
        
        <a href="signin">Sign in</a>
        
    </security:authorize>
        
    <security:authorize access="hasAnyRole('USER', 'ADMIN')">
        
    <form:form action="${pageContext.request.contextPath}/homepage"
                  method="POST">
           
        <br>
    <input type="submit" value="Logout"/>
           
    </form:form>
    </security:authorize>

</body>
</html>