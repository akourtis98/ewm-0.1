<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
        <title>Sign up success</title>
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
             <h1>User confirmation</h1>
            <h2> The user is confirmed: ${User.username} & ${User.password} & ${User.fname} & ${User.lname};</h2>
            <hr>
            <a href="${pageContext.request.contextPath}/homepage">Go back to homepage</a>
        <div>
        <div id="footer">
            <div id="footer_a_div">
                <a href="">github</a>
                <a href="">linkedin</a>
                <a href="">hackerrank</a>
            </div>
        </div>
    </body>
</html>
