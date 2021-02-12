<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="/library.jsp" %>
    <form action="<%=request.getContextPath()%>/UserController/edit-user" method="post">
<!DOCTYPE html>
<html>
<body>
  <%@ include file="header.jsp" %>

  <div class="container main" id="resetpassword">
    <div class=" container-md container-sm my-5 " id="login">
    
      <!-- Contact Section Heading-->
      <h2 class="heading-label text-center text-uppercase mb-3">Reset Password</h2>

       <!-- error Section -->
       <div id="reset-error-msg">
      </div>

      <!-- Contact Section Form-->
      <div class="row text-uppercase text-secondary mb-0">
        <div class="col mx-auto">
          <form class="text-uppercase" id="resetPasswordForm">

            <div class="form-floating passwordcss">
              <input type="email" class="form-control mb-3" id="emailforreset" name="emailforreset" placeholder="Enter Email" required  />
              <label for="emailforreset">Email</label>
            </div>

            <div class="form-floating passwordcss">
              <input type="password" class="form-control mb-3" id="newpassword" name="newpassword" placeholder="Enter Email" minlength="8" required />
              <label for="newpassword">Set New Password</label>
            </div>

            <div class="form-floating passwordcss">
              <input type="password" class="form-control mb-3" id="confirmnewpassword" name="confirmnewpassword" placeholder="secuityquestion" minlength="8" required />
              <label for="confirmnewpassword">Confirm Password</label>
            </div>


            <div class="form-group">
              <button type="submit" id="resetpassbtn" value="Next" class="loginbutton btn btn-success">Reset</button>
            </div>
          </form>
          <br>
        </div>
      </div>
    </div>
  </div>
  </div>

</body>
</html>