package com.cybage.exception;

import javax.servlet.ServletException;

@SuppressWarnings("serial")
public class AdminException extends ServletException{

	public AdminException(String msg) {
		super(msg);
	}
}
