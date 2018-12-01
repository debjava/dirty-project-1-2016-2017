package com.ddlab.rnd.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendRedirectServlet extends HttpServlet {

	private static final long serialVersionUID = 730381915856641577L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.sendRedirect("http://localhost:8090/basic-servlets/redirectedServlet");
	}

}
