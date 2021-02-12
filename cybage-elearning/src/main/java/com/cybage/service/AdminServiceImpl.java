package com.cybage.service;

import java.util.List;
import java.util.stream.Collectors;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Comparator;

import com.cybage.dao.AdminDao;
import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.model.Video;


public class AdminServiceImpl implements AdminService {
	AdminDao adminDao;

	public AdminServiceImpl(AdminDao adminDao) {
		super();
		this.adminDao = adminDao;
	}

	public int addCategory(Category category) throws SQLException {
		return adminDao.addCategory(category);
		
	}

	public List<Category> getAllCategory() throws SQLException {
		
		return adminDao.getAllCategory();
	}

	public Category getCategory(String categoryName) throws SQLException {
		
		return adminDao.getCategory(categoryName);
	}

	public int updateCategory(Category category) throws SQLException, IOException {
		return adminDao.updateCategory(category);
		
	}

	public int deleteCategory(String categoryName) throws SQLException {
		return adminDao.deleteCategory(categoryName);
		
	}

	public List<Course> getAllCourse(String categoryname) throws SQLException {
		return adminDao.getAllCourse(categoryname);
		
	}

	public int addCourse(Course course,String categoryname) throws SQLException {
		return adminDao.addCourse(course,categoryname);
		
	}

	public int deleteCourse(int courseid) throws SQLException {
		return adminDao.deleteCourse(courseid);
		
	}

	public Course getCourse(int courseid) throws SQLException {
		
		return adminDao.getCourse(courseid);
	}

	public int updateCourse(Course course) throws SQLException, IOException {
		return adminDao.updateCourse(course);
		
	}

	public List<Video> getAllVideo(int courseid) throws SQLException {
		return adminDao.getAllVideo(courseid).stream().sorted((p1, p2)->p1.getVideoseq()-p2.getVideoseq()).collect(Collectors.toList());        
	}

	public int addVideo(Video video, int courseid) throws SQLException {
		return adminDao.addVideo(video,courseid);
		
	}

	
	public Video getVideo(int videoid) throws SQLException {
		
		return adminDao.getVideo(videoid);
	}


	public int updateVideo(Video video,int videoid) throws SQLException {
		return adminDao.updateVideo(video,videoid);
		
	}

	
	public int deleteVideo(int videoid) throws SQLException {
		return adminDao.deleteVideo(videoid);
		
	}
}
