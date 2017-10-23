package com.equitativa;

import org.apache.wicket.behavior.AttributeAppender;

/**
 * To represent common behaviour
 * 
 * @author amit
 *
 */
public final class CommonUtil {
	
	/**
	 * private constructor to restrict instantiation of class
	 */
	private CommonUtil(){
		
	}
	
	/**
	 * 
	 * this is for active navigation link
	 * 
	 * @return
	 */
	public static AttributeAppender appendAttributeClassActive() {
		return new AttributeAppender("class", "active", " ");
	}
}
