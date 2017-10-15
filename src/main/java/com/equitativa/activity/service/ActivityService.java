package com.equitativa.activity.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.equitativa.model.Activity;

/**
 * @author amit
 *
 */
public interface ActivityService {

	/**
	 * @param project
	 */
	@Transactional
	public void create(Activity activity);
	
	@Transactional(readOnly = true)
	public List<Activity> getAllActivities();
}
