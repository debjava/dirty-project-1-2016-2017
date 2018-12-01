package com.itc.apti.entity;

/**
 * The Class UrlBean is a place holder for url and media type.
 * 
 * @author Debadatta Mishra
 */
public class UrlBean {

	/** The url. */
	private String url;

	/** The content type. */
	private String contentType;

	/**
	 * Instantiates a new url bean.
	 *
	 * @param url
	 *            the url
	 * @param contentType
	 *            the content type
	 */
	public UrlBean(String url, String contentType) {
		super();
		this.url = url;
		this.contentType = contentType;
	}

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Gets the content type.
	 *
	 * @return the content type
	 */
	public String getContentType() {
		return contentType;
	}

}
