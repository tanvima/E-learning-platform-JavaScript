<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@include file="../../library.jsp"%>
<%@include file="header.jsp"%>

<div class="second-nav">
	<a class="btn btn-secondnav" data-toggle="modal"
		data-target="#exampleModalCenter"> Add Category </a>

	<marquee direction="left"> Click on category to add courses or view courses </marquee>

</div>

<!-- 
	<a class="btn btn-primary" data-toggle="modal"
		data-target="#exampleModalCenter"> Add Category </a> -->
<br>


<!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Add Category</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form
					action="<%=request.getContextPath()%>/AdminController/addCategory"
					method="post" enctype="multipart/form-data">

					Category name : <input type="text" name="categoryname"
						id="categoryname" required> <br> <br> Category
					logo : <input type="file" name="categorypath" id="categorypath">
					<br>
					<br> Category description : <input type="text"
						name="categorydesc" id="categorydescription" required>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="submit" class="btn btn-primary">Save changes</button>
				</form>
			</div>
		</div>
	</div>
</div>
<br>



<div class="alert" role="alert" id="result"></div>

<table class="table">
	<tr class="row justify-content-center">

		<center><h2>Categories</h2></center>
		<c:forEach var="c" items="${categoryList}">

			<td>
				<div class="card" style="width: 20rem;">
					<div class="card-body">

						<a
							href="<%=request.getContextPath()%>/AdminController/course?categoryname=${c.categoryname}">
							<h5 class="card-title data">
								<c:out value="${c.categoryname }"></c:out>
							</h5>
							<p class="card-text data">
								Description :
								<c:out value="${c.categorydescription}"></c:out>
							</p>
							<div class="img-fluid">
								<img height="200" widht="20" class="rounded mx-auto d-block"
									src="data:image/jpeg;base64,${c.encode }" />
							</div>
						</a> <br>
						<center>
							<form method="post"
								action="<%=request.getContextPath()%>/AdminController/updateCategory"
								class="inline1">
								<input type="text" value="${c.categoryname}" name="category"
									hidden> <input type="submit" class="card-link btn "
									value="Update" style="color: white; background-color: #2c3e50">
							</form>

							<a
								href="<%=request.getContextPath()%>/AdminController/deleteCategory?category=${c.categoryname}"
								onclick="return window.confirm('Are you sure?')"
								class="card-link btn  inline1" id="del"
								style="color: white; background-color: #2c3e50">Delete</a>
						</center>
					</div>
				</div>
			</td>
		</c:forEach>


	</tr>
</table>



<%@include file="footer.jsp"%>