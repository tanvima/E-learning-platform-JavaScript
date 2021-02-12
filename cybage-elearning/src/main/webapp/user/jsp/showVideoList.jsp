
  
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
            <th scope="col">Status</th>
            
          </tr>
        </thead>
        <tbody>
        
      <c:forEach var="v" items="${videoList}">
      <tr>
					<td scope="row">${v.videoseq}</td>
					<td><a href = "<%=request.getContextPath()%>/user/jsp/videoplay.jsp?videopath=${v.videopath}&videoid=${v.videoid}&videoname=${v.videoname}&videoseq=${v.videoseq}">${v.videoname }</a></td>
					<td><video height="200px" width="500px" src="../media/${v.videopath}"></video></td>
					
					</td>

				</tr>
      
      </c:forEach>
     
          </tbody>
          </table>
</body>
</html>

