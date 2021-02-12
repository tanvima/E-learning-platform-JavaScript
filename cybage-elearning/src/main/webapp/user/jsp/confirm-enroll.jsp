
  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    	<%@ page isELIgnored="false"%>
<%@include file="../../library.jsp" %>
<%@include file = "header.jsp" %>
  <table class="table">
        <thead>
          <tr>
            <th scope="col">Sr no</th>
            <th scope="col">Video name</th>
            
          </tr>
        </thead>
        <tbody>
        
      <c:forEach var="v" items="${videoList}">
       <tr>
            <td scope="row">${v.videoseq}</td>
            <td>${v.videoname }</td>
          <%--   <td>
            <form action="<%=request.getContextPath()%>/AdminController/deleteVideo" method="post">
            <input type="text" value="${v.videoid}" name="videoid" hidden>
            <input type="text" value="<%=request.getAttribute("categoryname") %>" name="categoryname" hidden>
             <input type="text" value="<%=request.getAttribute("courseid") %>" name="courseid" hidden>
            <input type="submit" value="Delete" class="btn btn-warning" onclick="return window.confirm('Are you sure?')">
            </form>
            </td> --%>
            
          </tr>
      
      </c:forEach>
     
          </tbody>
          </table>
<br><br>
<a href="<%=request.getContextPath() %>/UserController/confirm-enroll" class="btn btn-primary">Confirm Enroll</a>
</body>
</html>

