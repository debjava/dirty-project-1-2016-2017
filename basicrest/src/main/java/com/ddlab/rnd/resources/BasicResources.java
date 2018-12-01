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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ddlab.rnd.entity.UserEntity;
import com.ddlab.rnd.services.BasicService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;
import io.swagger.annotations.Contact;
import io.swagger.annotations.ExternalDocs;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;


/**This is a basic service
 * @author PIKU
 *
 */
@Path("1/basic")
@Api(value="/basic",tags={"BasicService: This is the basic service.\n It is useful now."})
@SwaggerDefinition(
        info = @Info(
                description = "A basic service for testing",
                version = "v1",
                title = "Basic service api",
                termsOfService = "http://github.com/debjava",
                contact = @Contact(
                   name = "Debadatta Mishra", 
                   email = "deba.java@gmail.com", 
                   url = "http://github.com/debjava"
                ),
                license = @License(
                   name = "Apache 2.0", 
                   url = "http://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        consumes = {"application/json", "application/xml"},
        produces = {"application/json", "application/xml"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS},
        tags = {
                @Tag(name = "Private", description = "Tag used to denote operations as private")
        }, 
        externalDocs = @ExternalDocs(value = "No external doc", url = "http://nodoc.html")
)
public class BasicResources {
	
	@Context
	HttpServletRequest request;

	@Context
	ServletConfig servletConfig;
	
	@Autowired @Qualifier("basicServiceImpl")
	private BasicService service;
	
	@Path("/userid/{id}")
	@GET
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "get user details by id as path param", notes = "get the user details from id as path param", code = 200, 
	authorizations = @Authorization(value = "api_key"))
	@ApiResponses(value={
            @ApiResponse(code=200, message="OK",response = UserEntity.class),
            @ApiResponse(code=500, message="Internal Error")
    })
	public UserEntity getUser(@PathParam("id") int id) {
//		if(id == 0 )
//			throw createWebappException(new IllegalArgumentException("Incorrect ID"));
		
		return service.getUserById(String.valueOf(id));
	}
	
	@Path("/userid")
	@GET
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	
//	@ApiOperation(value="get user details by id as query parameter", notes="get the user details from id as query param",code=200)
	
	@ApiOperation(value = "get user details by id as query parameter", 
    authorizations = {
      @Authorization(
          value="basicAuth", 
          scopes = { @AuthorizationScope(scope = "add:pet", description = "some desritpion") }
          )
    }
  )
	
	@ApiResponses(value={
            @ApiResponse(code=200, message="OK",response = UserEntity.class),
            @ApiResponse(code=500, message="Internal Error")
    })
	public UserEntity getUserById(@QueryParam("id") int id) {
		
		return service.getUserById(String.valueOf(id));
	}

}
