<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    	<%@ page isELIgnored="false"%>
<%@include file="../../library.jsp" %>
<%@include file = "header.jsp" %>
 
     <%
     String videopath = request.getParameter("videopath");
     int videoid = Integer.parseInt(request.getParameter("videoid"));
     String videoname = request.getParameter("videoname");
     int videoseq = Integer.parseInt(request.getParameter("videoseq"));
     %>   
     
      <center>
					
				<h1><%=videoname%></h1> 
					
					<video height="600px" width="800px" controls src="../media/<%=videopath%>"></video>
          </center>
 
          <a href="<%=request.getContextPath()%>/UserController/videoplay?videoseq=<%=videoseq %>" class="btn btn-primary">Next video</a>
</body>
</html>
