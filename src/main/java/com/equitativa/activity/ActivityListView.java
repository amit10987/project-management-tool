package com.equitativa.activity;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.PropertyModel;

import com.equitativa.model.Activity;

/**
 * @author amit
 *
 */
public class ActivityListView extends ListView<Activity>{
	
	private static final long serialVersionUID = 1L;

	/**
	 * @param id
	 * @param activities
	 */
	public ActivityListView(String id, List<Activity> activities) {
		super(id, activities);
	}
	
	@Override
	protected void populateItem(ListItem<Activity> item) {
		item.add(new Label("activityName", new PropertyModel<String>(item.getModel(), "name")));
	}

}
