package com.equitativa.activity;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.equitativa.HomePage;

public class ActivityPage extends HomePage{

	public ActivityPage(PageParameters parameters) {
		super(parameters);
		
		/*
		 * Form form = new Form("form");
		addOrganizationDropDown(form);
		add(form);
		 List<String> organizations = organizationService.getOrganizationNames();
		Model<String> dropdownModel = new Model<>(organizations.get(0));
		DropDownChoice<String> organizationDropDown = new DropDownChoice<String>("organization", dropdownModel,	organizations);
		form.add(organizationDropDown);*/
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
