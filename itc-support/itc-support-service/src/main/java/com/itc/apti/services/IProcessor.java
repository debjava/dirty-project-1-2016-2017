package com.itc.apti.services;

/**
 * The Interface IProcessor for processing in a generic way.
 * 
 * @author Debadatta Mishra
 *
 * @param <I>
 *            the generic type
 * @param <O>
 *            the generic type
 */
public interface IProcessor<I, O> {

	/**
	 * Gets the object after processing.
	 *
	 * @param i
	 *            the i
	 * @return the o
	 */
	O get(I i);

}
