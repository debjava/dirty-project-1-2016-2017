package com.ddlab.rnd;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.Configuration;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.xml.XmlConfiguration;

public class TempRetrieve {
	
	public static void main(String[] args) {
		
		
		Configuration xmlConfig = new XmlConfiguration(App.class.getResource("/ehcache.xml"));
	    CacheManager cacheManager = CacheManagerBuilder.newCacheManager(xmlConfig);
	    cacheManager.init();
	    
	    Cache<String,ZipCodeNCourses> zipCourseCache = cacheManager.getCache("basicCache", String.class, ZipCodeNCourses.class);
	    
	    
	    String formatted = String.format("%05d", 5);
	    
	    
	    ZipCodeNCourses zc1 = zipCourseCache.get(formatted);
	    System.out.println(zc1.getCoursesList());
		
	}

}
