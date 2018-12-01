package com.ddlab.rnd.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "User")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "firstName" , "lastName"} )
@JsonPropertyOrder(value = {"id", "firstName" , "lastName"})
@ApiModel(value = "UseEntity", description = "User details")
public class UserEntity {
	
	@XmlElement(name = "firstName")
	@JsonProperty("firstName")
	@ApiModelProperty(name="firstName", value = "firstName", dataType = "java.lang.String")
	private String firstName;
	
	@XmlElement(name = "lastName")
	@JsonProperty("lastName")
	@ApiModelProperty(name="lastName", value = "lastName", dataType = "java.lang.String")
	private String lastName;
	
	@XmlElement(name = "id")
	@JsonProperty("id")
	@ApiModelProperty(name="id", value = "id", dataType = "java.lang.String")
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
