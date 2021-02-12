package com.cybage.dao;

import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.model.User;
import com.cybage.model.Video;
import com.cybage.util.DbUtil;

public class UserDaoImpl implements UserDao {
	
	public int addUser(User user) throws Exception{
        String sql = "insert into user(username,fullname,userpassword,useremail,role) values(?, ? , ? , ?, ?)";
        Connection con = DbUtil.getCon();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getFullname());
        ps.setString(3, user.getUserpassword());
        ps.setString(4, user.getUseremail());
        ps.setString(5, user.getRole());
        int addCount = ps.executeUpdate();

        return addCount;
 }
 
 
 public int udpateUser(User user) throws Exception {
        String sql = "update user set userpassword = ? where useremail = ? ";

        Connection con = DbUtil.getCon();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, user.getUserpassword());
        ps.setString(2, user.getUseremail());
        return ps.executeUpdate();
 }



	public List<Category> getAllCategory() throws Exception {

		Connection con = DbUtil.getCon();
		String sql = "select * from category";

		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Category> category = new ArrayList<Category>();
		while (rs.next()) {
			Category c = new Category(rs.getString(1), rs.getString(3), rs.getBinaryStream(2));
			category.add(c);
		}

		return category;
	}
	public List<Course> getAllCourse(String categoryname) throws Exception {

		Connection con = DbUtil.getCon();
		String sql = "select * from course where categoryname=?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, categoryname);
		ResultSet rs = ps.executeQuery();
		List<Course> course = new ArrayList<Course>();
		while (rs.next()) {

			Course c = new Course(rs.getInt(1), rs.getString(2), rs.getBinaryStream(3), rs.getString(4), rs.getInt(5));
			System.out.println("in dao " + c.getCoursedescription());
			course.add(c);
		}

		return course;

	}

	public Category getCategory(String categoryName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public Course getCourse(int courseid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public int enrollCourse(String username, int courseid) throws Exception {
		 Connection con1 = DbUtil.getCon();
		String sql1 = "select * from enrollment where courseid =? and username=?";
		PreparedStatement ps1 = con1.prepareStatement(sql1);
		ps1.setInt(1, courseid);
		ps1.setString(2, username);
		ResultSet re = ps1.executeQuery();
		int x = 0;
				
			while(re.next()) {
				x++;
			}
			System.out.println("value of x"+ x);	
			if(x==0) {
				 String sql = "insert into enrollment (username,courseid,status,videohist) values(?, ? , ? , ?)";
			        Connection con = DbUtil.getCon();
			        PreparedStatement ps = con.prepareStatement(sql);
			        ps.setString(1, username);
			        ps.setInt(2,courseid);
			        ps.setString(3, "incomplete");
			        ps.setInt(4, 0);
			        
			        int addCount = ps.executeUpdate();

			        return addCount;
			}
			else return x;
		
	}
	
	public List<Video> getAllVideo(int courseid) throws Exception {
		Connection con = DbUtil.getCon();
		String sql = "select * from video where courseid=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, courseid);
		ResultSet rs = ps.executeQuery();
		List<Video> videoList = new ArrayList<Video>();
		while(rs.next()) {
			Video video = new Video();
			video.setVideoname(rs.getString(2));
			video.setVideopath(rs.getString(3));
			video.setVideoseq(rs.getInt(4));
			video.setVideoid(rs.getInt(1));
			videoList.add(video);
			System.out.println(video.getVideoname());
		}
		return videoList;
	}


	public List<Course> getEnrolledCourse(String username) throws Exception {
		
		Connection con = DbUtil.getCon();
		String sql = "select c.courseid,c.coursename,c.courselogo,c.coursedesc,c.courseprice from course as c, enrollment as e where e.courseid=c.courseid and e.username=?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		List<Course> course = new ArrayList<Course>();
		while (rs.next()) {

			Course c = new Course(rs.getInt(1), rs.getString(2), rs.getBinaryStream(3), rs.getString(4), rs.getInt(5));
			System.out.println("in dao " + c.getCoursedescription());
			course.add(c);
		}

		return course;
	}


	@Override
	public int getHistory(String remoteUser, int courseid) throws Exception {
		Connection con = DbUtil.getCon();
		String sql = "select videohist from enrollment where courseid=? and username=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, courseid);
		ps.setString(2, remoteUser);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return rs.getInt(1);
	}


	@Override
	public void updateHistory(String remoteUser, int courseid, int videohist) throws Exception {
		Connection con = DbUtil.getCon();
		String sql = "update enrollment set videohist = ? where courseid=? and username=? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, videohist);
		ps.setInt(2, courseid);
		ps.setString(3, remoteUser);
		ps.executeUpdate();
		
	}


	@Override
	public int getTotalCount(int courseid) throws Exception {
		Connection con = DbUtil.getCon();
		String sql = "select count(*) from video where courseid=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, courseid);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return rs.getInt(1);
	}


	@Override
	public void updateStatus(String remoteUser, int courseid) throws Exception {
		Connection con = DbUtil.getCon();
		String sql = "update enrollment set status = ? where courseid=? and username=? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "complete");
		ps.setInt(2, courseid);
		ps.setString(3, remoteUser);
		ps.executeUpdate();
		
	}


	
	public List<String> getAllStatus(String username) throws Exception {
		
		Connection con = DbUtil.getCon();
		String sql = "select status from enrollment where username = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		List<String> status = new ArrayList<String>();
		while (rs.next()) {

			status.add(rs.getString(1));
			
		}

		return status;
		
	}
	


	
}
