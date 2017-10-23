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
	
	private static final String EMPLOYEE_PAGE_LINK = "employeePageLink";
	private static final String PROPERTY_PAGE_LINK = "propertyPageLink";
	private static final String ACTIVITY_PAGE_LINK = "activityPageLink";
	private static final String FOOTER = "footer";
	private static final String FEEDBACK_PANEL = "feedbackPanel";
	private static final String TODO_PAGE_LINK = "todoPageLink";

	/**
	 * @param parameters
	 */
	public HomePage(final PageParameters parameters) {
		super(parameters);

		add(new BookmarkablePageLink<String>(ACTIVITY_PAGE_LINK, ActivityPage.class));
		add(new BookmarkablePageLink<String>(PROPERTY_PAGE_LINK, PropertyPage.class));
		add(new BookmarkablePageLink<String>(EMPLOYEE_PAGE_LINK, EmployeePage.class));
		add(new BookmarkablePageLink<String>(TODO_PAGE_LINK, ToDoPage.class));
		add(new Label(FOOTER, CommonConstant.EMPTY_STRING));
		add(new FeedbackPanel(FEEDBACK_PANEL));
		
	}
}
