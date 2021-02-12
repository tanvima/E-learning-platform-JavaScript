package com.cybage.dao;

import java.util.List;

import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.model.User;
import com.cybage.model.Video;
public interface UserDao 
{
	
	
	List<Category> getAllCategory() throws Exception;

	Category getCategory(String categoryName)throws Exception;
	
	List<Course> getAllCourse(String categoryname) throws Exception;
	
	Course getCourse(int courseid) throws Exception;
	
	public int addUser(User user) throws Exception;
    public int udpateUser(User user) throws Exception;

	int enrollCourse(String username, int courseid) throws Exception;

	List<Video> getAllVideo(int courseid) throws Exception;

	List<Course> getEnrolledCourse(String username) throws Exception;

	int getHistory(String remoteUser, int courseid) throws Exception;

	void updateHistory(String remoteUser, int courseid, int videohist) throws Exception;

	int getTotalCount(int courseid) throws Exception;

	void updateStatus(String remoteUser, int courseid) throws Exception;

	List<String> getAllStatus(String username) throws Exception;




}