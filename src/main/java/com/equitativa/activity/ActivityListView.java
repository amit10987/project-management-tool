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
		item.add(new Label(ActivityConstant.ACTIVITY_ID, new PropertyModel<String>(item.getModel(), ActivityConstant.ID)));
		item.add(new Label(ActivityConstant.ACTIVITY_NAME, new PropertyModel<String>(item.getModel(), ActivityConstant.NAME)));
		item.add(deleteActivityLink(item));
	}

	private Link<String> deleteActivityLink(final ListItem<Activity> item) {
		return new Link<String>(ActivityConstant.DELETE_LINK){
			private static final long serialVersionUID = 1L;
			@Override
			public void onClick() {
				activityService.deleteActivity(item.getModelObject());
				getSession().info(ActivityConstant.DELETED_SUCCESS);
				setResponsePage(ActivityPage.class);
			}
		};
	}
}
