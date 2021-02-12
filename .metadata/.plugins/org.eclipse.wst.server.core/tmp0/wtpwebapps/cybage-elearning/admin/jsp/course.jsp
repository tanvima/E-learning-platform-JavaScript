
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ page isELIgnored="false"%>
<%@include file="../../library.jsp"%>
</head>
<body>
<% String categoryname = (String)request.getAttribute("categoryname"); %>
	<a class="btn btn-primary" data-toggle="modal"
		data-target="#exampleModalCenter"> Add Course </a>
	<br>

	<!-- Modal -->
	<div class="modal fade" id="exampleModalCenter" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Add Courses</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="<%=request.getContextPath()%>/AdminController/addCourse?categoryname=<%=(String)request.getAttribute("categoryname") %>" method="post" enctype="multipart/form-data">
				<div class="modal-body">
					Course name : <input type="text" name="coursename" id="coursename">
					<br> <br> Course logo : <input type="file"
						name="courselogorypath" id="coursepath"> <br> <br>
					Course description : <input type="text" name="coursedesc"
						id="coursedescription"><br><br>
					Course Price :  <input type="text" name="courseprice"
						id="coursedescription"><br><br>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="submit" class="btn btn-primary" >Save changes</button>
				</div>
				</form>
			</div>
		</div>
	</div>
	<br>
	<div  class="row justify-content-center" style="width: 75%;">

		<table class="table">
				<c:forEach var="c" items="${courseList}">
				<tr>
						<td rowspan="2"><img
							src="data:image/jpeg;base64,${c.encode }" /></td>
							<td class="card-title"><c:out value="${c.coursename }">
							</c:out></td>
						<td class="card-text"><c:out value="${c.coursedescription}">
							</c:out></td>
						
					</tr>
					<tr>
					<td><a href="<%=request.getContextPath()%>/AdminController/updateCourse?courseid=${c.courseid}&categoryname=<%=(String)request.getAttribute("categoryname")%>" class="card-link btn btn-primary">Update</a></td>
						<td><a href="<%=request.getContextPath()%>/AdminController/deleteCourse?courseid=${c.courseid}&categoryname=<%=(String)request.getAttribute("categoryname") %>" class="card-link btn btn-primary">Delete</a></td>
						
					</tr>
					

					<br>
					<br>
				</c:forEach>
		</table>
	</div>
</body>
</html>

