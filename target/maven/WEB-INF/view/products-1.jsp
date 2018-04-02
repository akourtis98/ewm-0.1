<%@page import="com.alex.springsecurity.demo.dao.Products"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.alex.springsecurity.demo.controller.Portfolio"%>
<%@page import="com.alex.springsecurity.demo.controller.Portfolio"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <h1> Portfolio</h1>
    <hr>
    <div>
        <p> here are my products </p>
        here it is: <p> <% 
            
        List projList = new Products(Portfolio.query("where id = 1")).getList();
        Iterator it = projList.iterator();
        while(it.hasNext()){
            Products obj = (Products)it.next(); %>
        <p>  : <%= obj.getTitle() %> :  </p>
        <% }  %> </p>
    </div>
    <a href="${pageContext.request.contextPath}/homepage">Go back to homepage</a>
    </body>
</html>
