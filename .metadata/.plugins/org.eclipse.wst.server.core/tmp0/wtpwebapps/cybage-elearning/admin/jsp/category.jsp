<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@include file="../../library.jsp"%>
<script>
$(document).ready(function(){
	$("#del").on("click",()=>{
		$cate = $(this).attr("id");
		console.log("hey "+$cate);
	})
});

</script>
</head>
<body>


	<a class="btn btn-primary" data-toggle="modal"
		data-target="#exampleModalCenter"> Add Category </a>
	<br>

	<!-- Modal -->
	<div class="modal fade" id="exampleModalCenter" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Add
						Category</h5>
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
							id="categoryname"> <br>
						<br> Category logo : <input type="file" name="categorypath"
							id="categorypath"> <br>
						<br> Category description : <input type="text"
							name="categorydesc" id="categorydescription">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="submit" class="btn btn-primary">Save
						changes</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<br>
	
	

<div class="alert" role="alert" id="result"></div>

	<table class="table">
		<tr class="row justify-content-center">


			<c:forEach var="c" items="${categoryList}">
	
				<td>
					<div class="card" style="width: 18rem;">
						<div class="card-body">
							<a href="<%=request.getContextPath()%>/AdminController/course?categoryname=${c.categoryname}">
								<h5 class="card-title">
									<c:out value="${c.categoryname }"></c:out>
								</h5>
								<p class="card-text">
									Description :
									<c:out value="${c.categorydescription}"></c:out>
								</p> <img src="data:image/jpeg;base64,${c.encode }" />
							</a> <a
								href="<%=request.getContextPath()%>/AdminController/updateCategory?category=${c.categoryname}"
								class="card-link btn btn-primary">Update</a>
								 <a href="<%=request.getContextPath()%>/AdminController/deleteCategory?category=${c.categoryname}" class="card-link btn btn-primary" id="del"  >Delete</a>
								 
						</div>
					</div>
				</td>
			</c:forEach>


		</tr>
	</table>
	
	<!-- Confirm modal -->

<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" id="mi-modal">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">You sure you want to delete?</h4>
      </div>
      <div class = "modal-body">
      here
      </div>
      <div class="modal-footer">
        <a href = "<%=request.getContextPath()%>/AdminController/deleteCategory?category=${name}" type="button" class="btn btn-default" id="modal-btn-si">Yes</a>
        <button type="button" class="btn btn-primary" id="modal-btn-no" class="close" data-dismiss="modal">No</button>
      </div>
    </div>
  </div>
</div>




</body>
</html>