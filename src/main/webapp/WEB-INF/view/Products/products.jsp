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
    <link href="<c:url value="../resources/css/style.css" />" rel="stylesheet">
    <title>Document</title>
</head>
<body>
    <security:authorize access="hasRole('ANONYMOUS')">
            <jsp:include page="headerAnonymous.jsp"/>
            </security:authorize>  
            <security:authorize access="hasAnyRole('USER')">
                <jsp:include page="headerUser.jsp"/>
            </security:authorize>
            <security:authorize access="hasRole('ADMIN')">
                <jsp:include page="headerAdmin.jsp"/>
            </security:authorize> 
    <div id="selectors">
        <select name="Category">
            <option value="Category">Category</option>
          </select>
          <select name="Brand">
            <option value="Brand">Brand</option>
          </select>
          <select name="Order">
            <option value="Order">Order</option>
          </select>
          <input type="submit" value="update">
    </div>
    <div id="mainBody">
        <p>other</p>
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