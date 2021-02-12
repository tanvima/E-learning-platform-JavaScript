package com.cybage.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.model.Video;

public interface AdminDao {

	int addCategory(Category category) throws SQLException;

	List<Category> getAllCategory() throws SQLException;

	Category getCategory(String categoryName)throws SQLException;

	int updateCategory(Category category) throws  SQLException, IOException;

	int deleteCategory(String categoryName) throws SQLException;

	List<Course> getAllCourse(String categoryname) throws SQLException;

	int addCourse(Course course,String categoryname) throws SQLException;

	int deleteCourse(int courseid)throws SQLException;

	Course getCourse(int courseid) throws SQLException;

	int updateCourse(Course course) throws SQLException, IOException;

	List<Video> getAllVideo(int courseid) throws SQLException;

	int addVideo(Video video,int courseid) throws SQLException;

	Video getVideo(int videoid) throws SQLException;

	int updateVideo(Video video,int videoid) throws SQLException;

	int deleteVideo(int videoid) throws SQLException;

}
