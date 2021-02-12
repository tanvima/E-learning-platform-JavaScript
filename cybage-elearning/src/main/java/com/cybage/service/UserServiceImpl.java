package com.cybage.service;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.cybage.controller.UserController;
import com.cybage.dao.UserDao;
import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.model.User;
import com.cybage.model.Video;

public class UserServiceImpl implements UserService {
	
	 public static final Logger log = LogManager.getLogger(UserServiceImpl.class);

	 UserDao userDao;
	 
	
	 
	public UserServiceImpl(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	
    
    public int udpateUser(User user) throws Exception {        
           return userDao.udpateUser(user);
    }

    public int addUser(User user) throws Exception {
                  log.debug("inside add user ...");
                  return userDao.addUser(user);
           }


	

	public List<Category> getAllCategory() throws Exception {
		
		return userDao.getAllCategory();
	}

	public Category getCategory(String categoryName) throws Exception {
		
		return userDao.getCategory(categoryName);

	}
	public List<Course> getAllCourse(String categoryname) throws Exception {
		return userDao.getAllCourse(categoryname);
		
	}
	
public int enrollCourse(String username, int courseid) throws Exception {
		
		return userDao.enrollCourse(username,courseid);
	}


	public List<Video> getAllVideo(int courseid) throws Exception {
		
		return userDao.getAllVideo(courseid);
	}


	public List<Course> getEnrolledCourse(String username) throws Exception {
		
		return userDao.getEnrolledCourse(username);
	}


	public int getHistory(String remoteUser, int courseid) throws Exception{
		
		return userDao.getHistory(remoteUser,courseid);
	}


	public void updateHistory(String remoteUser, int courseid, int videohist) throws Exception {
		userDao.updateHistory(remoteUser,courseid,videohist);
		
	}


	public int getTotalCount(int courseid) throws Exception {
		
		return userDao.getTotalCount(courseid);
	}


	public void updateStatus(String remoteUser, int courseid) throws Exception{
		userDao.updateStatus(remoteUser,courseid);
		
	}


	public List<String> getAllStatus(String username) throws Exception{
		
		return userDao.getAllStatus(username);
	}

}
