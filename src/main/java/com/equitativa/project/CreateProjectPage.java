package com.equitativa.project;

import java.util.List;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.equitativa.HomePage;
import com.equitativa.organization.service.OrganizationService;

/**
 * @author amit
 *
 */
public class CreateProjectPage extends HomePage {

	private static final long serialVersionUID = 1L;

	@SpringBean
	transient OrganizationService organizationService;

	public CreateProjectPage(PageParameters parameters) {
		super(parameters);
		Form form = new Form("form");
		addOrganizationDropDown(form);
		add(form);
	}

	private void addOrganizationDropDown(Form form) {
		List<String> organizations = organizationService.getOrganizationNames();
		Model<String> dropdownModel = new Model<>(organizations.get(0));
		DropDownChoice<String> organizationDropDown = new DropDownChoice<String>("organization", dropdownModel,	organizations);
		form.add(organizationDropDown);
	}
}
