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
            <form:form action="${pageContext.request.contextPath}/add-product/processProduct" modelAttribute="Products">
         
                Please type title of product (*)<form:input path="title" type="text"/>
                <form:errors path="title" cssClass="error"/>
                <br><br>
                

                Please type category (*)<form:select path="category">
                    <option value="volvo">Shoes</option>
                    <option value="saab">Jackets</option>
                    <option value="opel">Hats</option>
                </form:select>
                <form:errors path="category" cssClass="error"/>
               
                <br><br>    
                <input type="submit" value="Sign up">
                
              </form:form> 
                <br>
                <hr>
                <a href="${pageContext.request.contextPath}/homepage">Go back to homepage</a>
    </div>
    </body>
</html>
