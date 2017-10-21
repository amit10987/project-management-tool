package com.equitativa;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.equitativa.activity.ActivityPage;
import com.equitativa.employee.EmployeePage;
import com.equitativa.property.PropertyPage;
import com.equitativa.todo.ToDoPage;

/**
 * @author amit
 *
 */
public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		add(new BookmarkablePageLink<String>("activityPageLink", ActivityPage.class));
		add(new BookmarkablePageLink<String>("propertyPageLink", PropertyPage.class));
		add(new BookmarkablePageLink<String>("employeePageLink", EmployeePage.class));
		add(new BookmarkablePageLink<String>("todoPageLink", ToDoPage.class));
		add(new Label("footer", ""));
		add(new FeedbackPanel("feedbackPanel"));
		
	}
}
