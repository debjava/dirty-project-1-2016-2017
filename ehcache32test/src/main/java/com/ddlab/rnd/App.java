package com.ddlab.rnd;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.Configuration;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.xml.XmlConfiguration;

public class App {
	public static void main(String[] args) {
	    System.out.println("Creating cache manager via XML resource");
	    
	    Configuration xmlConfig = new XmlConfiguration(App.class.getResource("/ehcache.xml"));
	    CacheManager cacheManager = CacheManagerBuilder.newCacheManager(xmlConfig);
	    cacheManager.init();
	    
	    Cache<String,ZipCodeNCourses> zipCourseCache = cacheManager.getCache("basicCache", String.class, ZipCodeNCourses.class);
	    
	    for( int i = 0 ; i < 5000 ; i++ ) {
	    	
	    	String formatted = String.format("%05d", i);
	    	ZipCodeNCourses zp = new ZipCodeNCourses(formatted);
	    	zp.getCoursesList().add("C-"+i);
	    	
	    	zipCourseCache.put(formatted, zp);
	    	
	    }
	    
	    
	    
//	    ZipCodeNCourses zc = new ZipCodeNCourses("0001");
//	    zc.getCoursesList().add("C1");
//	    
//	    System.out.println("Putting to cache");
//	    zipCourseCache.put("0001", zc);
//	    
//	    ZipCodeNCourses zc1 = cacheManager.getCache("basicCache", String.class, ZipCodeNCourses.class).get("0001");
//	    System.out.println(zc1.getCoursesList());
	    
	    System.out.println("Exiting");
	    
	    
	  }
}
