<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <title>Homepage</title>
</head>
<body>
    <h1> Homepage</h1>
    <form:form action="panel/search" method="POST">
            <input type="search" id="mySearch" name="searchTerm" 
            placeholder="Search the site...">  <button>Search</button>
            </form:form>
    <div id="header">
            <div id="header_p_div2">
            <security:authorize access="hasRole('ANONYMOUS')">
                <i style="color: gray"> You are currently not logged in. </i>
                    <a href="${pageContext.request.contextPath}/signin">Sign in</a>
                    <a href="${pageContext.request.contextPath}/user/signup">Sign up</a>
            </security:authorize>    
            </div>
            
            <security:authorize access="hasAnyRole('USER')">
                    <div id="header_p_div1">
                <a href="${pageContext.request.contextPath}/about">About</a>
                <a href="${pageContext.request.contextPath}/portfolio">Products</a>
                <a href="${pageContext.request.contextPath}/shoppingcart/list">My shopping cart</a>
                <a href="${pageContext.request.contextPath}/about">Contact</a>
                    </div>
            </security:authorize>
            <security:authorize access="hasRole('ADMIN')">
                <div id="header_p_div1">
                     <a href="${pageContext.request.contextPath}/about">About</a>
                <a href="${pageContext.request.contextPath}/portfolio">Products</a>
                <a href="${pageContext.request.contextPath}/shoppingcart/list">My shopping cart</a>
                <a href="${pageContext.request.contextPath}/about">Contact</a>
                <a href="${pageContext.request.contextPath}/add-product/product">Add product to sell</a>
                <a href="${pageContext.request.contextPath}/panel/list">management panel (only for managers)</a>
                </div>
            </security:authorize> 
                
            <security:authorize access="hasAnyRole('USER', 'ADMIN')">
                
            <form:form action="${pageContext.request.contextPath}/homepage"
                        method="POST">
            <div id="header_p_div2">
            <input type="submit" value="Logout"/>
            </div>
            </form:form>
            </security:authorize>
            
    </div>
</body>
</html>