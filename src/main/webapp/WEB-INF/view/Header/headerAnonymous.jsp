<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div id="header">
             
            <div id="header_p_div2">
                 <div>
                    <i style="color: gray"> You are currently not logged in. </i>
                    <a href="${pageContext.request.contextPath}/signin">Sign in</a>
                    <a href="${pageContext.request.contextPath}/user/signup">Sign up</a>
                </div>
               
            </div>
                
                <div id="header_p_div2">
                <form:form action="panel/search" method="POST">
                    <input type="search" id="mySearch" name="searchTerm" 
                    placeholder="Search the site...">  <button>Search</button>
                </form:form>
                </div>
                
</div>