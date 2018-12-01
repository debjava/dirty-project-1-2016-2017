package com.itc.apti.services;

/**
 * The Interface IDownloader for any downloading functionality.
 * 
 * @author Debadatta Mishra
 *
 * @param <T>
 *            the generic type
 * @param <V>
 *            the value type
 */
public interface IDownloader<T, V> {

	/**
	 * Download a generic object.
	 *
	 * @param the
	 *            v
	 * @return the t
	 */
	T download(V v);
}
