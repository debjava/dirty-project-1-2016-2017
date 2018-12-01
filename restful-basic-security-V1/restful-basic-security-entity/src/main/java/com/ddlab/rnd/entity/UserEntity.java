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

/**
 * The Class UserEntity.
 */
@XmlRootElement(name = "User")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "id", "firstName", "lastName" })
@JsonPropertyOrder(value = { "id", "firstName", "lastName" })
@ApiModel(value = "UseEntity", description = "User details")
public class UserEntity {

	/** The first name. */
	@XmlElement(name = "firstName")
	@JsonProperty("firstName")
	@ApiModelProperty(name = "firstName", value = "firstName", dataType = "java.lang.String")
	private String firstName;

	/** The last name. */
	@XmlElement(name = "lastName")
	@JsonProperty("lastName")
	@ApiModelProperty(name = "lastName", value = "lastName", dataType = "java.lang.String")
	private String lastName;

	/** The id. */
	@XmlElement(name = "id")
	@JsonProperty("id")
	@ApiModelProperty(name = "id", value = "id", dataType = "java.lang.String")
	private String id;

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

}
