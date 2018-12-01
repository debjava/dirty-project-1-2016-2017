package com.ddlab.rnd.resources;
import java.util.HashSet;
import java.util.Set;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationPkgs extends ResourceConfig {
	
	public ApplicationPkgs() {
		Set<Class<?>> resources = new HashSet<Class<?>>();
		resources.add(BasicResources.class);
		resources.add(JacksonFeature.class);
		
		//Add below CorsFilter , otherwise Angular JS will not work
		resources.add(CORSFilter.class);
		
		registerClasses(resources);
		
	}
}