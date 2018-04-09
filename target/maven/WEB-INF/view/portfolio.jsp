<%@page import="com.alex.springsecurity.demo.entities.Products"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@page import="java.util.Iterator"%>
<%@page import="com.alex.springsecurity.demo.controller.Portfolio"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<style>
    #header{
        width: 1000px;
        height: 100px;
        margin: auto;
        border: 1px solid black;
        position: relative;
    }
    #header p,a{
        border: 1px solid black;
        cursor: pointer;
        width: 140px;
        margin-top: 80px;
        display: inline-block;
        position: relative;
        height: 20px;
    }
    #body{
        width: 1000px;
        margin: auto;
        min-height: 250px;
        border: 2px solid blue;
    }
    #sideBar{
        float: left;
        background-color: indianred;
        width: 20%;
        text-align: center;
        min-height: 250px;
    }
    #sideBar a{
        margin: 10px;
    }
    #main{
        float: right;
        width: 80%;
        min-height: 250px;
        background-color: gray;
    }
    #item{
        width: 200px;
        height: 150px;
        background-color: red;
        margin: 15px;
        float: left;
        display: block;
    }
    #footer{
        width: 1000px;
        height: 100px;
        clear:both;
        margin: auto;
        position: relative;
        border: 3px solid green;
    }
</style>
<body>
    <div id="header">
        <a href="${pageContext.request.contextPath}/homepage">Go back to homepage</a>
        <p>products</p>
        <p>Sign up</p>
        <p>Sign in</p>
        <input type="search" id="mySearch" name="q"
        placeholder="Search the site..." width="" >
        <button>Search</button>
    </div>
    <div id="body">
            <div id="sideBar">
                <a href="${pageContext.request.contextPath}/portfolio">Category all</a>
                <a href="${pageContext.request.contextPath}/products-1">Category one</a>
                <a href="${pageContext.request.contextPath}/portfolio">Category two</a>
                <br>
                <br>
                <a href="${pageContext.request.contextPath}/portfolio">Ascending</a>
                <a href="${pageContext.request.contextPath}/portfolio">Descending</a>
            </div>
            
            <div id="main">
                <p> here are my products </p>
                <c:forEach var="Products" items="${products}">
                    <c:url var="AddToCartLink" value="AddToCartLink">
                            <c:param name="id" value="${Products.id}"/>
                    </c:url>
                    <div id="item">
                        <p>${Products.title}</p>
                        <p>${Products.category}</p>
                        <a href="${AddToCartLink}">Add to cart!</a>
                    </div>
                </c:forEach>  
            </div>
    <div id="footer">
        this is the footer
    </div>
</body>
</html>