<%@page import="com.cybage.model.Category"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@include file="/library.jsp"%>
<head>
<title>Cybage e-Learning</title>
<style>
<%@include file="./user/css/index.css"%>
</style>
</head>

<body id="home">
	<!-- Navigation Bar -->
	<nav
		class="navbar navbar-expand-lg text-uppercase navbar-dark bg-dark py-3 myNav">
		<div class="container">
			<a class="navbar-brand" href="index.jsp"> <img alt=""
				src="media/logo.jpeg" style="height: 15vh"></a> 
			<button class="navbar-toggler navButton text-white" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				MENU <span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
						href="<%=request.getContextPath()%>">Home</a></li>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
						href="#aboutus">About Us</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Header Part -->
	<header class="masthead text-white text-center">
		<div class="container d-flex align-items-center flex-column">
			<h1 class="masthead-heading text-uppercase mb-0">
				Welcome!<br /> You're one step away from testing your knowledge!!!
			</h1>
			<a href="<%=request.getContextPath() %>/AppController">
				<button class="btn btn-success getStarted text-uppercase">Login</button>
			</a>
		</div>
	</header>
<body>
	
	<div class="alert" role="alert" id="result"></div>
	<table class="table">
		<tr class="row justify-content-center">
			<c:forEach var="c" items="${categoryList}">
				<td>
								<h5 class="card-title">
									<c:out value="${c.categoryname }"></c:out>
								</h5>
								<p class="card-text">
									Description :
									<c:out value="${c.categorydescription}"></c:out>
								</p> <img src="data:image/jpeg;base64,${c.encode }" />
							
							<a href="<%=request.getContextPath()%>/GuestController/course1?categoryname=${c.categoryname}">
				<button class="btn btn-success getStarted text-uppercase">Get Started !</button>
			</a>
						</div>
					</div>
				</td>
			</c:forEach>
		</tr>
	</table>
	<div class="extra"></div>
	<section class="about text-white mb-0" id="aboutus">
		<div class="container d-flex align-items-center flex-column">
			<br /> <br />
			<h2 class="text-center text-uppercase text-white">About Us</h2>
			<br />
			<h4>The eLearning group at Cybage works with corporate houses
				and publishers, enabling them to convert their existing large
				volumes of content to and from various formats rapidly. From
				customized e-books to online learning, to tailored course materials,
				to K-12 and higher education learning; Cybage acts as a one-stop
				shop that can help you discover the best and the most cost-effective
				eLearning solutions for your learning needs.</h4>
			<br /> <a href="<%=request.getContextPath()%>/user/jsp/registration.jsp"><button
					class="btn getStarted text-uppercase">Register Now !</button></a> <br />
		</div>
	</section>
	<!-- Around the web part -->
	<section class="footer text-center text-white">
		<br /> <br />
		<div class="container">
			<div class="row d-flex align-items-center flex-column">
				<div class="col-lg-4 mb-5">
					<h4 class="text-uppercase mb-4">Around the Web</h4>
					<a class="btn btn-outline-light mx-1"
						href="https://www.facebook.com/cybage/"><i
						class="fab fa-fw fa-facebook-f"></i></a> <a
						class="btn btn-outline-light mx-1"
						href="https://twitter.com/cybage?ref_src=twsrc%5Egoogle%7Ctwcamp%5Eserp%7Ctwgr%5Eauthor"><i
						class="fab fa-fw fa-twitter"></i></a> <a
						class="btn btn-outline-light mx-1"
						href="https://in.linkedin.com/company/cybage"><i
						class="fab fa-fw fa-linkedin-in"></i></a> <a
						class="btn btn-outline-light mx-1"
						href="https://www.instagram.com/cybage/?hl=en"><i
						class="fab fa-fw fa-instagram"></i></a>
				</div>
			</div>
		</div>
	</section>
	<!-- Footer End -->
	<section>
		<div class="container-fluid py-4 copyright text-center text-white">
			<small>&copy; Copyrights 2021. All rights reserved by Cybage
				e-Learning.</small>
		</div>
	</section>
</body>
</html>

