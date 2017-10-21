package com.equitativa.property;

import java.util.List;

import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.HiddenField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.equitativa.model.Organization;
import com.equitativa.model.Property;
import com.equitativa.organization.service.OrganizationService;
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
	
	@SpringBean
	transient OrganizationService organizationService;

	public PropertyForm(String id) {
		super(id);
		addPropertyId();
		addPropertyName();
		addCompanyDropDownMenu();
	}

	private void addCompanyDropDownMenu() {
		List<Organization> organizations = organizationService.getOrganizationNames();
		PropertyModel<Organization> organizationDropDownModel = new PropertyModel<Organization>(property, "organization");
		organizationDropDownModel.setObject(organizations.get(0));
		DropDownChoice<Organization> organizationDropDownChoice = new DropDownChoice<Organization>("companies", organizationDropDownModel, organizations, new ChoiceRenderer<Organization>("name", "id"));
		add(organizationDropDownChoice);
	}

	private void addPropertyName() {
		add(new TextField<String>("name", new PropertyModel<String>(property, "name")));
	}

	private void addPropertyId() {
		add(new HiddenField<String>("id", new PropertyModel<String>(property, "id")));
	}

	public void onSubmit() {
		boolean isUpdated = null != property.getId() ? true : false;
		propertyService.create(property);
		prepareFeedback(isUpdated);
		setResponsePage(PropertyPage.class);
	}

	private void prepareFeedback(boolean isUpdated) {
		if (isUpdated) {
			getSession().info("Property updated successfully.");
		} else {
			getSession().info("Property saved successfully.");
		}
	}

	public void onError() {

	}
}
