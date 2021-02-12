package com.cybage.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.model.Video;
import com.cybage.util.DbUtil;

public class AdminDaoImpl implements AdminDao {

	public int addCategory(Category category) throws SQLException {

		Connection con = DbUtil.getCon();
		String sql = "insert into category (categoryname,categorylogo, categorydesc) values (?,?,?)";

		InputStream input = category.getLogo();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, category.getCategoryname());
		ps.setBlob(2, input);
		ps.setString(3, category.getCategorydescription());

		return ps.executeUpdate();

	}

	public List<Category> getAllCategory() throws SQLException {
		
		Connection con = DbUtil.getCon();
		String sql = "select * from category";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Category> category = new ArrayList<Category>();
		while (rs.next()) {
			Category c = new Category(rs.getString(1),rs.getString(3),rs.getBinaryStream(2));
			category.add(c);
		}
		
		
		return category;
	}

	public Category getCategory(String categoryName) throws SQLException {
		
		Connection con = DbUtil.getCon();
		String sql = "select * from category where categoryname = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, categoryName);
		ResultSet rs = ps.executeQuery();
		
		Category c = new Category();
		while (rs.next()) {
					 c.setCategoryname(rs.getString(1));
					 c.setLogo(rs.getBinaryStream(2));
					 c.setCategorydescription(rs.getString(3));
					 c.setCategoryid(rs.getInt(4));
		}
		
		return c;
		
	}


	public int updateCategory(Category category) throws SQLException, IOException {

		InputStream i = category.getLogo();
		if (category.getImage().getBinaryStream().read() == -1) {
			Connection con = DbUtil.getCon();
			String sql = "update category set categoryname = ?,categorydesc=? where categoryid=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, category.getCategoryname());
			ps.setString(2, category.getCategorydescription());
			ps.setInt(3, category.getCategoryid());
			return ps.executeUpdate();

		}

		else {

			Connection con = DbUtil.getCon();
			String sql = "update category set categoryname = ?,categorydesc=?,categorylogo=? where categoryid=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, category.getCategoryname());
			ps.setString(2, category.getCategorydescription());
			ps.setBlob(3, category.getImage());
			ps.setInt(4, category.getCategoryid());

			return ps.executeUpdate();
		}

	}

	public int deleteCategory(String categoryName) throws SQLException {
		
		Connection con = DbUtil.getCon();
		String sql = "delete from category where categoryname = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, categoryName);
		return ps.executeUpdate();
		
	}

	public List<Course> getAllCourse(String categoryname) throws SQLException {
		
		
		Connection con = DbUtil.getCon();
		String sql = "select * from course where categoryname=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, categoryname);
		ResultSet rs = ps.executeQuery();
		List<Course> course = new ArrayList<Course>();
		while (rs.next()) {
			
			Course c = new Course(rs.getInt(1),rs.getString(2), rs.getBinaryStream(3), rs.getString(4),rs.getInt(5));
			course.add(c);
		}
		
		
		return course;
		
	}

	public int addCourse(Course course, String categoryname) throws SQLException {
		Connection con = DbUtil.getCon();
		String sql = "insert into course (coursename,courselogo, coursedesc,categoryname,courseprice) values (?,?,?,?,?) ";

		InputStream input = course.getCourselogo();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, course.getCoursename());
		ps.setBlob(2, input);
		ps.setString(3, course.getCoursedescription());
		ps.setString(4, categoryname);
		ps.setInt(5, course.getPrice());

		return ps.executeUpdate();
		
	}

	public int deleteCourse(int courseid) throws SQLException {
		Connection con = DbUtil.getCon();
		String sql = "delete from course where courseid = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,courseid);
		return ps.executeUpdate();
		
	}

	public Course getCourse(int courseid) throws SQLException {
		Connection con = DbUtil.getCon();
		String sql = "select * from course where courseid = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, courseid);
		ResultSet rs = ps.executeQuery();
		
		Course c = new Course();
		while (rs.next()) {
					 c.setCourseid(rs.getInt(1));
					 c.setCoursename(rs.getString(2));
					 c.setCourselogo(rs.getBinaryStream(3));
					 c.setCoursedescription(rs.getString(4));
					 c.setPrice(rs.getInt(5));
		}
		return c;
	}

	public int updateCourse(Course course) throws SQLException, IOException {
		Connection con = DbUtil.getCon();
		if(course.getImage().getBinaryStream().read() == -1) {
			String sql = "update course set coursename = ?,coursedesc=?,courseprice=? where courseid=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, course.getCoursename());
			ps.setString(2, course.getCoursedescription());
			ps.setInt(3, course.getPrice());
			ps.setInt(4, course.getCourseid());
			return ps.executeUpdate();
		}else {
			String sql = "update course set coursename = ?,coursedesc=?,courselogo=?,courseprice=? where courseid=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, course.getCoursename());
			ps.setString(2, course.getCoursedescription());
			ps.setBlob(3, course.getImage());
			ps.setInt(4, course.getPrice());
			ps.setInt(5, course.getCourseid());
			return ps.executeUpdate();
		}
		
	}

	public List<Video> getAllVideo(int courseid) throws SQLException {
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
			
		}
		return videoList;
	}

	public int addVideo(Video video,int courseid) throws SQLException {
		Connection con = DbUtil.getCon();
		String sql = "insert into video (videoname, videopath, videoseq,courseid)values(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, video.getVideoname());
		ps.setString(2, video.getVideopath());
		ps.setInt(3, video.getVideoseq());
		ps.setInt(4,courseid);
		return ps.executeUpdate();
	}


	public Video getVideo(int videoid) throws SQLException {
		
		Connection con = DbUtil.getCon();
		String sql = "select * from video where videoid = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,videoid );
		ResultSet rs = ps.executeQuery();
		
		Video v = new Video();
		while (rs.next()) {
				v.setVideoname(rs.getString(2));	
				v.setVideopath(rs.getString(3));
				v.setVideoseq(rs.getInt(4));
				v.setVideoid(rs.getInt(1));
				
		}
		return v;
	}

	
	public int updateVideo(Video video,int videoid) throws SQLException {
		Connection con = DbUtil.getCon();
		if(video.getVideopath().equals("")) {
			String sql = "update video set videoname = ?,videoseq=? where videoid=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, video.getVideoname());
			ps.setInt(2, video.getVideoseq());
			ps.setInt(3, videoid);
			return ps.executeUpdate();
		}else {
			String sql = "update video set videoname = ?,videopath=?,videoseq=? where videoid=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, video.getVideoname());
			ps.setString(2, video.getVideopath());
			ps.setInt(3, video.getVideoseq());
			ps.setInt(4, videoid);
			return ps.executeUpdate();
		}
	}


	public int deleteVideo(int videoid) throws SQLException {
		Connection con = DbUtil.getCon();
		String sql = "delete from video where videoid = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, videoid);
		return ps.executeUpdate();
		
	}

}
