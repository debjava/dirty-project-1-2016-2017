package com.itc.apti.services;

import org.xml.sax.helpers.DefaultHandler;

/**
 * The Class XmlHandler for processing XML processing in a generic manner.
 * 
 * @author Debadatta Mishra
 *
 * @param <T>
 *            the generic type
 */
public abstract class XmlHandler<T> extends DefaultHandler {

	/**
	 * Gets the.
	 *
	 * @return the t
	 */
	public abstract T get();

}
