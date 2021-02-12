<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="../../library.jsp" %>
</head>
<body>
<form>
  <div class="form-group">
    <label for="exampleInputEmail1">Video Name</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Video Sequence</label>
    <input type="text" class="form-control" id="exampleInputPassword1" >
  </div>
   <div class="form-group">
    <label for="exampleInputPassword1">Video Path</label>
    <input type="file" class="form-control" id="exampleInputPassword1" >
  </div>
  
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>