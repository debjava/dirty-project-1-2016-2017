package com.ddlab.rnd.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorServlet extends HttpServlet {

	private static final long serialVersionUID = 6395073555851718402L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Imagine that there is an error here
		response.sendError(HttpServletResponse.SC_NOT_FOUND, "My Server error message");
//		response.setStatus(sc, sm); // Deprecated
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	}

}
