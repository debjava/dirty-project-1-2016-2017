package com.ddlab.rnd;

import java.io.Serializable;
import java.util.concurrent.CopyOnWriteArrayList;

public class ZipCodeNCourses implements Serializable {
	
	private static final long serialVersionUID = 1781828126575051092L;
	
	private String zipCode;
	private CopyOnWriteArrayList<String> coursesList ; 
	
	public ZipCodeNCourses( String zipCode ) {
		coursesList = new CopyOnWriteArrayList<String>();
		this.zipCode = zipCode;
	}

	public String getZipCode() {
		return zipCode;
	}

	public CopyOnWriteArrayList<String> getCoursesList() {
		return coursesList;
	}
	
	
	
	

}
