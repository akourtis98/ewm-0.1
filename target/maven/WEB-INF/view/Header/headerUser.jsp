<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div id="header">
                    <div id="header_p_div1">
                <a href="${pageContext.request.contextPath}/products">Products</a>
                <a href="${pageContext.request.contextPath}/shoppingcart/list">My shopping cart</a>
                    </div>
                    <div id="header_p_div2">
                    <form:form action="panel/search" method="POST">
                       <input type="search" id="mySearch" name="searchTerm" 
                       placeholder="Search the site...">  <button>Search</button>
                   </form:form>
                   </div>
                    <div id="header_p_div2">
                    <form:form action="${pageContext.request.contextPath}/homepage"
                        method="POST">
                    <input type="submit" value="Logout"/>
                    </form:form>
                </div></div>