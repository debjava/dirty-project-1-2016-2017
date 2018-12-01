package com.ddlab.web.resources;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.media.multipart.ContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.ddlab.entity.User;
import com.ddlab.util.Constants;
import com.ddlab.util.FileUtil;

@Path("wadl")
public class CheckWADL {
	
	//@PathParam -----
	
	//@QueryParam ----
	
	//@FormParam ---
	
	//@MatrixParam ---
	
	//@HeaderParam ---
	
	//@FormDataParam ---
	
	@Path("/createuser")
	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response createEmp(User user) {
		return Response.status(Status.CREATED).entity("..").build();
	}
	
	@Path("/updateuser")
	@PUT
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response updateEmp(User user) {
		return Response.ok("...").build();
	}
	
	@Path("/deleteuser")
	@DELETE
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response deleteEmp(User user) {
		return Response.ok("..." ).build();
	}
	
	
//	@POST
//	@Path("/imageWithData")
//	@Consumes(MediaType.MULTIPART_FORM_DATA)
//	public Response uploadFile(FormDataMultiPart form, @FormDataParam("user") String user) {
//		return Response.status(200).build();
//	}
	
//	@GET
//	@Path("/get")
//	public Response addUser(@HeaderParam("user-agent") String userAgent) {
//		String msg = "addUser is called, userAgent : " + userAgent;
//		return Response.status(200).entity(msg).build();
//	}
//	
//	@GET
//	@Path("/getAll")
//	public Response addUser(@Context HttpHeaders headers) {
//		return Response.status(200).build();
//	}
	
//	@Path("/itcaddress")
//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	public Response getITCAddress(@MatrixParam("country") String country, @MatrixParam("areacode") String areaCode) {
//		User user = new User();
//		user.setFirstName("Deb");
//		user.setLastName("Mishra");
//		user.setId(1);
//		return Response.ok().entity(user).build();
//	}
	
//	@Path("/postaladdress")
//	@POST
//	@Produces(MediaType.TEXT_PLAIN)
//	public Response postNGetITCAddress(@FormParam("country") String country,@FormParam("areacode") String areaCode) {
//		
//		User user = new User();
//		user.setFirstName("Deb");
//		user.setLastName("Mishra");
//		user.setId(1);
//		return Response.ok().entity(user).build();
//	}
	
//	@Path("/user/{id}/{dept}")
//	@GET
//	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
//	public Response getUserById(@PathParam("id") int id, @PathParam("dept") String deptName) {
//		User user = new User();
//		user.setFirstName("Deb");
//		user.setLastName("Mishra");
//		user.setId(id);
//		return Response.ok().entity(user).build();
//	}
	
//	@Path("/pagination")
//	@GET
//	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
//	public Response getUser(@QueryParam("start") int start , @QueryParam("end") int end ) {
//		User user = new User();
//		user.setFirstName("Deb");
//		user.setLastName("Mishra");
//		user.setId(start);
//		return Response.ok().entity(user).build();
//	}

}
