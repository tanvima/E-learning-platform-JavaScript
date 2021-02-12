<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/header.css">
</head>
<body>
<nav
      class="navbar navbar-expand-lg text-uppercase navbar-dark bg-dark py-3 myNav">
      <div class="container">
       <a class="navbar-brand" >
        <img src="../../media/logo.jpeg" style="height: 8vh;"></a>
        <h2 style="color:white">Cybage e-Learning</h2>
       <li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
						href="<%=request.getContextPath()%>/user/jsp/user-dashboard.jsp"  style="color:white" >My Dashboard</a></li>
						<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
						href="<%=request.getContextPath() %>/logout.jsp"  style="color:white">Logout</a></li>
				</ul>
        
      </div>
    </nav>
