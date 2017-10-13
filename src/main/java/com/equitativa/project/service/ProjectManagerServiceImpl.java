package com.equitativa.project.service;

import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.stereotype.Service;

import com.equitativa.model.Project;
import com.equitativa.project.repository.ProjectRepository;

/**
 * @author amit
 *
 */
@Service
public class ProjectManagerServiceImpl implements ProjectManagerService{

	@SpringBean
	ProjectRepository projectRepository;
	
	@Override
	public void create(Project project) {
		projectRepository.save(project);
	}
}
