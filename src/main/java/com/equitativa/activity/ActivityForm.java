package com.equitativa.activity;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.HiddenField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
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
		add(createActivityId());
		add(createActivityName());
	}

	private TextField<String> createActivityName() {
		TextField<String> activityName = new TextField<String>("name", new PropertyModel<String>(activity, "name"));
		activityName.setOutputMarkupId(true);
		return activityName;
	}

	private HiddenField<String> createActivityId() {
		return new HiddenField<String>("id", new PropertyModel<String>(activity, "id"));
	}
	
	public void onSubmit() {
		boolean isUpdated = null != activity.getId() ? true : false;
		activityService.create(activity);
		prepareFeedback(isUpdated);
		setResponsePage(ActivityPage.class);
	}

	private void prepareFeedback(boolean isUpdated) {
		if(isUpdated){
			getSession().info("Activity updated successfully.");
		}else{
			getSession().info("Activity saved successfully.");
		}
	}

	public void onError() {
		
	}
}
