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
	
	/**
	 * @param id
	 */
	public ActivityForm(String id) {
		super(id);
		add(createActivityId());
		add(createActivityName());
	}

	/**
	 * create activity name
	 * 
	 * @return
	 */
	private TextField<String> createActivityName() {
		TextField<String> activityName = new TextField<String>(ActivityConstant.NAME, new PropertyModel<String>(activity, ActivityConstant.NAME));
		activityName.setRequired(true);
		activityName.setOutputMarkupId(true);
		return activityName;
	}

	/**
	 * Create hiddenField ActivityId
	 * 
	 * @return
	 */
	private HiddenField<String> createActivityId() {
		return new HiddenField<String>(ActivityConstant.ID, new PropertyModel<String>(activity, ActivityConstant.ID));
	}
	
	public void onSubmit() {
		boolean isUpdated = null != activity.getId() ? true : false;
		activityService.create(activity);
		prepareFeedback(isUpdated);
		setResponsePage(ActivityPage.class);
	}

	/**
	 * @param isUpdated
	 */
	private void prepareFeedback(boolean isUpdated) {
		if(isUpdated){
			getSession().info(ActivityConstant.UPDATED_SUCCESS);
		}else{
			getSession().info(ActivityConstant.SAVED_SUCCESS);
		}
	}
}
