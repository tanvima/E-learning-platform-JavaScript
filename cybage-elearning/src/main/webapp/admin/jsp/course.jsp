
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ page isELIgnored="false"%>
<%@include file="../../library.jsp"%>
<%@include file="header.jsp"%>

<% String categoryname = (String)request.getAttribute("categoryname"); 
	
	
	
%>
 <div class = "second-nav">
          <a class="btn btn-secondnav" data-toggle="modal"
		data-target="#exampleModalCenter"> Add Course </a>
          <a class="btn btn-secondnav float-right" href="<%=request.getContextPath()%>/AdminController/category">Back to Category</a>
<marquee direction="left"> Click on courses to add or view videos </marquee>
        </div>
  
	

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
				<form action="<%=request.getContextPath()%>/AdminController/addCourse?categoryname=<%=(String)request.getAttribute("categoryname") %>" method="post" enctype="multipart/form-data" >
				<div class="modal-body">
					Course name : <input type="text" name="coursename" id="coursename" required>
					<br> <br> 
					Course logo : <input type="file"
						name="courselogorypath" id="coursepath">
						 <br> <br>
					Course description : <input type="text" name="coursedesc"
						id="coursedescription" required
						><br><br>
					Course Price :  <input type="number" min="0" name="courseprice"
						id="coursedescription" required>
						<br><br>
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
	<div  class="row justify-content-center" style="width:100%;">
	
		<table class="table row justify-content-center">
		<center><h2>Courses</h2></center>
				<c:forEach var="c" items="${courseList}">
				<tr>
						<td rowspan="2"><img
							src="data:image/jpeg;base64,${c.encode }" />
						</td>
							<td class="card-title">
							<form action=""><a class="data" href="<%=request.getContextPath()%>/AdminController/video?courseid=${c.courseid}&categoryname=<%=(String)request.getAttribute("categoryname") %>">
							<h3 ><c:out value="${c.coursename }"></h3>
							</c:out></a>
							<input type="text" hidden name="courseid" value="${c.courseid}">
							<input type="text" hidden name="categoryname" value="">
							</form>
							</td>
							
						<td class="card-text wordwrap "><c:out value="${c.coursedescription}" >
							</c:out></td>
							
						<td class="card-text"><c:out value="Rs. ${c.price}">
							</c:out></td>
					</tr>
					<tr>
					<td>
					
					<form method="post"
								action="<%=request.getContextPath()%>/AdminController/updateCourse" >
								<input type="text" value="${c.courseid}" name="courseid"
									hidden> 
									<input type="text" value="<%=(String)request.getAttribute("categoryname")%>" name="categoryname"
									hidden> 
									
									<input type="submit"
									class="card-link btn" style="color:white;background-color:#2c3e50" value="Update">
							</form>
					</td>
					<%-- <a href="<%=request.getContextPath()%>/AdminController/updateCourse?courseid=${c.courseid}&categoryname=<%=(String)request.getAttribute("categoryname")%>" class="card-link btn btn-primary">Update</a></td> --%>
					<td>
					<form method="post"
								action="<%=request.getContextPath()%>/AdminController/deleteCourse"  class="inline1">
								<input type="text" value="${c.courseid}" name="courseid"
									hidden> 
									<input type="text" value="<%=(String)request.getAttribute("categoryname")%>" name="categoryname"
									hidden> 
									
									<input type="submit"
									class="card-link btn" value="Delete" style="color:white;background-color:#2c3e50" onclick="return window.confirm('Are you sure?')">
							</form>
						</td>
						<br>
					</tr>
					<br>
					<br>
				</c:forEach>
		</table>
	</div>
	<br><br>

<%@include file="footer.jsp"%>

