<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products success</title>
    </head>
    <body>
        <h1>Products confirmation</h1>
        <h2> The Products is confirmed: ${Products.title} & ${Products.category};</h2>
        <hr>
        <a href="${pageContext.request.contextPath}/homepage">Go back to homepage</a>
    </body>
</html>
