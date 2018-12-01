package com.ddlab.rnd.resources;
import java.util.HashSet;
import java.util.Set;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationPkgs extends ResourceConfig {
	
	public ApplicationPkgs() {
//		super(BasicResources.class, JacksonFeature.class, 
//				io.swagger.jaxrs.listing.ApiListingResource.class,
//				io.swagger.jaxrs.listing.SwaggerSerializers.class);
		
		
		Set<Class<?>> resources = new HashSet<Class<?>>();
		resources.add(BasicResources.class);
		resources.add(JacksonFeature.class);
		resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
		
//		super(resources);
		
		registerClasses(resources);
		
		/*//For swagger
				resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
		        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);*/
		
	}
}