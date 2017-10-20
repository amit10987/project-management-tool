package com.equitativa.property;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.equitativa.HomePage;
import com.equitativa.property.service.PropertyService;

/**
 * @author amit
 *
 */
public class PropertyPage extends HomePage{
	
	private static final long serialVersionUID = 1L;
	
	@SpringBean
	transient PropertyService propertyService;
	
	public PropertyPage(PageParameters parameters) {
		super(parameters);
		add(new PropertyForm("propertyForm"));
		add(new PropertyListView("properties", propertyService));
		
		get("propertyPageLink").add(new AttributeAppender("class", "active", " "));
	}
}
