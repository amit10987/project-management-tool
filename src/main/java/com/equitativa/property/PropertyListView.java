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

	private static final long serialVersionUID = 1L;
	
	transient PropertyService propertyService;

	public PropertyListView(String id, PropertyService propertyService) {
		super(id, propertyService.getAllProperties());
		this.propertyService = propertyService;
	}
	
	@Override
	protected void populateItem(ListItem<Property> item) {
		item.add(new Label("propertyId", new PropertyModel<String>(item.getModel(), "id")));
		item.add(new Label("propertyName", new PropertyModel<String>(item.getModel(), "name")));
		item.add(new Label("companyId", new PropertyModel<String>(item.getModelObject().getOrganization(), "id")));
		item.add(new Label("companyName", new PropertyModel<String>(item.getModelObject().getOrganization(), "name")));
		item.add(deletePropertyLink(item));
	}
	
	private Link<String> deletePropertyLink(ListItem<Property> item) {
		return new Link<String>("deletePropertyLink"){
			private static final long serialVersionUID = 1L;
			@Override
			public void onClick() {
				propertyService.deleteProperty(item.getModelObject());
				getSession().info("Property deleted successfully.");
				setResponsePage(PropertyPage.class);
			}
		};
	}
}
