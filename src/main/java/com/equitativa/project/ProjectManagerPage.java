package com.equitativa.project;

import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.equitativa.HomePage;

public class ProjectManagerPage extends HomePage{

	public ProjectManagerPage(PageParameters parameters) {
		super(parameters);
		add(new BookmarkablePageLink("createProjectPageLink", CreateProjectPage.class));
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
