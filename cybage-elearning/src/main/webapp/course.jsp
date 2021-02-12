
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ page isELIgnored="false"%>
<%@include file="/library.jsp"%>
</head>
<body>
<% String categoryname = (String)request.getAttribute("categoryname"); %>
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
	<br>
	<div  class="row justify-content-center" style="width: 75%;">
<table class="table">
				<c:forEach var="c" items="${courseList}">
				<tr><td>
						<img src="data:image/jpeg;base64,${c.encode }" />
							</td><td>
							<h4 style="text-align:center;"><c:out value="${c.coursename }">
							</c:out></h4>
							</td><td>
						<p style="text-align:center";><c:out value="${c.coursedescription}">
							</c:out></p>
						</td><td>
						
						<form action="<%=request.getContextPath()%>/UserController/enroll-course" method="post">
						<input type="text" name="courseid" value="${c.courseid}" hidden>
						<input type="submit" class="btn btn-success" value="Enroll">
						</form>
						<%-- <a href="<%=request.getContextPath()%>/UserController/enroll-course">
						<div style="text-align:center;">
							<button class="btn btn-success">Enroll</button>
						</div></a> --%>
					</td>
				<tr>
				</c:forEach>	
</table>
	</div>
</body>
</html>

