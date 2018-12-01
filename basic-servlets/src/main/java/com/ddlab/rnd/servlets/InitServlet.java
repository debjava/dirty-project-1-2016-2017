package com.ddlab.rnd.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitServlet extends HttpServlet {

	private static final long serialVersionUID = 3449078750941207887L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String param1 = config.getInitParameter("param1");
		String param2 = config.getInitParameter("param2");
		System.out.println("Param1------>"+param1);
		System.out.println("Param2------>"+param2);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("***************** service() *********************");
		super.service(request, response);
	}


}
