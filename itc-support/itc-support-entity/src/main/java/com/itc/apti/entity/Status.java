package com.itc.apti.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * The Class Status object to display the relevant data to the client.
 */
@JsonPropertyOrder({ "hostIp", "hostName", "hostCanonicalName", "status", "serviceName" })
public class Status implements IStatus {

	/** The host ip. */
	@JsonProperty
	private String hostIp;

	/** The host name. */
	@JsonProperty
	private String hostName;

	/** The host canonical name. */
	@JsonProperty
	private String hostCanonicalName;

	/** The status. */
	@JsonProperty
	private String status = EStatus.FAIL.name();

	/** The service name. */
	@JsonProperty
	private String serviceName;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.itc.apti.entity.IStatus#getServiceName()
	 */
	public String getServiceName() {
		return serviceName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.itc.apti.entity.IStatus#setServiceName(java.lang.String)
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.itc.apti.entity.IStatus#getHostIp()
	 */
	public String getHostIp() {
		return hostIp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.itc.apti.entity.IStatus#setHostIp(java.lang.String)
	 */
	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.itc.apti.entity.IStatus#getHostName()
	 */
	public String getHostName() {
		return hostName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.itc.apti.entity.IStatus#setHostName(java.lang.String)
	 */
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.itc.apti.entity.IStatus#getHostCanonicalName()
	 */
	public String getHostCanonicalName() {
		return hostCanonicalName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.itc.apti.entity.IStatus#setHostCanonicalName(java.lang.String)
	 */
	public void setHostCanonicalName(String hostCanonicalName) {
		this.hostCanonicalName = hostCanonicalName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.itc.apti.entity.IStatus#getStatus()
	 */
	public String getStatus() {
		return status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.itc.apti.entity.IStatus#setStatus(java.lang.String)
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Status{" + "hostIp='" + hostIp + '\'' + ", hostName='" + hostName + '\'' + ", hostCanonicalName='"
				+ hostCanonicalName + '\'' + '}';
	}
}
