package com.cybage.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cybage.dao.AdminDao;
import com.cybage.dao.AdminDaoImpl;
import com.cybage.dao.UserDao;
import com.cybage.dao.UserDaoImpl;
import com.cybage.exception.UserException;
import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.model.User;
import com.cybage.model.Video;
import com.cybage.service.AdminService;
import com.cybage.service.AdminServiceImpl;
import com.cybage.service.UserService;
import com.cybage.service.UserServiceImpl;

@MultipartConfig()
public class UserController extends HttpServlet {
	public static final Logger log = LogManager.getLogger(UserController.class);
	private static final long serialVersionUID = 1L;

	public UserController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDao userDao = new UserDaoImpl();
		UserServiceImpl userService = new UserServiceImpl(userDao);
		String path = request.getPathInfo();
		HttpSession session = request.getSession();

		PrintWriter pw = response.getWriter();
		String path1 = request.getPathInfo();

		if (path1.equals("/add")) {

			log.debug("inside add method....");
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
				response.sendRedirect("../user/jsp/login.jsp");

			} catch (Exception e) {
				log.error("exception occurred... " + e.getLocalizedMessage());
			}
		}
//      actual updation happens here...

		if (path1.equals("/edit-user")) {
			log.debug("inside edit-user method....");
			String userpassword = request.getParameter("userpassword");
			String useremail = request.getParameter("useremail");
			User user = new User(userpassword, useremail);
			try {
				int updateCount = userService.udpateUser(user);
				if (updateCount <= 0) {
					throw new UserException("could not update user");
				}
				response.sendRedirect("../user/jsp/login.jsp");

			} catch (Exception e) {
				log.error("exception occurred... " + e.getLocalizedMessage());
			}
		}

		if (path1.equals("/category")) {
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
				request.getRequestDispatcher("/user/jsp/indexuser.jsp").forward(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (path1.equals("/course")) {
			System.out.println("inside course display");
			List<Course> course = new ArrayList<Course>();
			String categoryname = request.getParameter("categoryname");
			System.out.println("-----------" + categoryname);
			System.out.println("categoryname " + categoryname);
			try {
				course = userService.getAllCourse(categoryname);

				for (Course c : course) {
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

		// for enrollment
		
		  
		  if(path.equals("/enroll-course")) { int courseid =
		  Integer.parseInt(request.getParameter("courseid"));
		  session.setAttribute("enrollCourseId", courseid);
		  
		  List<Video> video = new ArrayList<Video>(); try { video =
		  userService.getAllVideo(courseid); } catch (Exception e) {
		  e.printStackTrace(); }
		  
		  request.setAttribute("videoList", video);
		  request.getRequestDispatcher("/user/jsp/confirm-enroll.jsp").forward(request,
		  response);
		  
		  }
		 

		// confirm enroll
		if (path.equals("/confirm-enroll")) {

			String username = request.getRemoteUser();
			int courseid = (Integer) session.getAttribute("enrollCourseId");

			System.out.println(courseid + username);
			try {
				int addCount = userService.enrollCourse(username, courseid);
				if (addCount == 1) {
					request.setAttribute("enrolledCourseId", courseid);
					request.getRequestDispatcher("/user/jsp/user-dashboard.jsp").forward(request, response);
				}
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		// get enrolled course in user-dashboard
		if (path.equals("/getEnrolledCourse")) {
			String username = request.getRemoteUser();
			System.out.println("in getEnrolled course " + username);
			try {
				List<Course> c = userService.getEnrolledCourse(username);
				List<String> status = userService.getAllStatus(username);
				for (Course course : c) {
					byte[] bytes = IOUtils.toByteArray(course.getCourselogo());
					String encode = Base64.getEncoder().encodeToString(bytes);
					course.setEncode(encode);
				}
				request.setAttribute("courseList", c);
				request.setAttribute("status", status);
				request.getRequestDispatcher("/user/jsp/enrolledCourse.jsp").forward(request, response);
				;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (path.equals("/showVideo")) {
			int courseid = Integer.parseInt(request.getParameter("courseid"));
			session.setAttribute("courseid", courseid);

			List<Video> video = new ArrayList<Video>();
			try {
				video = userService.getAllVideo(courseid);
			} catch (Exception e) {
				e.printStackTrace();
			}

			request.setAttribute("videoList", video);

			request.getRequestDispatcher("/user/jsp/showVideoList.jsp").forward(request, response);

		}

		if (path.equals("/videoplay")) {
			int courseid = (int) (session.getAttribute("courseid"));
			int videoseq = Integer.parseInt(request.getParameter("videoseq"));

			try {
				int videohist = userService.getHistory(request.getRemoteUser(), courseid);
				System.out.println("video play his " + videohist);
				videohist++;
				userService.updateHistory(request.getRemoteUser(), courseid, videohist);
			} catch (Exception e1) {

				e1.printStackTrace();
			}
			videoseq++;
			try {
				List<Video> video = userService.getAllVideo(courseid);
				for (Video v : video) {
					if (v.getVideoseq() == videoseq) {
						request.getRequestDispatcher(
								"/user/jsp/videoplay.jsp?videopath=" + v.getVideopath() + "&videoid=" + v.getVideoid()
										+ "&videoname=" + v.getVideoname() + "&videoseq=" + v.getVideoseq())
								.forward(request, response);
					}
				}

				int watch = userService.getHistory(request.getRemoteUser(), courseid);
				int total = userService.getTotalCount(courseid);
				if (watch >= total) {
					userService.updateStatus(request.getRemoteUser(), courseid);
					request.getRequestDispatcher("/user/jsp/coursecomplete.jsp").forward(request, response);
				} else {

					request.getRequestDispatcher("/UserController/showVideo?courseid=" + courseid).forward(request,
							response);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
