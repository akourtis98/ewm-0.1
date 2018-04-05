<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                    <c:forEach var="tempProducts" items="${products}">
                        <c:url var="updateLink" value="updateProduct">
                            <c:param name="id" value="${tempProducts.id}"/>
                        </c:url>
                         <c:url var="deleteLink" value="deleteProduct">
                            <c:param name="id" value="${tempProducts.id}"/>
                        </c:url>
                        <tr>
                            <td>${tempProducts.title}</td>
                            <td>${tempProducts.category}</td>
                            <td><a href="${updateLink}">Update</a></td>
                            <td><a href="${deleteLink}" onclick=" if (!(confirm('Are you sure you want to delete this product'))) return false">Delete</a></td>
                        </tr>
                    </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/homepage">Go back to homepage</a>
    </body>
</html>
