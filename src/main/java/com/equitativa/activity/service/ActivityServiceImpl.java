package com.equitativa.activity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equitativa.activity.repository.ActivityRepository;
import com.equitativa.model.Activity;

/**
 * @author amit
 *
 */
@Service
public class ActivityServiceImpl implements ActivityService{

	@Autowired
	ActivityRepository activityRepository;
	
	@Override
	public void create(Activity activity) {
		activityRepository.save(activity);
	}

	@Override
	public List<Activity> getAllActivities() {
		return activityRepository.findAll();
	}
}
