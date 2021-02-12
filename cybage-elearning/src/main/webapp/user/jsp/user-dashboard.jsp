<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@include file="../../library.jsp" %>
       <link href="../css/user-dashboard.css" rel="stylesheet" />


   
</head>
<body id="home">
    <!-- Navigation Bar -->
    <nav class="navbar navbar-expand-lg text-uppercase navbar-dark bg-dark py-3 myNav">
      <div class="container">

        <ul class="nav align-items-center">
        <li class="nav-item">
            <img src="../../media/logo.jpeg"  style="height: 8vh">
          </li>
          <li class="nav-item">
           <h2>Cybage e-Learning</h2>
          </li>
          <li class="nav-item">
          
            <h6 class="welcomeuser">Welcome User <span id="username"></span></h6>
          </li>
          <li class="nav-item">
          <a href="<%=request.getContextPath()%>/index.jsp">
            <button class="btn btn-sm btn-success logoutbutton" id="logout">
              Logout
            </button>
          </li>
        </ul>
      </div>
    </nav>

    <!-- Category Part -->

    <div class="container main-container d-flex justify-content-center my-5">
      <div class="row justify-content-between">
        <div class="left-container col-md-8 col-lg-12  mb-3 py-4 align-self-start">
          <div class="profile container">
            <h3>Dashboard</h3>
          </div>
          <div class="menu container">
            <div class="list-group" id="list-tab" role="tablist">
              <a class="list-group-item list-group-item-action list-group-item-success active" id="category-list"
                data-bs-toggle="list"
                href="<%=request.getContextPath() %>/UserController/getEnrolledCourse"
                role="tab"
                aria-controls="category"
                >My Courses</a>
              <a
                class="list-group-item list-group-item-action list-group-item-success"
                id="mystatus-list"
                data-bs-toggle="list"
                href="#list-mystatus"
                role="tab"
                aria-controls="home">Status</a>
            
              
            </div>
          </div>
        </div>
        <div class="right-container col-md-8 col-lg-12 px-3">
          <div class="tab-content container" id="nav-tabContent">
          
          </div>
        </div>
      </div>
    </div>

    <!-- Footer End -->
    <div class="container-fluid py-4 copyright text-center text-white">
      <small
        >&copy; Copyrights 2021. All rights reserved by Cybage e-Learning.</small
      >
    </div>
  </body>
</html>