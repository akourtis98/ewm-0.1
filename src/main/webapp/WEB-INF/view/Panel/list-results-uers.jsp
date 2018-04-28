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
        <security:authorize access="hasRole('ANONYMOUS')">
            <jsp:include page="../Header/headerAnonymous.jsp"/>
            </security:authorize>  
            <security:authorize access="hasAnyRole('USER')">
                <jsp:include page="../Header/headerUser.jsp"/>
            </security:authorize>
            <security:authorize access="hasRole('ADMIN')">
                <jsp:include page="../Header/headerAdmin.jsp"/>
            </security:authorize> 
         <h4> User: <security:authentication property="principal.username"/> 
        <br>
        Role: <security:authentication property="principal.authorities" />
    </h4>
    <br>
    <a href="${pageContext.request.contextPath}/panel/list" >
    <h3> to go back to panel click here</h3>
    </a>
    <p>here are the results:</p><hr>
    <table style="width:45%;">
                    <tr>
                        <th>title</th>
                        <th>category</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach var="tempUsers" items="${users}">
                        <c:url var="updateLink" value="updateUser">
                            <c:param name="username" value="${tempUsers.username}"/>
                        </c:url>
                         <c:url var="deleteLink" value="deleteUser">
                            <c:param name="username" value="${tempUsers.username}"/>
                        </c:url>
                        <tr>
                            <td>${tempUsers.username}</td>
                            <td>${tempUsers.password}</td>
                            <td><a href="${updateLink}">Update</a></td>
                            <td><a href="${deleteLink}" onclick=" if (!(confirm('Are you sure you want to delete this product'))) return false">Delete</a></td>
                        </tr>
                    </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/homepage">Go back to homepage</a>
    </body>
</html>
