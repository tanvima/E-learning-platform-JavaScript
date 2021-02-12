package com.cybage.model;

import java.io.InputStream;

import javax.sql.rowset.serial.SerialBlob;

public class Course {

	
	private int courseid;
	private String coursename;
	private InputStream courselogo;
	private String coursedescription;
	private int price;
	private String encode;
	private SerialBlob image;

	public SerialBlob getImage() {
		return image;
	}


	public void setImage(SerialBlob image) {
		this.image = image;
	}
	public String getEncode() {
		return encode;
	}

	public void setEncode(String encode) {
		this.encode = encode;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	

	

	public int getCourseid() {
		return courseid;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setCourselogo(InputStream courselogo) {
		this.courselogo = courselogo;
	}

	public Course(int courseid, String coursename, InputStream courselogo, String coursedescription, int price) {
		super();
		this.courseid = courseid;
		this.coursename = coursename;
		this.courselogo = courselogo;
		this.coursedescription = coursedescription;
		this.price = price;
	}

	public Course() {
		super();
	}

	public Course(String coursename, InputStream courselogo, String coursedescription, int price) {
		super();
		this.coursename = coursename;
		this.courselogo = courselogo;
		this.coursedescription = coursedescription;
		this.price = price;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	

	public InputStream getCourselogo() {
		return courselogo;
	}

	public String getCoursedescription() {
		return coursedescription;
	}

	public void setCoursedescription(String coursedescription) {
		this.coursedescription = coursedescription;
	}
	
	
}
