<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.alex.springsecurity.demo.dao.Products"%>
<%@page import="com.alex.springsecurity.demo.controller.Portfolio"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Portfolio</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <h1> Portfolio</h1>
    <hr>
    <div>
        <p> here are my products </p>
        here it is: <p> <% 
            
        List projList = new Products(Portfolio.query("")).getList();
        Iterator it = projList.iterator();
        while(it.hasNext()){
            Products obj = (Products)it.next(); %>
        <p>  : <%= obj.getTitle() %> :  </p>
        <% }  %> </p>
    
    <a href="${pageContext.request.contextPath}/products-1"> products1 </a>
    </div>
    <a href="${pageContext.request.contextPath}/homepage">Go back to homepage</a>
</body>
</html>