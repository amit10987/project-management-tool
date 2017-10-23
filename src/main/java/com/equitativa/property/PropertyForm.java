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

	private static final String SAVED_SUCCESSFULLY = "Property saved successfully.";
	private static final String UPDATED_SUCCESSFULLY = "Property updated successfully.";
	private static final String ID = "id";
	private static final String NAME = "name";
	private static final String ORGANIZATION = "organization";
	
	private static final long serialVersionUID = 1L;

	private Property property = new Property();

	@SpringBean
	transient PropertyService propertyService;
	
	@SpringBean
	transient OrganizationService organizationService;

	/**
	 * @param id
	 */
	public PropertyForm(String id) {
		super(id);
		addPropertyId();
		addPropertyName();
		addCompanyDropDownMenu();
	}

	/**
	 * add company drop down
	 */
	private void addCompanyDropDownMenu() {
		List<Organization> organizations = organizationService.getOrganizationNames();
		PropertyModel<Organization> organizationDropDownModel = new PropertyModel<Organization>(property, ORGANIZATION);
		organizationDropDownModel.setObject(organizations.get(0));
		DropDownChoice<Organization> organizationDropDownChoice = new DropDownChoice<Organization>("companies", organizationDropDownModel, organizations, new ChoiceRenderer<Organization>(NAME, ID));
		add(organizationDropDownChoice);
	}

	/**
	 * Property name add
	 */
	private void addPropertyName() {
		TextField<String> name = new TextField<String>(NAME, new PropertyModel<String>(property, NAME));
		name.setRequired(true);
		add(name);
	}

	/**
	 * add id to track property
	 */
	private void addPropertyId() {
		add(new HiddenField<String>(ID, new PropertyModel<String>(property, ID)));
	}

	public void onSubmit() {
		boolean isUpdated = null != property.getId() ? true : false;
		propertyService.create(property);
		prepareFeedback(isUpdated);
		setResponsePage(PropertyPage.class);
	}

	/**
	 * @param isUpdated
	 */
	private void prepareFeedback(boolean isUpdated) {
		if (isUpdated) {
			getSession().info(UPDATED_SUCCESSFULLY);
		} else {
			getSession().info(SAVED_SUCCESSFULLY);
		}
	}

}
