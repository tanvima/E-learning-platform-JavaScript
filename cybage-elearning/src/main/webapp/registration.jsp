<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@include file="/library.jsp" %>
<form action="<%=request.getContextPath()%>/GuestController/add1" method="post">
 <body>
    <%@ include file="./user/jsp/header.jsp" %>
	<div class="container my-5">
      <div class="authentication container-md container-sm" id="register">
        <!-- Contact Section Heading-->
        <h2 class="heading-label text-center text-uppercase mb-3">Create New Account </h2>
        <div id="error-msg"></div>
        <!-- Contact Section Form-->
        <div class="row text-uppercase text-secondary mb-0">
          <div class="col mx-auto">
            <form class="text-uppercase" id="registrationForm">
            
              <div class="form-floating">
               <label for="firstname">User Name</label>
                <input type="text" class="form-control mb-3" id="username"  name="username" placeholder="username" minlength="3" pattern="[a-zA-Z]*" required />
              
              </div>
              
              <div class="form-floating">
              <label for="fullname">Full Name</label>
                <input type="text" class="form-control mb-3" id="fullname"  name="fullname" placeholder="fullname" minlength="3" pattern="[a-zA-Z]*" required/>
                
              </div>
                <div class="form-floating">
                  <label for="password">Password</label>
                <input type="password"  class="form-control mb-3" id="userpassword" name="userpassword"  placeholder="password" minlength="8" required/>
              
                </div>    
                  
                <div class="form-floating">
                <label for="confirmpass">Confirm Password</label> 
                <input type="password" class="form-control mb-3" id="confirmpass" placeholder="confirmpassword" minlength="8" required/>
                
                </div> 
                 <div class="form-floating">
                 <label for="email">Email</label> 
                	<input type="email"  class="form-control mb-3" id="useremail" name="useremail" placeholder="Email" pattern="^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$" required/>
                 	
               <div class="form-group">
                <button type="submit" id="registerbtn" class="loginbutton btn btn-success">Register</button>
               </div>
            </form>
            
            <div class="mt-2">
              <label>Already User?</label>
              <a class="click-here-link" id="toggle_log_reg" href="login.jsp">Login</a>
            </div>
          </div>
        </div>
      </div>
    </div>
<%@ include file="./user/jsp/footer.jsp" %>
</body>
</html>