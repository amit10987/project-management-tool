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
	 * Create activity
	 * 
	 * @param project
	 */
	@Transactional
	public void create(Activity activity);
	
	/**
	 * Get all actvities
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Activity> getAllActivities();

	/**
	 * @param activity
	 */
	@Transactional
	public void deleteActivity(Activity activity);
}
