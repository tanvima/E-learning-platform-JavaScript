package com.cybage.model;

public class User {
       private int userid;
       private String username;
       private String fullname;
       private String userpassword;
       private String useremail;
       private String role="user";
       public User() {
              super();
       }
       
       public User(String userpassword, String useremail) {
              super();
              this.userpassword = userpassword;
              this.useremail = useremail;
       }

       public User(String username, String fullname, String userpassword, String useremail, String role) {
              super();
              this.username = username;
              this.fullname = fullname;
              this.userpassword = userpassword;
              this.useremail = useremail;
              
       }
       public User(int userid,String username, String fullname, String useremail, String role) {
              super();
              this.userid = userid;
              this.username = username;
              this.fullname = fullname;
              this.useremail = useremail;
       }
       
       public int getUserid() {
              return userid;
       }
       public void setUserid(int userid) {
              this.userid = userid;
       }
       public String getUsername() {
              return username;
       }
       public void setUsername(String username) {
              this.username = username;
       }
       public String getFullname() {
              return fullname;
       }
       public void setFullname(String fullname) {
              this.fullname = fullname;
       }
       public String getUserpassword() {
              return userpassword;
       }
       public void setUserpassword(String userpassword) {
              this.userpassword = userpassword;
       }
       public String getUseremail() {
              return useremail;
       }
       public void setUseremail(String useremail) {
              this.useremail = useremail;
       }
       public String getRole() {
              return role;
       }
       public void setRole(String role) {
              this.role = role;
       }
       

}
