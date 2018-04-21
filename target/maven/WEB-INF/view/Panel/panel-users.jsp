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
        <h1>Hello managers!</h1>
            <form:form action="search-users" method="POST">
                <input type="search" id="mySearch" name="username" 
                placeholder="Search the site...">  <button>Search</button>
            </form:form>
         <h4> User: <security:authentication property="principal.username"/> 
        <br>
        Role: <security:authentication property="principal.authorities" />
    </h4>
    <br>
    <a href="list" >
    <h3> for products management click here</h3>
    </a>
    <p>here are all the users</p><hr>
    <table style="width:45%;">
                    <tr>
                        <th>username</th>
                        <th>password</th>
                        <th>action</th>
                    </tr>
                    <c:forEach var="users" items="${users}">
                          <c:url var="updateLink" value="updateUser">
                            <c:param name="username" value="${users.username}"/>
                        </c:url>
                             <c:url var="deleteLink" value="deleteUser">
                                <c:param name="username" value="${users.username}"/>
                            </c:url>
                        <tr>
                            <td>${users.username}</td>
                            <td>${users.password}</td>         
                            <td><a href="${updateLink}">Update</a></td>
                            <td><a href="${deleteLink}" onclick=" if (!(confirm('Are you sure you want to delete this product'))) return false">Delete</a></td>
                        </tr>
                    </c:forEach>                      
    </table>
    <a href="${pageContext.request.contextPath}/homepage">Go back to homepage</a>
    </body>
</html>
