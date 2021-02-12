package com.cybage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = { "admin", "user" }))

public class AppController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger log = LogManager.getLogger(UserController.class);
	public AppController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getPathInfo();

		if (request.isUserInRole("admin")) {
			log.info("App started by admin");
			request.getRequestDispatcher("/AdminController/category").forward(request,
					response);
		}
		if (request.isUserInRole("user")) {
			log.info("App started by user");
			request.getRequestDispatcher("/UserController/category").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
