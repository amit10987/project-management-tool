package com.equitativa;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.equitativa.activity.ActivityPage;
import com.equitativa.employee.EmployeePage;
import com.equitativa.property.PropertyPage;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		add(new BookmarkablePageLink("activityPageLink", ActivityPage.class));
		add(new BookmarkablePageLink("propertyPageLink", PropertyPage.class));
		add(new BookmarkablePageLink("employeePageLink", EmployeePage.class));
		add(new Label("footer", ""));

    }
}
