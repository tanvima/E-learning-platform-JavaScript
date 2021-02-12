<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@include file="../../library.jsp"%>
<%@include file="header.jsp"%>

<div class="second-nav">
	<a class="btn btn-secondnav" data-toggle="modal"
		data-target="#exampleModalCenter"> Add Video </a>
	<form action="<%=request.getContextPath()%>/AdminController/course"
		class="inline1 float-right">
		<input type="text" name="categoryname"
			value="<%=request.getAttribute("categoryname")%>" hidden> <input
			type="submit" value="Back to Course" class="btn btn-secondnav">
	</form>
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Add Videos</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<form action="<%=request.getContextPath()%>/AdminController/addVideo"
				method="post">
				<input type="text" name="courseid"
					value="<%=request.getAttribute("courseid")%>" hidden> <input
					type="text" name="categoryname"
					value="<%=request.getAttribute("categoryname")%>" hidden>

				<div class="modal-body">
					Video name : <input type="text" name="videoname" id="videoname">
					<input type="text" hidden
						value="<%=request.getAttribute("courseid")%>" name="courseid">
					<br> <br> Video path : <input type="file"
						name="videopath" id="videopath"> <br> <br> Video
					Sequence : <input type="number" name="videoseq" min="1">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="submit" class="btn btn-primary">Save changes</button>
				</div>
			</form>
		</div>
	</div>
</div>
<br>
<center><h2>Videos</h2></center>
<div class="row justify-content-center">
	<table class="table w-50">
		<thead>
				<th scope="col">Sequence no</th>
				<th scope="col">Video name</th>
				<th scope="col">Video </th>
				<th scope="col">Update</th>
				<th scope="col">Delete</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="v" items="${videoList}">
				<tr>
					<td scope="row">${v.videoseq}</td>
					<td>${v.videoname }</td>
					<td><video height="200px" width="400px" controls src="../media/${v.videopath}"></video></td>
					<td><form
							action="<%=request.getContextPath()%>/AdminController/updateVideo"
							method="post">
							<input type="text" value="${v.videoid}" name="videoid" hidden>
							<input type="text"
								value="<%=request.getAttribute("categoryname")%>"
								name="categoryname" hidden> <input type="text"
								value="<%=request.getAttribute("courseid")%>" name="courseid"
								hidden> <input type="submit" value="Update"
								class="btn btn-warning">
						</form></td>

					<td>
						<form
							action="<%=request.getContextPath()%>/AdminController/deleteVideo"
							method="post">
							<input type="text" value="${v.videoid}" name="videoid" hidden>
							<input type="text"
								value="<%=request.getAttribute("categoryname")%>"
								name="categoryname" hidden> <input type="text"
								value="<%=request.getAttribute("courseid")%>" name="courseid"
								hidden> <input type="submit" value="Delete"
								class="btn btn-danger"
								onclick="return window.confirm('Are you sure?')">
						</form> <%-- <a href="<%=request.getContextPath()%>/AdminController/deleteVideo?videoid=${v.videoid}&courseid=<%=request.getAttribute("courseid") %>&categoryname=<%=request.getAttribute("categoryname") %>"  onclick = "return window.confirm('Are you sure?')" class="btn btn-danger">Delete</a> --%>
					</td>

				</tr>

			</c:forEach>

		</tbody>
	</table>
</div>

<br><br><br>

	<%@include file="footer.jsp"%>