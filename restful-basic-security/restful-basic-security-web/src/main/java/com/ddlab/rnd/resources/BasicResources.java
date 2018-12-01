package com.ddlab.rnd.resources;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ddlab.rnd.entity.UserEntity;
import com.ddlab.rnd.services.BasicService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;

/**
 * This is a basic RESTful webservice. This is the class providing a set of apis for restful webservice.
 *
 * @author Debadatta Mishra
 */
@Path("1/basic")
@SwaggerDefinition(info = @Info(description = "A basic RESTful webservice for learning", version = "v1", 
		title = "Basic service api",
		contact = @Contact(name = "Debadatta Mishra", email = "debadatta.mishra@gmail.com", url = "http://github.com/debjava"), 
		license = @License(name = "Apache 2.0", url = "http://www.apache.org/licenses/LICENSE-2.0")),
		consumes = {"application/json", "application/xml" },
		produces = { "application/json", "application/xml" }, 
		schemes = { SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS }
)
@Api(value = "/basic", tags = { "BasicService: This is the basic service to learn about RESTful webservice using Jersey and Spring." })
public class BasicResources {

	/** The request. */
	@Context
	HttpServletRequest request;

	/** The servlet config. */
	@Context
	ServletConfig servletConfig;

	/** The service. */
	@Autowired
	@Qualifier("basicServiceImpl")
	private BasicService service;
	
	
	/**
	 * Gets the user informations by user id as path parameter.
	 *
	 * @param id the id
	 * @return the user
	 */
	@Path("/userid/{id}")
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Get user details by id as path param", response = UserEntity.class,
		    responseContainer = "List"	)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK",response=UserEntity.class),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public UserEntity getUser(@PathParam("id") int id) {
		
		return service.getUserById(String.valueOf(id));
		
	}
	
	/**
	 * Gets the user by id as query parameter.
	 *
	 * @param id the id
	 * @return the user by id
	 */
	@Path("/userid")
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Get user details by id as query parameter",
					response = UserEntity.class,
					responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = UserEntity.class),
					@ApiResponse(code = 500, message = "Internal Server Error") })
	public UserEntity getUserById(@QueryParam("id") int id) {
		return service.getUserById(String.valueOf(id));
	}
	
	/**
	 * Creates a new user.
	 *
	 * @param user the user
	 * @return the response
	 */
	@Path("/create")
	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_PLAIN })
	@ApiOperation(value = "Create a new user in system by passing user details", 
					response = String.class, 
					responseContainer = "List"	)
	@ApiResponses(value = { @ApiResponse(code = 201,
					message = "Created", 
					response = String.class),
					@ApiResponse(code = 500, message = "Internal Server Error") })
	public Response createUser(
					@ApiParam(value = "Pass the user object either in XML or JSON format to be added in the system", required = true) 
					UserEntity user) {
		
		//Write your business logic
		return Response.status(Status.CREATED).entity("User created successfully").build();
		
	}
	
	/**
	 * Update user information.
	 *
	 * @param user the user
	 * @return the response
	 */
	@Path("/update")
	@PUT
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Update the user details in the system",
					response = String.class, 
					responseContainer = "List"	)
	@ApiResponses(value = { @ApiResponse(code = 200,
					message = "Updated", 
					response = UserEntity.class),
					@ApiResponse(code = 500, message = "Internal Server Error") })
	public Response updateUser(
					@ApiParam(value = "Pass the user object either in XML or JSON format to be added in the system", required = true) 
					UserEntity user) {
		
		//Write your business logic
		return Response.status(Status.OK).entity(user).build();
		
	}
	
	/**
	 * Delete user information from the system.
	 *
	 * @param user the user
	 * @return the response
	 */
	@Path("/delete")
	@DELETE
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_PLAIN })
	@ApiOperation(value = "Delete the user details from the system", 
					response = String.class, 
					responseContainer = "List"	)
	@ApiResponses(value = { @ApiResponse(code = 200,
							message = "Deleted", 
							response = String.class),
							@ApiResponse(code = 500, message = "Internal Server Error") })
	public Response deleteUser(
					@ApiParam(value = "Pass the user object either in XML or JSON format to be added in the system", required = true) 
					UserEntity user) {
		
		//Write your business logic
		return Response.status(Status.OK).entity("User removed from the system").build();
		
	}

}
