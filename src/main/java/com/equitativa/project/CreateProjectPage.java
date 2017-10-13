package com.equitativa.project;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.equitativa.HomePage;
import com.equitativa.model.Organization;
import com.equitativa.organization.service.OrganizationService;

/**
 * @author amit
 *
 */
public class CreateProjectPage extends HomePage{

	private static final long serialVersionUID = 1L;
	
	@SpringBean
	OrganizationService organizationService;
	
	public CreateProjectPage(){
		this(new PageParameters());
	}
	
	public CreateProjectPage(PageParameters parameters) {
		super(parameters);
		Form form = new Form("form");
		addOrganizationDropDown(form);
		add(form);
	}

	private void addOrganizationDropDown(Form form) {
		DropDownChoice<String> organizationDropDown = new DropDownChoice<>("organization", new PropertyModel(this, "selected"), organizationService.getOrganizationNames());
		form.add(organizationDropDown);
	}
}
