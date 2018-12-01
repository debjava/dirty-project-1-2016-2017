package com.itc.apti.entity;

/**
 * The Interface IStatus.
 * 
 * @author Debadatta Mishra
 */
public interface IStatus {

	/**
	 * Gets the host ip.
	 *
	 * @return the host ip
	 */
	String getHostIp();

	/**
	 * Sets the host ip.
	 *
	 * @param hostIp
	 *            the new host ip
	 */
	void setHostIp(String hostIp);

	/**
	 * Gets the host name.
	 *
	 * @return the host name
	 */
	String getHostName();

	/**
	 * Sets the host name.
	 *
	 * @param hostName
	 *            the new host name
	 */
	void setHostName(String hostName);

	/**
	 * Gets the host canonical name.
	 *
	 * @return the host canonical name
	 */
	String getHostCanonicalName();

	/**
	 * Sets the host canonical name.
	 *
	 * @param hostCanonicalName
	 *            the new host canonical name
	 */
	void setHostCanonicalName(String hostCanonicalName);

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	String getStatus();

	/**
	 * Sets the status.
	 *
	 * @param status
	 *            the new status
	 */
	void setStatus(String status);

	/**
	 * Gets the service name.
	 *
	 * @return the service name
	 */
	String getServiceName();

	/**
	 * Sets the service name.
	 *
	 * @param serviceName
	 *            the new service name
	 */
	void setServiceName(String serviceName);

}
