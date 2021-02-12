<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@include file="../css/styling.jsp" %>
</head>
<body>
     <nav class="navbar navbar-expand-lg">
          <a class="navbar-brand" href="#"><img src="../media/logo.jpeg" width="100" height="100" alt="LOGO"></a>
          <h1 class="navheading">Cybage E-Learning</h1>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
        
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
              <li class="nav-item active">
                
              </li>
              
            </ul>
           
            <div >
                <div class="center mr-5">
            
                    <center>
                       <h3 class="navheading"> Welcome <%= request.getRemoteUser() %>!</h3>
                      </center>
            
                </div>
              <a href="<%=request.getContextPath() %>/AdminController/category" class="btn ">Home</a>
              <a href="<%=request.getContextPath() %>/logout.jsp" class="btn  float-right">Logout</a>
            </div>
          </div>
         
        </nav>
       
        