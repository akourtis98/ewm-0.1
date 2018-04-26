<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign in</title>
    </head>
    <body>
        
        <h1>Sign in</h1>
        <hr>
        <div style="margin: auto; width:600px;">
            Fill out the form below. Asterisk (*) means required
            <br><br>
            
               <c:if test="${param.error != null}">
                   <i style="color: red"> Sorry! You entered invalid username/password. </i>
                </c:if>
                  
            
            <form:form action="${pageContext.request.contextPath}/authenticateTheUser"
                       method="POST">
                Please enter your username: <input placeholder="username" name="username" type="email"/>
                <br><br>
                
                Please enter your password: <input placeholder="password" name="password" type="password"/>
                
                <br><br>
                
                <input type="submit" value="Sign in">
                
            </form:form> 
                <br>
                <hr>
            <a href="${pageContext.request.contextPath}/homepage">Go back to homepage</a>
    </div>
    </body>
</html>
