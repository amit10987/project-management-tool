package com.equitativa.activity.service;

import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.stereotype.Service;

import com.equitativa.activity.repository.ActivityRepository;
import com.equitativa.model.Activity;

/**
 * @author amit
 *
 */
@Service
public class ActivityServiceImpl implements ActivityService{

	@SpringBean
	ActivityRepository projectRepository;
	
	@Override
	public void create(Activity project) {
		projectRepository.save(project);
	}
}
