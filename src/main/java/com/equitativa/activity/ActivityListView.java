package com.equitativa.activity;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.PropertyModel;

import com.equitativa.activity.service.ActivityService;
import com.equitativa.model.Activity;

/**
 * @author amit
 *
 */
public class ActivityListView extends ListView<Activity>{
	
	private static final long serialVersionUID = 1L;

	private transient ActivityService activityService;
	/**
	 * @param id
	 * @param activities
	 */
	public ActivityListView(String id, ActivityService activityService) {
		super(id, activityService.getAllActivities());
		this.activityService = activityService;
	}
	
	@Override
	protected void populateItem(ListItem<Activity> item) {
		item.add(new Label("activityId", new PropertyModel<String>(item.getModel(), "id")));
		item.add(new Label("activityName", new PropertyModel<String>(item.getModel(), "name")));
		item.add(addDeleteActiviyLink(item));
	}

	private Link<String> addDeleteActiviyLink(ListItem<Activity> item) {
		return new Link<String>("deleteActivityLink"){
			private static final long serialVersionUID = 1L;
			@Override
			public void onClick() {
				activityService.deleteActivity(item.getModelObject());
				getSession().info("Activity deleted successfully.");
				setResponsePage(ActivityPage.class);
			}
		};
	}
}
