<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
        <title>Sign in</title>
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
            <br>  
                <c:if test="${param.error != null}">
                   <i style="color: red"> Sorry! You entered invalid username/password. </i>
                </c:if>
                  
            <form:form action="${pageContext.request.contextPath}/authenticateTheUser"
                       method="POST">
                Please enter your email: <input placeholder="username" name="username" type="email"/>
                <br><br>
                
                Please enter your password: <input placeholder="password" name="password" type="password"/>
                
                <br><br>
                
                <input type="submit" value="Sign in">
                
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
