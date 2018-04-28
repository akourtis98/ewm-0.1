<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Edit product</title>
         <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    </head>
    <body>
        <h1>Edit product</h1>
        <security:authorize access="hasRole('ANONYMOUS')">
            <jsp:include page="../Header/headerAnonymous.jsp"/>
            </security:authorize>  
            <security:authorize access="hasAnyRole('USER')">
                <jsp:include page="../Header/headerUser.jsp"/>
            </security:authorize>
            <security:authorize access="hasRole('ADMIN')">
                <jsp:include page="../Header/headerAdmin.jsp"/>
            </security:authorize> 
        <hr>
        <div style="margin: auto; width:500px;">
            Fill out the form below. Asterisk (*) means required
            <br><br>
            <form:form action="saveProduct" modelAttribute="Products" method="POST">
                <form:hidden path="id"/>
                Please edit title of product: <form:input path="title" type="text"/>
                <br><br>
                Please edit price of product: <form:input path="price" type="text"/>
                <br><br>
                Please edit the category:
                <form:select path="category">
                    <option value="Shoes">Shoes</option>
                    <option value="Jackets">Jackets</option>
                    <option value="Hats">Hats</option>
                </form:select>
               
                <br><br>    
                <input type="submit" value="Complete">
                
              </form:form> 
                <br>
                <hr>
                <a href="${pageContext.request.contextPath}/homepage">Go back to homepage</a>
    </div>
    </body>
</html>
