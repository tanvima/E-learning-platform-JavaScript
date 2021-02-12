<%@page import="com.cybage.model.Video"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="../../library.jsp" %>
<%@include file="header.jsp"%>
</head>
<body>

<%
	
	Video v = (Video)request.getAttribute("video");

	
%>
<br>
<form action="<%=request.getContextPath() %>/AdminController/updateVideoData" method="post" class="border w-50 rounded">
<input type="text" name="videoid" value="<%=v.getVideoid()%>" hidden>
<input type="text" name="courseid" value="<%=request.getAttribute("courseid") %>" hidden>
<input type="text" name="categoryname" value="<%=request.getAttribute("categoryname") %>" hidden>
  <div class="form-group">
    <label for="exampleInputEmail1">Video Name</label>
    <input type="text" class="form-control" name="videoname" value="<%=v.getVideoname() %>" aria-describedby="emailHelp">
    
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Video Sequence</label>
    <input type="number" min="1" class="form-control" name="videoseq" value="<%=v.getVideoseq() %>" >
  </div>
   <div class="form-group">
    <label for="exampleInputPassword1">Video Path</label>
    <input type="file" class="form-control" name="videopath"value="<%=v.getVideopath() %>" >
  </div>
  
  <button type="submit" class="btn btn-primary">Save Changes</button>
</form>

<%@include file="footer.jsp"%>