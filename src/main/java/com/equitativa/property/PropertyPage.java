package com.equitativa.property;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.equitativa.CommonUtil;
import com.equitativa.HomePage;
import com.equitativa.property.service.PropertyService;

/**
 * @author amit
 *
 */
public class PropertyPage extends HomePage{
	
	private static final String PROPERTY_PAGE_LINK = "propertyPageLink";
	private static final String PROPERTIES = "properties";
	private static final String PROPERTY_FORM = "propertyForm";

	private static final long serialVersionUID = 1L;
	
	@SpringBean
	transient PropertyService propertyService;
	
	/**
	 * @param parameters
	 */
	public PropertyPage(PageParameters parameters) {
		super(parameters);
		add(new PropertyForm(PROPERTY_FORM));
		add(new PropertyListView(PROPERTIES, propertyService));
		
		get(PROPERTY_PAGE_LINK).add(CommonUtil.appendAttributeClassActive());
	}
}
