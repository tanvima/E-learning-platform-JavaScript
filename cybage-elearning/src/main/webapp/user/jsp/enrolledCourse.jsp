<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ page isELIgnored="false"%>
<%@include file="../../library.jsp"%>
<%@include file = "header.jsp" %>

</head>
<body>


<div  class="row justify-content-center" style="width: 75%;">
<c:set var="s" value="0"></c:set>
		<table class="table">
				<c:forEach var="c" items="${courseList}">
				
				<tr>
						<td rowspan="2"><img
							src="data:image/jpeg;base64,${c.encode}" /></td>
							<td class="card-title"><c:out value="${c.coursename }">
							</c:out>
							<input type="text" hidden name="courseid" value="${c.courseid}">
							<input type="text" hidden name="categoryname" value="">
							</td>	
						<td class="card-text"><c:out value="${c.coursedescription}">
							</c:out></td> 
							<td>Status :${status} </td>	
					</tr>
					<tr>
					<td>
					
					<form method="post"
								action="<%=request.getContextPath()%>/UserController/showVideo">
								<input type="text" value="${c.courseid}" name="courseid"
									hidden> 
									<input type="submit"
									class="card-link btn btn-primary" value="Start">
							</form>
						</td>
					</tr>
					

					<br>
					<br>
				</c:forEach>
		</table>
	</div>
</body>
</html>