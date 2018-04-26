<%@page import="com.alex.springsecurity.demo.entities.Products"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@page import="java.util.Iterator"%>
<%@page import="com.alex.springsecurity.demo.controller.ProductsPage"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <title>Document</title>
</head>
<body>
    <security:authorize access="hasRole('ANONYMOUS')">
            <jsp:include page="../Header/headerAnonymous.jsp"/>
    </security:authorize>  
    <security:authorize access="hasAnyRole('USER')">
            <jsp:include page="../Header/headerUser.jsp"/>
    </security:authorize>
    <security:authorize access="hasRole('ADMIN')">
            <jsp:include page="../Header/headerAdmin.jsp"/>
    </security:authorize>  

    <form action="${pageContext.request.contextPath}/products/filter">
    <div id="selectors">
        
        <select name="category">
            
            <option value="Shoes">Shoes</option>
            <option value="Jackets">Jackets</option>
            <option value="Hats">Hats</option>
            
        </select>
        
        <select name="order">
            
            <option value="ASC">ASC</option>
            <option value="DESC">DESC</option>
            
        </select>
        
        <input type="submit" value="update">
        
    </div>
    </form> 

    <div id="mainBody">
        <div id="body">
            <div id="main">
                <p> here are my products </p>
                <c:forEach var="Products" items="${products}">
                    <c:url var="AddToCartLink" value="AddToCartLink">
                            <c:param name="id" value="${Products.id}"/>
                            <c:param name="title" value="${Products.title}"/>
                            <c:param name="category" value="${Products.category}"/>
                            <c:param name="price" value="${Products.price}"/>
                    </c:url>
                    <div id="item">
                        <p>${Products.title}</p>
                        <p>${Products.category}</p>
                        <p>${Products.price}</p>
                        <a href="${AddToCartLink}">Add to cart!</a>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>

    <div id="footer">
        <div id="footer_a_div">
            <a href="">github</a>
            <a href="">linkedin</a>
            <a href="">hackerrank</a>
        </div>
    </div>
</body>
</html>