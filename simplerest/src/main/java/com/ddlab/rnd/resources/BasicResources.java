package com.ddlab.rnd.resources;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ddlab.rnd.entity.UserEntity;
import com.ddlab.rnd.services.BasicService;

/**This is a basic service
 * @author PIKU
 *
 */
@Path("1/basic")

public class BasicResources {
	
	@Context
	HttpServletRequest request;
	
	@Context
	HttpServletResponse response;

	@Context
	ServletConfig servletConfig;
	
	@Autowired @Qualifier("basicServiceImpl")
	private BasicService service;
	

	@Path("/check")
	@GET
	public void check() {
		System.out.println("Check method is called ..........");
		try {
			response.sendRedirect("http://www.google.com");
			
			URI targetURIForRedirection = new URI("http://www.google.com");
			Response.seeOther(targetURIForRedirection).build();
			
//			return Response.temporaryRedirect(targetURIForRedirection).build();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	
	@Path("/userid/{id}")
	@GET
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response getUser(@PathParam("id") int id) {
		System.out.println("Request is coming here ......");
		
		UserEntity user = service.getUserById(String.valueOf(id));
		return Response.ok(user)
		.build();
	}
	
	@Path("/userid")
	@GET
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public UserEntity getUserById(@QueryParam("id") int id) {
		
		return service.getUserById(String.valueOf(id));
	}

}
