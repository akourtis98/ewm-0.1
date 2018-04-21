<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Edit product</title>
    </head>
    <body>
        <h1>Edit product</h1>
        <hr>
        <div style="margin: auto; width:500px;">
            Fill out the form below. Asterisk (*) means required
            <br><br>
            <form:form action="saveUser" modelAttribute="User" method="POST">
                Please edit username: <form:input path="password" type="text"/>
                <form:hidden path="username"/>
                <input type="submit" value="Complete">
             </form:form> 
                <br>
                <hr>
                <a href="${pageContext.request.contextPath}/homepage">Go back to homepage</a>
    </div>
    </body>
</html>
