package com.ddlab.rnd.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@XmlRootElement(name = "User")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "firstName" , "lastName"} )
@JsonPropertyOrder(value = {"id", "firstName" , "lastName"})
public class UserEntity {
	
	@XmlElement(name = "firstName")
	@JsonProperty("firstName")
	private String firstName;
	
	@XmlElement(name = "lastName")
	@JsonProperty("lastName")
	private String lastName;
	
	@XmlElement(name = "id")
	@JsonProperty("id")
	private String id;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
