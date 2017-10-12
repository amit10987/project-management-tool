package com.equitativa;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.equitativa.project.ProjectManagerPage;
import com.equitativa.task.TaskManagerPage;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		//add(new Label("version", getApplication().getFrameworkSettings().getVersion()));

		// TODO Add your page's components here
		
		add(new BookmarkablePageLink("projectManagerPageLink", ProjectManagerPage.class));
		add(new BookmarkablePageLink("taskManagerPageLink", TaskManagerPage.class));
		add(new Label("footer", "This is in the footer"));

    }
}
