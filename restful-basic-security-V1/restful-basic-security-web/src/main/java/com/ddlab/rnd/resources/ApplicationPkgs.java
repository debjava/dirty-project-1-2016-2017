package com.ddlab.rnd.resources;
import java.util.HashSet;
import java.util.Set;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * The Class ApplicationPkgs for Jersey Restful service creation.
 * @author Debadatta Mishra
 */
public class ApplicationPkgs extends ResourceConfig {
	
	/**
	 * Instantiates a new application pkgs.
	 */
	public ApplicationPkgs() {
		Set<Class<?>> resources = new HashSet<Class<?>>();
		resources.add(BasicResources.class);
		resources.add(JacksonFeature.class);
		resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        
		registerClasses(resources);
	}
}