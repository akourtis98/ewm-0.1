<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Add a product</title>
        <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
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
        <div id="mainBody">
            <div style="margin: auto; width:500px;">
                Fill out the form below. Asterisk (*) means required
                <br><br>
                <form:form action="${pageContext.request.contextPath}/add-product/processProduct" modelAttribute="Products">

                    Please type title of product (*)<form:input path="title" type="text"/>
                    <form:errors path="title" cssClass="error"/>
                    <br><br>


                    Please type category (*)
                    <form:select path="category">
                        <option value="Shoes">Shoes</option>
                        <option value="Jackets">Jackets</option>
                        <option value="Hats">Hats</option>
                    </form:select>
                    <form:errors path="category" cssClass="error"/>
                    <br><br>    

                    Please type title of product (*)<form:input path="price" type="text"/>
                    <form:errors path="price" cssClass="error"/>


                    <input type="submit" value="Complete">

                  </form:form> 
                    <br>
                    <hr>
                    <a href="${pageContext.request.contextPath}/homepage">Go back to homepage</a>
            </div>
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
