<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign up success</title>
    </head>
    <body>
        <h1>User confirmation</h1>
        <h2> The user is confirmed: ${User.username} & ${User.password};</h2>
        <hr>
        <a href="${pageContext.request.contextPath}/homepage">Go back to homepage</a>
    </body>
</html>
