<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
    }
        </style>
    </head>
    <body>
        <form:form action="search" method="POST">
            <input type="search" id="mySearch" name="searchTerm" 
            placeholder="Search the site...">  <button>Search</button>
            </form:form>
        <h1>Hello managers!</h1>
         <h4> User: <security:authentication property="principal.username"/> 
        <br>
        Role: <security:authentication property="principal.authorities" />
    </h4>
    <br>
    <a href="list-users" >
    <h3> for users management click here</h3>
    </a>
    <p>here are all the products:</p><hr>
    <table style="width:45%;">
                    <tr>
                        <th>title</th>
                        <th>category</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach var="products" items="${products}">
                        <tr>
                            <td>${products.user}</td>
                            <td>${products.product}</td>
                        </tr>
                    </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/homepage">Go back to homepage</a>
    </body>
</html>
