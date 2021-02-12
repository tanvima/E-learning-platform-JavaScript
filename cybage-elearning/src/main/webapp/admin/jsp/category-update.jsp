<%@page import="com.cybage.model.Category"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>
<%@include file="../../library.jsp" %>
<%@include file="header.jsp"%>
</head>
<body>
<br>
<form class="border w-50 rounded" action="<%=request.getContextPath() %>/AdminController/updateCategoryData" method="post" enctype="multipart/form-data">

<%

	Category c = (Category)request.getAttribute("category");
%>
  <div class="form-group">
    <label for="exampleInputEmail1">Category Name</label>
    <input type="text" class="form-control"  aria-describedby="emailHelp" value="<%=c.getCategoryname() %>" name="categoryname">
    <input type="text" name="categoryid" value="<%=c.getCategoryid()%>" hidden>
    
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Category Description</label>
    <input type="text" class="form-control"  value="<%=c.getCategorydescription() %>"  name="categorydesc">
  </div>
   <div class="form-group">
    <label for="exampleInputPassword1">Logo</label>
    <img src="data:image/jpeg;base64,<%=c.getEncode() %>" />
    <br><br>
    <input type="file" class="form-control"  name="categorypath">
  </div>
  
  <button type="submit" class="btn btn-primary" >Submit</button>
</form>

<%@include file="footer.jsp"%>
