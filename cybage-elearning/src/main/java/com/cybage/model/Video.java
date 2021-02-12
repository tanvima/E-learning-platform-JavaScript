package com.cybage.model;

public class Video {

	private int videoid;
	private String videoname;
	private String videopath;
	private int videoseq;
	
	
	
	
	
	public Video() {
		super();
	}
	public Video(int videoid, String videoname, String videopath, int videoseq) {
		super();
		this.videoid = videoid;
		this.videoname = videoname;
		this.videopath = videopath;
		this.videoseq = videoseq;
	}
	public Video( String videoname, String videopath, int videoseq) {
		super();
		this.videoname = videoname;
		this.videopath = videopath;
		this.videoseq = videoseq;
	}
	public int getVideoid() {
		return videoid;
	}
	public void setVideoid(int videoid) {
		this.videoid = videoid;
	}
	public String getVideoname() {
		return videoname;
	}
	public void setVideoname(String videoname) {
		this.videoname = videoname;
	}
	public String getVideopath() {
		return videopath;
	}
	public void setVideopath(String videopath) {
		this.videopath = videopath;
	}
	public int getVideoseq() {
		return videoseq;
	}
	public void setVideoseq(int videoseq) {
		this.videoseq = videoseq;
	}



	
	

}
