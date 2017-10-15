package com.equitativa.activity;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.equitativa.activity.service.ActivityService;
import com.equitativa.model.Activity;

/**
 * @author amit
 *
 */
public class ActivityForm extends Form<Void> {

	private static final long serialVersionUID = 1L;

	private Activity activity = new Activity();
	
	@SpringBean
	transient ActivityService activityService;
	
	public ActivityForm(String id) {
		super(id);
		add(new TextField<String>("name", new PropertyModel<String>(activity, "name")));
	}

	public void onSubmit() {
		activityService.create(activity);
		activity = null;
		setResponsePage(ActivityPage.class, new PageParameters());
	}

	public void onError() {
		
	}
}
