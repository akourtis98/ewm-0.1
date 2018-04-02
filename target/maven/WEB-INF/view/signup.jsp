<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sign up</title>
    </head>
    <body>
        <h1>Sign up</h1>
        <hr>
        <div style="margin: auto; width:500px;">
            Fill out the form below. Asterisk (*) means required
            <br><br>
            <form:form action="${pageContext.request.contextPath}/user/processSignup" modelAttribute="User">
         
                Please create a username: (*)<form:input path="username" type="text"/>
                <form:errors path="username" cssClass="error"/>
                <br><br>
                
                Please create a password: (*)<form:input path="password" type="password"/>
                
                <form:errors path="password" cssClass="error"/>
               
                <br><br>    
                
                <input type="submit" value="Sign up">
                
              </form:form> 
                <br>
                <hr>
                <a href="${pageContext.request.contextPath}/homepage">Go back to homepage</a>
    </div>
    </body>
</html>
