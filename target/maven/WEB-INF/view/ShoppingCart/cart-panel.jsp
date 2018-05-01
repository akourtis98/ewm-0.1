<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
            <table style="width:45%;">
                            <tr>
                                <th>Title</th>
                                <th>Category</th>
                                <th>Price</th>
                                <th>Action</th>
                            </tr> <!-- needs work -->
                            <c:forEach var="products" items="${products}">
                                 <c:url var="deleteLink" value="deleteProductFromCart">
                                    <c:param name="id" value="${products.id}"/>
                                </c:url>
                                <tr>
                                    <td>${products.productName}</td>
                                    <td>${products.categoryOfProduct}</td>
                                    <td>${products.price}</td>
                                    <td><a href="${deleteLink}">Delete</a></td>
                                </tr>
                            </c:forEach>
            </table>
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
