package com.cybage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;

import com.cybage.dao.UserDao;
import com.cybage.dao.UserDaoImpl;
import com.cybage.exception.UserException;
import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.model.User;
import com.cybage.model.Video;
import com.cybage.service.UserServiceImpl;

public class GuestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GuestController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDao userDao = new UserDaoImpl();
		UserServiceImpl userService = new UserServiceImpl(userDao);
		String path = request.getPathInfo();
		System.out.println("PATH "+path);
		
		if (path.equals("/category1")) {
			System.out.println("in cate");
			List<Category> category = new ArrayList<Category>();
			try {
				category = userService.getAllCategory();
				for (Category c : category) {
					System.out.println(c.getCategoryname());

					byte[] bytes = IOUtils.toByteArray(c.getLogo());

					String encode = Base64.getEncoder().encodeToString(bytes);
					System.out.println(" viewing Encoded data " + encode);
					c.setEncode(encode);
				}
				request.setAttribute("categoryList", category);
				request.getRequestDispatcher("/index.jsp").forward(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if(path.equals("/course1")) {
			System.out.println("inside course display");
			List<Course> course = new ArrayList<Course>();
			String categoryname = request.getParameter("categoryname");
			System.out.println("-----------"+categoryname);
			System.out.println("categoryname "+categoryname);
			try {
				course = userService.getAllCourse(categoryname);
				
				for(Course c :course) {
					System.out.println(c.getCoursename());
					byte[] bytes = IOUtils.toByteArray(c.getCourselogo());
					String encode = Base64.getEncoder().encodeToString(bytes);
					System.out.println(" viewing course Encoded data " + encode);
					 c.setEncode(encode);
				}
				
				request.setAttribute("categoryname", categoryname);
				request.setAttribute("courseList", course);
				request.getRequestDispatcher("/course.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		  if (path.equals("/add1")) {

             
              String username = request.getParameter("username");
              String fullname = request.getParameter("fullname");
              String userpassword = request.getParameter("userpassword");
              String useremail = request.getParameter("useremail");

              User user = new User(username, fullname, userpassword, useremail, "user");

              try {
                    int addCount = userService.addUser(user);
                    if (addCount <= 0) {
                           throw new UserException("could not add user");
                    }
                    response.sendRedirect("../user/jsp/userindex.jsp");
                    
              } catch (Exception e) {
                    System.out.println(e.getLocalizedMessage());
              }
       }
		/*
		 * if(path.equals("/enroll-course")) { int courseid =
		 * Integer.parseInt(request.getParameter("courseid"));
		 * session.setAttribute("enrollCourseId", courseid);
		 * 
		 * List<Video> video = new ArrayList<Video>(); try { video =
		 * userService.getAllVideo(courseid); } catch (Exception e) {
		 * e.printStackTrace(); }
		 * 
		 * request.setAttribute("videoList", video);
		 * request.getRequestDispatcher("/user/jsp/confirm-enroll.jsp").forward(request,
		 * response);
		 * 
		 * }
		 */
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
