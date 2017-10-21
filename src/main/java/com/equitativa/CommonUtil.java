package com.equitativa;

import org.apache.wicket.behavior.AttributeAppender;

/**
 * @author amit
 *
 */
public final class CommonUtil {
	
	/**
	 * 
	 */
	private CommonUtil(){
		
	}
	
	/**
	 * @return
	 */
	public static AttributeAppender appendAttributeClassActive() {
		return new AttributeAppender("class", "active", " ");
	}
}
