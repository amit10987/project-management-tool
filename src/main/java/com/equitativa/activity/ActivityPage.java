package com.equitativa.activity;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.equitativa.HomePage;
import com.equitativa.activity.service.ActivityService;

/**
 * @author amit
 *
 */
public class ActivityPage extends HomePage{

	private static final long serialVersionUID = 1L;
	
	@SpringBean
	transient ActivityService activityService;
	
	/**
	 * @param parameters
	 */
	public ActivityPage(PageParameters parameters) {
		super(parameters);
		ActivityForm activityForm = new ActivityForm("activityForm");
		add(activityForm);
		add(new ActivityListView("activities", activityService));
	}

}
