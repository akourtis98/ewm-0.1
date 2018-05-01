<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
        <title>Products success</title>
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
            <h1>Products confirmation</h1>
            <h2> The Products is confirmed: ${Products.title} & ${Products.category};</h2>
            <hr>
            <a href="${pageContext.request.contextPath}/homepage">Go back to homepage</a>
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
