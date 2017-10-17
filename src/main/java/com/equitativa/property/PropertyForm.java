package com.equitativa.property;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.HiddenField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.equitativa.activity.ActivityPage;
import com.equitativa.model.Property;
import com.equitativa.property.service.PropertyService;

/**
 * @author amit
 *
 */
public class PropertyForm extends Form<Void> {

	private static final long serialVersionUID = 1L;

	private Property property = new Property();
	
	@SpringBean
	transient PropertyService propertyService;
	
	public PropertyForm(String id) {
		super(id);
		add(createPropertyId());
		add(createPropertyName());
	}

	private TextField<String> createPropertyName() {
		return new TextField<String>("name", new PropertyModel<String>(property, "name"));
	}

	private HiddenField<String> createPropertyId() {
		return new HiddenField<String>("id", new PropertyModel<String>(property, "id"));
	}
	
	public void onSubmit() {
		boolean isUpdated = null != property.getId() ? true : false;
		propertyService.create(property);
		prepareFeedback(isUpdated);
		setResponsePage(ActivityPage.class);
	}

	private void prepareFeedback(boolean isUpdated) {
		if(isUpdated){
			getSession().info("Property updated successfully.");
		}else{
			getSession().info("Property saved successfully.");
		}
	}

	public void onError() {
		
	}
}
