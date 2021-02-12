<%@page import="com.cybage.model.Course"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="../../library.jsp" %>
</head>
<body>

<%
	
	Course c = (Course)request.getAttribute("course");
	
%>
<form action="<%=request.getContextPath() %>/AdminController/updateCourseData?categoryname=<%=(String)request.getAttribute("categoryname")%>" method="post" enctype="multipart/form-data">
  <div class="form-group">
    <label for="exampleInputEmail1">Course Name</label>
    <input type="text" class="form-control" value="<%=c.getCoursename() %>" name="coursename" aria-describedby="emailHelp">
    <input type="text" name="courseid" value="<%=c.getCourseid() %>" hidden>
    
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Course Description</label>
    <input type="text" class="form-control"  name="coursedesc" value="<%=c.getCoursedescription() %>" >
  </div>
   <div class="form-group">
    <label for="exampleInputPassword1">Logo</label>
     <img src="data:image/jpeg;base64,<%=c.getEncode() %>" />
    <input type="file" class="form-control" name="courselogorypath" >
  </div>
    <div class="form-group">
    <label for="exampleInputPassword1">Course Price</label>
    <input type="text" class="form-control" name="courseprice" value="<%=c.getPrice()%>" >
  </div>
  
  <button type="submit" class="btn btn-primary">Save Changes</button>
</form>
</body>
</html>