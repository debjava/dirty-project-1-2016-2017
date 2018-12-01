package com.ddlab.rnd.resources;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
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
	ServletConfig servletConfig;
	
	@Autowired @Qualifier("basicServiceImpl")
	private BasicService service;
	
//	@Path("/userid/{id}")
//	@GET
//	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
//	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
//	public UserEntity getUser(@PathParam("id") int id) {
//		return service.getUserById(String.valueOf(id));
//	}
	
	
	@Path("/userid/{id}")
	@GET
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response getUser(@PathParam("id") int id) {
		System.out.println("Request is coming here ......");
		String acrHeaders = request.getHeader("Access-Control-Request-Headers");
		String acrMethod = request.getHeader("Access-Control-Request-Method");
		
		
		UserEntity user = service.getUserById(String.valueOf(id));
		return Response.ok(user)
//		.header("Access-Control-Allow-Method", acrMethod)
//		.header("Access-Control-Allow-Headers", acrHeaders)
//		.header("Access-Control-Allow-Origin", "*")
//		.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
//		.allow("OPTIONS")
		.build();
//		return service.getUserById(String.valueOf(id));
	}
	
	
	
	@Path("/userid")
	@GET
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public UserEntity getUserById(@QueryParam("id") int id) {
		
		return service.getUserById(String.valueOf(id));
	}

}
