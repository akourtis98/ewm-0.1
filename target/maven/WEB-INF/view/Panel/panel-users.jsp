<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello managers!</h1>
            <security:authorize access="hasRole('ANONYMOUS')">
            <jsp:include page="../Header/headerAnonymous.jsp"/>
            </security:authorize>  
            <security:authorize access="hasAnyRole('USER')">
                <jsp:include page="../Header/headerUser.jsp"/>
            </security:authorize>
            <security:authorize access="hasRole('ADMIN')">
                <jsp:include page="../Header/headerAdmin.jsp"/>
            </security:authorize> 
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
