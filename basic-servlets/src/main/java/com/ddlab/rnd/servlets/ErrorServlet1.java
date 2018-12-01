package com.ddlab.rnd.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorServlet1 extends HttpServlet {

	private static final long serialVersionUID = 6395073555851718402L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		throw new ServletException("My custom servlet exception");
	}

}
