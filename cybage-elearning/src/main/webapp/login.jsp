
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@include file="/library.jsp" %>
<html>
<body>
<nav
      class="navbar navbar-expand-lg text-uppercase navbar-dark bg-dark py-3 myNav">
      <div class="container">
        <a class="navbar-brand" href="index.html">
        <img src="../assets/img/LOGO.png" style="height: 8vh" /></a>
      </div>
    </nav>

    <div class="container main">
      <div class="container-md container-sm my-5" id="login">
        <!-- Contact Section Heading-->
        <h2 class="heading-label text-center text-uppercase mb-3">Sign In</h2>
        <!-- Contact Section Form-->
        <div class="row text-uppercase text-secondary mb-0">
          <div class="col mx-auto">
          
          
          
           <form method="POST" action="j_security_check">
              <div class="form-floating emailcss">
               
                <label for="username">Username</label> <input type="text" class="form-control mb-3" id="username"  pattern="[a-zA-Z]*" required name="j_username" value="admin"/>
              </div>
              <div class="form-floating passwordcss">
               
                <label for="password">Password</label> <input type="password" class="form-control mb-3" id="password" name="j_password" value="admin" minlength="8" required/>
              </div>
             
              <div class="form-group">
                <button type="submit" id="subBtn" value="Login" class="loginbutton btn btn-success"> Login </button>
              </div>   
              </form>  
               
            <br/>
            
                <label>New User?</label>
                <a class="click-here-link" id="toggle_log_reg" href="<%=request.getContextPath()%>/registration.jsp">Create An Account</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  
  </body>
 
</html>
 