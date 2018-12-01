package com.ddlab.rnd.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App 
{
	protected static Logger logger = LoggerFactory.getLogger(App.class);
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        logger.debug("New Test...");
        
        for( int i = 0 ; i < 20000 ; i++) 
        	logger.debug(i+" A brown fox jumps over the lazy dog.....Lomem ipsum doler sit amet...");
        
        logger.error("Some issues.");
        throw new NullPointerException("New error ....");
        
    }
}
