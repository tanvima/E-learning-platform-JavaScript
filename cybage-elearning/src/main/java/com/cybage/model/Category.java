package com.cybage.model;

import java.io.File;
import java.io.InputStream;

import javax.sql.rowset.serial.SerialBlob;

public class Category {

	private String categoryname;
	private String categorydescription;
	private InputStream categorylogo;
	private String encode;
	private int categoryid;
	private SerialBlob image;
	
	
	//with logo
		public Category(String categoryname, String categorydescription, InputStream logo) {
			super();
			this.categoryname = categoryname;
			this.categorydescription = categorydescription;
			this.categorylogo = logo;
		}
		
		//without logo
		public Category() {
			super();
			
		}
		public SerialBlob getImage() {
			return image;
		}


		public void setImage(SerialBlob image) {
			this.image = image;
		}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String getEncode() {
		return encode;
	}

	public void setEncode(String encode) {
		this.encode = encode;
	}

	
	
	
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public String getCategorydescription() {
		return categorydescription;
	}
	public void setCategorydescription(String categorydescription) {
		this.categorydescription = categorydescription;
	}
	public InputStream getLogo() {
		return categorylogo;
	}
	public void setLogo(InputStream logo) {
		this.categorylogo = logo;
	}
	
	
}
