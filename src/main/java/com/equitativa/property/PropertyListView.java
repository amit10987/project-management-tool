package com.equitativa.property;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.PropertyModel;

import com.equitativa.model.Property;
import com.equitativa.property.service.PropertyService;

/**
 * @author amit
 *
 */
public class PropertyListView extends ListView<Property>{

	private static final String PROPERTY_DELETED_SUCCESSFULLY = "Property deleted successfully.";
	private static final String DELETE_PROPERTY_LINK = "deletePropertyLink";
	private static final String COMPANY_NAME = "companyName";
	private static final String COMPANY_ID = "companyId";
	private static final String PROPERTY_NAME = "propertyName";
	private static final String NAME = "name";
	private static final String ID = "id";
	private static final String PROPERTY_ID = "propertyId";
	private static final long serialVersionUID = 1L;
	
	transient PropertyService propertyService;

	public PropertyListView(String id, PropertyService propertyService) {
		super(id, propertyService.getAllProperties());
		this.propertyService = propertyService;
	}
	
	@Override
	protected void populateItem(ListItem<Property> item) {
		item.add(new Label(PROPERTY_ID, new PropertyModel<String>(item.getModel(), ID)));
		item.add(new Label(PROPERTY_NAME, new PropertyModel<String>(item.getModel(), NAME)));
		item.add(new Label(COMPANY_ID, new PropertyModel<String>(item.getModelObject().getOrganization(), ID)));
		item.add(new Label(COMPANY_NAME, new PropertyModel<String>(item.getModelObject().getOrganization(), NAME)));
		item.add(deletePropertyLink(item));
	}
	
	/**
	 * @param item
	 * @return
	 */
	private Link<String> deletePropertyLink(final ListItem<Property> item) {
		return new Link<String>(DELETE_PROPERTY_LINK){
			private static final long serialVersionUID = 1L;
			@Override
			public void onClick() {
				propertyService.deleteProperty(item.getModelObject());
				getSession().info(PROPERTY_DELETED_SUCCESSFULLY);
				setResponsePage(PropertyPage.class);
			}
		};
	}
}
