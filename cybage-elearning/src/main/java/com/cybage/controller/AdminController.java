package com.cybage.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cybage.dao.AdminDao;
import com.cybage.dao.AdminDaoImpl;
import com.cybage.exception.AdminException;
import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.model.Video;
import com.cybage.service.AdminService;
import com.cybage.service.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;

@MultipartConfig()
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger log = LogManager.getLogger(UserController.class);
	public AdminController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, AdminException {

		AdminDao adminDao = new AdminDaoImpl();
		AdminService adminService = new AdminServiceImpl(adminDao);
		String path = request.getPathInfo();

		if (path.equals("/category")) {
			List<Category> category = new ArrayList<Category>();
			try {
				category = adminService.getAllCategory();
				for (Category c : category) {
					byte[] bytes = IOUtils.toByteArray(c.getLogo());
					String encode = Base64.getEncoder().encodeToString(bytes);
					c.setEncode(encode);
				}

				request.setAttribute("categoryList", category);
				request.getRequestDispatcher("/admin/jsp/category.jsp").forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (path.equals("/addCategory")) {
			String categoryname = request.getParameter("categoryname");
			String categorydesc = request.getParameter("categorydesc");
			InputStream inputStream;
			Part filePart = request.getPart("categorypath");
			inputStream = filePart.getInputStream();
			Category category = new Category(categoryname, categorydesc, inputStream);
			try {
				int count = adminService.addCategory(category);
				if (count == 1) {
					log.info("Category added");
					response.sendRedirect("category");
				} else {
					throw new AdminException("Category cannot be added....Please try again");
				}

			} catch (SQLException e) {
				System.err.println(e.getLocalizedMessage());
			}
		}

		if (path.equals("/updateCategory")) {
			log.debug("trying to update category");
			String categoryName = request.getParameter("category");
			try {
				Category category = adminService.getCategory(categoryName);
				byte[] bytes = IOUtils.toByteArray(category.getLogo());
				String encode = Base64.getEncoder().encodeToString(bytes);
				category.setEncode(encode);
				System.out.println(category.getCategoryname());
				request.setAttribute("category", category);
				request.getRequestDispatcher("/admin/jsp/category-update.jsp").forward(request, response);
			} catch (SQLException e) {
				System.err.println(e.getLocalizedMessage());
			}

		}

		if (path.equals("/updateCategoryData")) {
			String categoryname = request.getParameter("categoryname");
			String categorydesc = request.getParameter("categorydesc");
			InputStream inputStream = null;

			Part filePart = request.getPart("categorypath");
			inputStream = filePart.getInputStream();

			byte[] b = IOUtils.toByteArray(inputStream);
			Category category = new Category(categoryname, categorydesc, inputStream);
			SerialBlob blob = null;
			try {
				blob = new SerialBlob(b);
			} catch (Exception e1) {

				e1.printStackTrace();
			}
			category.setImage(blob);
			category.setCategoryid(Integer.parseInt(request.getParameter("categoryid")));
			try {
				int count = adminService.updateCategory(category);
				if (count == 1) {
					log.info("Category updated");
					response.sendRedirect("category");
				} else {
					throw new AdminException("Category cannot be updated....Please try again later");
				}

			} catch (SQLException e) {
				System.err.println(e.getLocalizedMessage());
			}
		}

		if (path.equals("/deleteCategory")) {

			String categoryName = request.getParameter("category");
			try {
				int count = adminService.deleteCategory(categoryName);
				if (count == 0) {
					throw new AdminException("Category cannot be deleted...Please try again later");
				}
				log.info("Category deleted");
				response.sendRedirect("category");
			} catch (SQLException e) {
				System.err.println(e.getLocalizedMessage());
			}
		}

		if (path.equals("/course")) {
			List<Course> course = new ArrayList<Course>();
			String categoryname = request.getParameter("categoryname");
			try {
				course = adminService.getAllCourse(categoryname);

				for (Course c : course) {
					byte[] bytes = IOUtils.toByteArray(c.getCourselogo());
					String encode = Base64.getEncoder().encodeToString(bytes);
					c.setEncode(encode);
				}

				request.setAttribute("categoryname", categoryname);
				request.setAttribute("courseList", course);
				request.getRequestDispatcher("/admin/jsp/course.jsp").forward(request, response);
			} catch (SQLException e) {
				System.err.println(e.getLocalizedMessage());
			}

		}

		if (path.equals("/addCourse")) {

			String categoryname = request.getParameter("categoryname");
			String coursename = request.getParameter("coursename");

			String coursedesc = request.getParameter("coursedesc");
			int price = Integer.parseInt(request.getParameter("courseprice"));
			InputStream inputStream;
			Part filePart = request.getPart("courselogorypath");
			inputStream = filePart.getInputStream();
			Course course = new Course(coursename, inputStream, coursedesc, price);
			try {
				int count = adminService.addCourse(course, categoryname);
				if (count == 1) {
					log.info("Course added");
					request.getRequestDispatcher("/AdminController/course?categoryname=" + categoryname)
							.forward(request, response);
				} else {
					throw new AdminException("Course cannot be added.....Please try again");
				}

			} catch (SQLException e) {
				System.err.println(e.getLocalizedMessage());
			}

		}

		if (path.equals("/deleteCourse")) {

			int courseid = Integer.parseInt(request.getParameter("courseid"));
			String categoryname = request.getParameter("categoryname");
			try {

				int count = adminService.deleteCourse(courseid);
				if (count == 0) {
					throw new AdminException("Course cannot be deleted....Please try again");
				}
				log.info("Course deleted");
				request.getRequestDispatcher("/AdminController/course?categoryname=" + categoryname).forward(request,
						response);
			} catch (SQLException e) {
				System.err.println(e.getLocalizedMessage());
			}
		}

		if (path.equals("/updateCourse")) {
			log.debug("trying to update category");
			int courseid = Integer.parseInt(request.getParameter("courseid"));
			String categoryname = request.getParameter("categoryname");
			try {
				Course course = adminService.getCourse(courseid);
				byte[] bytes = IOUtils.toByteArray(course.getCourselogo());
				String encode = Base64.getEncoder().encodeToString(bytes);
				course.setEncode(encode);

				request.setAttribute("course", course);
				request.setAttribute("categoryname", categoryname);

				request.getRequestDispatcher("/admin/jsp/course-update.jsp").forward(request, response);
			} catch (SQLException e) {
				System.err.println(e.getLocalizedMessage());
			}

		}

		if (path.equals("/updateCourseData")) {

			String categoryname = request.getParameter("categoryname");
			String coursename = request.getParameter("coursename");
			int courseid = Integer.parseInt(request.getParameter("courseid"));
			String coursedesc = request.getParameter("coursedesc");
			int price = Integer.parseInt(request.getParameter("courseprice"));

			InputStream inputStream;
			Part filePart = request.getPart("courselogorypath");

			inputStream = filePart.getInputStream();
			byte[] b = IOUtils.toByteArray(inputStream);
			Course course = new Course(courseid, coursename, inputStream, coursedesc, price);
			SerialBlob blob = null;
			try {
				blob = new SerialBlob(b);
				course.setImage(blob);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			try {
				int count = adminService.updateCourse(course);
				if (count == 1) {
					log.info("Course updated");
					request.getRequestDispatcher("/AdminController/course?categoryname=" + categoryname)
							.forward(request, response);
				} else {
					throw new AdminException("Course cannot be updated..Please try again");
				}
			} catch (SQLException e) {

				System.err.println(e.getLocalizedMessage());
			}
		}

		if (path.equals("/video")) {

			List<Video> video = new ArrayList<Video>();
			String categoryname = request.getParameter("categoryname");
			request.setAttribute("categoryname", categoryname);
			int courseid = Integer.parseInt(request.getParameter("courseid"));

			try {
				video = adminService.getAllVideo(courseid);
				request.setAttribute("courseid", courseid);
				request.setAttribute("videoList", video);
				request.getRequestDispatcher("/admin/jsp/video.jsp").forward(request, response);
			} catch (SQLException e) {
				System.err.println(e.getLocalizedMessage());
			}

		}

		if (path.equals("/addVideo")) {
			String videoname = request.getParameter("videoname");
			String videopath = request.getParameter("videopath");
			int courseid = Integer.parseInt(request.getParameter("courseid"));
			int videoseq = Integer.parseInt(request.getParameter("videoseq"));
			String categoryname = request.getParameter("categoryname");
			request.setAttribute("categoryname", categoryname);

			Video video = new Video(videoname, videopath, videoseq);
			try {

				int count = adminService.addVideo(video, courseid);
				if (count == 1) {
					log.info("Video added");
					request.getRequestDispatcher("/AdminController/video?courseid=" + courseid).forward(request,
							response);
				} else {
					throw new AdminException("Video cannot be added....");
				}

			} catch (SQLException e) {
				System.err.println(e.getLocalizedMessage());
			}

		}
		if (path.equals("/updateVideo")) {
			log.debug("trying to update category");
			int courseid = Integer.parseInt(request.getParameter("courseid"));
			int videoid = Integer.parseInt(request.getParameter("videoid"));
			String categoryname = request.getParameter("categoryname");
			request.setAttribute("categoryname", categoryname);
			try {
				Video v = adminService.getVideo(videoid);
				request.setAttribute("video", v);
				request.setAttribute("courseid", courseid);
				request.getRequestDispatcher("/admin/jsp/video-update.jsp").forward(request, response);
			} catch (SQLException e) {
				System.err.println(e.getLocalizedMessage());
			}
		}

		if (path.equals("/updateVideoData")) {
			String videoname = request.getParameter("videoname");
			String videopath = request.getParameter("videopath");
			
			String categoryname = request.getParameter("categoryname");
			request.setAttribute("categoryname", categoryname);
			int videoseq = Integer.parseInt(request.getParameter("videoseq"));
			int courseid = Integer.parseInt(request.getParameter("courseid"));
			int videoid = Integer.parseInt(request.getParameter("videoid"));

			Video video = new Video(videoname, videopath, videoseq);
			try {

				int count = adminService.updateVideo(video, videoid);
				if (count == 1) {
					log.info("Video updated");
					request.getRequestDispatcher("/AdminController/video?courseid=" + courseid).forward(request,
							response);
				}
			} catch (SQLException e) {
				System.err.println(e.getLocalizedMessage());
			}
		}

		if (path.equals("/deleteVideo")) {
			int courseid = Integer.parseInt(request.getParameter("courseid"));
			int videoid = Integer.parseInt(request.getParameter("videoid"));
			String categoryname = request.getParameter("categoryname");
			request.setAttribute("categoryname", categoryname);
			try {

				int count = adminService.deleteVideo(videoid);
				if (count == 0) {
					throw new AdminException("Video cannot be deleted..Please try again");
				}
				log.info("Video deleted");
				request.getRequestDispatcher("/AdminController/video?courseid=" + courseid).forward(request, response);
			} catch (SQLException e) {
				System.err.println(e.getLocalizedMessage());
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
